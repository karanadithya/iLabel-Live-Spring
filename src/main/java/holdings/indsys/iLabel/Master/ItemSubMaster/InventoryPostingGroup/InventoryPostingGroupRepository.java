package holdings.indsys.iLabel.Master.ItemSubMaster.InventoryPostingGroup;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryPostingGroupRepository extends MongoRepository<InventoryPostingGroup, ObjectId> {
}
