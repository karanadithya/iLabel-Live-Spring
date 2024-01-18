package holdings.indsys.iLabel.Master.CustomerSubMaster.CustomerPostingGroup;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerPostingGroupRepository extends MongoRepository<CustomerPostingGroup, ObjectId> {
}
