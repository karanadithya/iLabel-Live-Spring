package holdings.indsys.iLabel.Security.config;

import holdings.indsys.iLabel.Security.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;
    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;
    @Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshExpiration;

    /**
     * Extracts the username from a token.
     *
     * @param token the token from which to extract the username
     * @return the username extracted from the token
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extracts a claim from a token using a claims resolver function.
     *
     * @param token          The token to extract the claim from.
     * @param claimsResolver The function that resolves the claim from the token's claims.
     * @return The resolved claim.
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        // Extract all claims from the token
        final Claims claims = extractAllClaims(token);
        // Resolve the claim using the provided claims resolver function
        return claimsResolver.apply(claims);
    }

    /**
     * Generates a token for the given user details.
     *
     * @param userDetails The user details.
     * @return The generated token.
     */
    public String generateToken(User userDetails) {
        // Call the overloaded generateToken method with an empty map
        return generateToken(new HashMap<>(), userDetails);
    }

    /**
     * Generates a token with the given extra claims and user details.
     *
     * @param extraClaims the additional claims to include in the token
     * @param userDetails the user details for whom the token is generated
     * @return the generated token
     */
    public String generateToken(Map<String, Object> extraClaims, User userDetails) {
        extraClaims.put("firstName", userDetails.getFirstname());
        extraClaims.put("lastName", userDetails.getLastname());
        extraClaims.put("phoneNumber", userDetails.getPhoneNumber());
        extraClaims.put("role", userDetails.getRole());
        return buildToken(extraClaims, userDetails, jwtExpiration);
    }

    /**
     * Generates a refresh token for the given user details.
     *
     * @param userDetails the user details
     * @return the refresh token
     */
    public String generateRefreshToken(User userDetails) {
        return buildToken(new HashMap<>(), userDetails, refreshExpiration);
    }

    /**
     * Builds a JWT token with the given extra claims, user details, and expiration time.
     *
     * @param extraClaims the additional claims to include in the token
     * @param userDetails the user details of the authenticated user
     * @param expiration  the expiration time in milliseconds
     * @return the JWT token as a string
     */
    private String buildToken(Map<String, Object> extraClaims, User userDetails, long expiration) {
        // Create a new JWT builder
        JwtBuilder jwtBuilder = Jwts.builder();


        // Set the claims
        jwtBuilder.claims(extraClaims);

        // Set the subject
        jwtBuilder.subject(userDetails.getUsername());

        // Set the issued at time to the current date
        jwtBuilder.issuedAt(new Date());

        // Set the expiration time
        jwtBuilder.expiration(new Date(System.currentTimeMillis() + expiration));

        // Sign the token with the signing key
        jwtBuilder.signWith(getSignInKey());

        // Compact and return the token
        return jwtBuilder.compact();
    }

    /**
     * Check if a token is valid for a given user details.
     *
     * @param token       The token to check
     * @param userDetails The user details to compare the token with
     * @return True if the token is valid for the user details, false otherwise
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        // Extract the username from the token
        final String username = extractUsername(token);

        // Check if the extracted username matches the username in the user details
        // and if the token is not expired
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    /**
     * Checks if a given token is expired.
     *
     * @param token The token to check.
     * @return True if the token is expired, false otherwise.
     */
    private boolean isTokenExpired(String token) {
        // Extract the expiration date from the token
        Date expirationDate = extractExpiration(token);

        // Check if the expiration date is before the current date
        Date currentDate = new Date();

        return expirationDate.before(currentDate);
    }

    /**
     * Extracts the expiration date from a token.
     *
     * @param token the token from which to extract the expiration date
     * @return the expiration date extracted from the token
     */
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


    /**
     * Extracts all claims from the given JWT token.
     *
     * @param token The JWT token to extract claims from.
     * @return The extracted claims.
     */
    private Claims extractAllClaims(String token) {
        SecretKey secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
        return Jwts
                .parser()
                .verifyWith(secret)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    /**
     * Retrieves the sign-in key for authentication.
     *
     * @return The sign-in key.
     */
    private Key getSignInKey() {
        // Decode the secret key from Base64
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        // Generate the HMAC SHA key from the decoded key bytes
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
