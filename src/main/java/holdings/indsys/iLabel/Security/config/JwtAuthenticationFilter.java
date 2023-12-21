package holdings.indsys.iLabel.Security.config;

import holdings.indsys.iLabel.Security.token.TokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtService jwtService;
  private final UserDetailsService userDetailsService;
  private final TokenRepository tokenRepository;

  /**
   * This method is responsible for filtering incoming requests and handling authentication.
   * If the request path contains "/api/v1/auth", the filter chain is not applied.
   * Otherwise, the method checks for a valid JWT token in the request's Authorization header.
   * If the token is valid, the user details are loaded and authentication is set in the security context.
   * Finally, the filter chain is applied to the request.
   *
   * @param request       the incoming HTTP request
   * @param response      the HTTP response
   * @param filterChain  the chain of filters to be applied
   * @throws ServletException if there is a servlet error
   * @throws IOException      if there is an I/O error
   */
  @Override
  protected void doFilterInternal(
          @NonNull HttpServletRequest request,
          @NonNull HttpServletResponse response,
          @NonNull FilterChain filterChain
  ) throws ServletException, IOException {
    // Skip authentication for "/api/v1/auth" path
    if (request.getServletPath().contains("/api/v1/auth")) {
      filterChain.doFilter(request, response);
      return;
    }

    final String authHeader = request.getHeader("Authorization");

    // Skip authentication if Authorization header is missing or doesn't start with "Bearer "
    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }

    // Extract JWT token from Authorization header
    final String jwt = authHeader.substring(7);

    // Extract user email from JWT token
    final String userEmail = jwtService.extractUsername(jwt);

    // Set authentication if user email is not null and authentication is not already set
    if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);

      // Check if the token is valid and not expired or revoked
      var isTokenValid = tokenRepository.findByToken(jwt)
              .map(t -> !t.isExpired() && !t.isRevoked())
              .orElse(false);

      if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
        );
        authToken.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );
        SecurityContextHolder.getContext().setAuthentication(authToken);
      }
    }

    // Apply the filter chain to the request
    filterChain.doFilter(request, response);
  }
}
