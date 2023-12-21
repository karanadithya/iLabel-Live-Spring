package holdings.indsys.iLabel.Security.config;

import holdings.indsys.iLabel.Security.user.User;
import holdings.indsys.iLabel.Security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

  private final UserRepository repository;

  /**
   * Returns an implementation of the UserDetailsService interface.
   *
   * @return an implementation of the UserDetailsService interface
   */
  @Bean
  public UserDetailsService userDetailsService() {
    return username -> {
      // Find the user by email
      Optional<User> userOptional = repository.findByEmail(username);

      // If user not found, throw an exception
      if (userOptional.isEmpty()) {
        throw new UsernameNotFoundException("User not found");
      }

      return userOptional.get();
    };
  }

  /**
   * Creates and configures the authentication provider.
   * @return The authentication provider.
   */
  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  /**
   * Creates an instance of the AuthenticationManager.
   *
   * @param config The AuthenticationConfiguration object.
   * @return The AuthenticationManager instance.
   * @throws Exception If an error occurs during the creation of the AuthenticationManager.
   */
  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
  }
  /**
   * Returns a BCryptPasswordEncoder instance for password encoding.
   *
   * @return the BCryptPasswordEncoder instance
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
