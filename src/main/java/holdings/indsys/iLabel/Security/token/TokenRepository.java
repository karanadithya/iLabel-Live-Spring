package holdings.indsys.iLabel.Security.token;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends MongoRepository<Token, String> {
  /**
   * Finds all valid tokens for a given user.
   *
   * @param expired Whether to include expired tokens.
   * @param revoked Whether to include revoked tokens.
   * @param userId The ID of the user.
   * @return A list of valid tokens.
   */
  @Query(value = "{$and: [{ $or: [{expired: ?0}, {revoked: ?1}]}, {userId: ?2}]}")
  List<Token> findAllValidTokenByUser(boolean expired, boolean revoked, String userId);

  /**
   * Finds a token by its value.
   *
   * @param token the value of the token to find
   * @return an Optional containing the found token, or an empty Optional if no token is found
   */
  Optional<Token> findByToken(String token);
}
