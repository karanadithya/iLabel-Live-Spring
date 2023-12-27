package holdings.indsys.iLabel.Security.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    /**
     * Registers a new user.
     *
     * @param request the registration request containing user information
     * @return the response entity with the authentication response
     */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        // Register the user using the provided request
        return ResponseEntity.ok(service.register(request));
    }

    /**
     * Authenticates a user based on the provided authentication request.
     *
     * @param request The authentication request containing user credentials.
     * @return The response entity containing the authentication response.
     */
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }


    /**
     * Authenticates a user based on the Authorization header.
     *
     * @param authorizationHeader The Authorization header value.
     * @return A ResponseEntity containing the authentication result.
     */
    @PostMapping("/APIAuthenticate")
    public ResponseEntity<?> authenticateByHeader(
            @RequestHeader(value = "Authorization") String authorizationHeader
    ) {
        // Create an AuthenticationRequest object
        AuthenticationRequest request = new AuthenticationRequest();

        // Extract the encoded header value
        String encodedHeader = authorizationHeader.substring(6);

        // Decode the header value
        byte[] decodedHeader = Base64.getDecoder().decode(encodedHeader);
        String decodedString = new String(decodedHeader);

        // Split the decoded string into email and password
        String[] credentials = decodedString.split(":");

        // Set the email and password in the request object
        request.setEmail(credentials[0]);
        request.setPassword(credentials[1]);

        // Authenticate the user and return the result
        return ResponseEntity.ok(service.authenticate(request));
    }

    /**
     * Authenticates a user by their phone number using OTP.
     *
     * @param request the authentication request containing the user's phone number and OTP code
     * @return a ResponseEntity with the authentication result
     */
    @PostMapping("/otpLogin")
    public ResponseEntity<?> authenticateByPhoneNumber(@RequestBody AuthenticationRequestPhone request) {
        // Call the service to authenticate the user by phone number
        return ResponseEntity.ok(service.authenticateByPhone(request));
    }

    @GetMapping("/sendOTP/{phoneNumber}")
    public ResponseEntity<?> sendOTP(@PathVariable String phoneNumber) throws Exception {
        // Call the service to authenticate the user by phone number
        return ResponseEntity.ok(service.sendOTP(phoneNumber));
    }


    /**
     * Refreshes the authentication token.
     *
     * @param request  the HTTP request
     * @param response the HTTP response
     * @throws IOException if an I/O error occurs
     */
    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }


}
