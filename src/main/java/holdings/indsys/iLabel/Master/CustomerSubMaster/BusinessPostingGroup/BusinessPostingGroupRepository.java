package holdings.indsys.iLabel.Master.CustomerSubMaster.BusinessPostingGroup;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessPostingGroupRepository extends MongoRepository<BusinessPostingGroup, ObjectId> {
}
