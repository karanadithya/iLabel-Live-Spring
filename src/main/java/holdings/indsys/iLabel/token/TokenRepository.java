package holdings.indsys.iLabel.token;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends MongoRepository<Token, String> {

  @Query(value = "{$and: [{ $or: [{expired: ?0}, {revoked: ?1}]}, {userId: ?2}]}")
  List<Token> findAllValidTokenByUser(boolean expired, boolean revoked, String userId);

  Optional<Token> findByToken(String token);

}
