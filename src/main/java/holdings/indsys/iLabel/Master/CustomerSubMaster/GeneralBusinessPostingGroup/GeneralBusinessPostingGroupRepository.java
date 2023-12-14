package holdings.indsys.iLabel.Master.CustomerSubMaster.GeneralBusinessPostingGroup;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralBusinessPostingGroupRepository extends MongoRepository<GeneralBusinessPostingGroup, ObjectId> {
}
