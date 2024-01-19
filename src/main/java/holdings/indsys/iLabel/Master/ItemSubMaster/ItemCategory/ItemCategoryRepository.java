package holdings.indsys.iLabel.Master.ItemSubMaster.ItemCategory;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCategoryRepository extends MongoRepository<ItemCategory, ObjectId> {
}
