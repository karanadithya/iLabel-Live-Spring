package holdings.indsys.iLabel.Security.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import holdings.indsys.iLabel.Security.config.JwtService;
import holdings.indsys.iLabel.Security.token.Token;
import holdings.indsys.iLabel.Security.token.TokenRepository;
import holdings.indsys.iLabel.Security.token.TokenType;
import holdings.indsys.iLabel.Security.user.User;
import holdings.indsys.iLabel.Security.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  /**
   * Registers a new user and returns the authentication response.
   *
   * @param request The register request containing user information.
   * @return The authentication response with access and refresh tokens.
   */
  public AuthenticationResponse register(RegisterRequest request) {
    // Create a new User object with the provided user information
    var user = User.builder()
            .firstname(request.getFirstname())
            .lastname(request.getLastname())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(request.getRole())
            .build();

    // Save the user in the repository
    var savedUser = repository.save(user);

    // Generate a JWT access token and refresh token for the user
    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);

    // Save the user token in the database
    saveUserToken(savedUser, jwtToken);

    // Create and return the authentication response with the access and refresh tokens
    return AuthenticationResponse.builder()
            .accessToken(jwtToken)
            .refreshToken(refreshToken)
            .build();
  }

  /**
   * Authenticates a user based on the provided request.
   *
   * @param request The authentication request containing the user's email and password.
   * @return The authentication response containing the access token and refresh token.
   * @throws AuthenticationException If the authentication fails.
   */
  public AuthenticationResponse authenticate(AuthenticationRequest request) throws AuthenticationException {
    // Authenticate the user
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
    );

    // Find the user in the repository
    var user = repository.findByEmail(request.getEmail())
            .orElseThrow();

    // Generate the JWT token and refresh token for the user
    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);

    // Revoke all existing tokens for the user
    revokeAllUserTokens(user);

    // Save the user's token
    saveUserToken(user, jwtToken);

    // Return the authentication response
    return AuthenticationResponse
            .builder()
            .accessToken(jwtToken)
            .refreshToken(refreshToken)
            .build();
  }

  public AuthenticationResponse authenticateByPhone(AuthenticationRequest request) {


    var user = repository.findByphoneNumber(request.getEmail()).orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);

    return AuthenticationResponse
            .builder()
            .accessToken(jwtToken)
            .refreshToken(refreshToken)
            .build();
  }

  /**
   * Saves the user's JWT token to the token repository.
   *
   * @param user The user whose token is being saved.
   * @param jwtToken The JWT token to be saved.
   */
  private void saveUserToken(User user, String jwtToken) {
    // Create a new token with the given user and token details
    var token = Token.builder()
            .user(user)
            .token(jwtToken)
            .tokenType(TokenType.BEARER)
            .expired(false)
            .revoked(false)
            .build();

    // Save the token to the token repository
    tokenRepository.save(token);
  }

  /**
   * Revoke all tokens for a given user.
   *
   * @param user The user for which to revoke tokens.
   */
  private void revokeAllUserTokens(User user) {
    // Find all valid tokens for the user
    var validUserTokens = tokenRepository.findAllValidTokenByUser(false, false, user.getId());

    // If no valid tokens are found, return early
    if (validUserTokens.isEmpty()) {
      return;
    }

    // Set the expired and revoked flags for each token
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });

    // Save the updated tokens
    tokenRepository.saveAll(validUserTokens);
  }

  /**
   * Refreshes the access token by generating a new access token and updating the user's token information.
   *
   * @param request  The HTTP request object.
   * @param response The HTTP response object.
   * @throws IOException If an I/O error occurs.
   */
  public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Get the authorization header from the request
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    final String refreshToken;
    final String userEmail;

    // Check if the authorization header is present and starts with "Bearer "
    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      return;
    }

    // Extract the refresh token from the authorization header
    refreshToken = authHeader.substring(7);

    // Extract the user email from the refresh token
    userEmail = jwtService.extractUsername(refreshToken);

    // Check if the user email is not null
    if (userEmail != null) {
      // Find the user by email
      var user = this.repository.findByEmail(userEmail)
              .orElseThrow();

      // Check if the refresh token is valid for the user
      if (jwtService.isTokenValid(refreshToken, user)) {
        // Generate a new access token
        var accessToken = jwtService.generateToken(user);

        // Revoke all user tokens
        revokeAllUserTokens(user);

        // Save the user token
        saveUserToken(user, accessToken);

        // Build the authentication response
        var authResponse = AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

        // Write the authentication response to the response output stream
        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
      }
    }
  }
}
