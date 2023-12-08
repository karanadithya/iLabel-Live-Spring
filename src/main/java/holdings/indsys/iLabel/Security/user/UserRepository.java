package holdings.indsys.iLabel.Security.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

  @Query(value = "{'email':?0}")
  Optional<User> findByEmail(String email);
}
