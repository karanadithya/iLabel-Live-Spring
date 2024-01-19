package holdings.indsys.iLabel.Master.ItemSubMaster.HsnSac;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HsnSacRepository extends MongoRepository<HsnSac, ObjectId> {
}
