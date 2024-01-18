package holdings.indsys.iLabel.Master.ItemSubMaster.UnitOfMeasure;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitOfMeasureRepository extends MongoRepository<UnitOfMeasure, ObjectId> {
}
