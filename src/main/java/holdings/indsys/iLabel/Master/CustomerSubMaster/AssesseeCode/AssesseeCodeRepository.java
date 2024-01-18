package holdings.indsys.iLabel.Master.CustomerSubMaster.AssesseeCode;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssesseeCodeRepository extends MongoRepository<AssesseeCode, ObjectId> {
}
