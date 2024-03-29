package holdings.indsys.iLabel.Master.CustomerSubMaster.PaymentTerm;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTermRepository extends MongoRepository<PaymentTerm, ObjectId> {
}
