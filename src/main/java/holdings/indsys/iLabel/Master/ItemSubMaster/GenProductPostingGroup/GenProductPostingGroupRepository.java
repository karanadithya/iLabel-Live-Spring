package holdings.indsys.iLabel.Master.ItemSubMaster.GenProductPostingGroup;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenProductPostingGroupRepository extends
        MongoRepository<GenProductPostingGroup, ObjectId> {
}
