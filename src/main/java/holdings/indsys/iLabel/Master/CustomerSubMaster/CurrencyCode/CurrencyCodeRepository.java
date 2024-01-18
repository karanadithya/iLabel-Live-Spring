package holdings.indsys.iLabel.Master.CustomerSubMaster.CurrencyCode;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyCodeRepository extends MongoRepository<CurrencyCode, ObjectId> {
}
