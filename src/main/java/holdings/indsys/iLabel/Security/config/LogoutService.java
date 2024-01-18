package holdings.indsys.iLabel.Security.config;

import holdings.indsys.iLabel.Security.token.Token;
import holdings.indsys.iLabel.Security.token.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

  private final TokenRepository tokenRepository;

  /**
   * Logs out the user by invalidating the JWT token and clearing the security context.
   *
   * @param request The HTTP servlet request.
   * @param response The HTTP servlet response.
   * @param authentication The authentication object.
   */
  @Override
  public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
    // Get the Authorization header from the request
    final String authHeader = request.getHeader("Authorization");

    // Check if the Authorization header exists and starts with "Bearer "
    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      return;
    }

    // Extract the JWT token from the Authorization header
    String jwt = authHeader.substring(7);

    // Find the stored token in the token repository
    final Token storedToken = tokenRepository.findByToken(jwt).orElse(null);

    // If the token exists, mark it as expired and revoked, and save it to the repository
    if (storedToken != null) {
      storedToken.setExpired(true);
      storedToken.setRevoked(true);
      tokenRepository.save(storedToken);

      // Clear the security context
      SecurityContextHolder.clearContext();
    }
  }
}
