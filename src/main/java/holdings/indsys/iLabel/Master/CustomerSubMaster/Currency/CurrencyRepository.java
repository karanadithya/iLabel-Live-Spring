package holdings.indsys.iLabel.Master.CustomerSubMaster.Currency;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends MongoRepository<Currency, ObjectId> {
}
