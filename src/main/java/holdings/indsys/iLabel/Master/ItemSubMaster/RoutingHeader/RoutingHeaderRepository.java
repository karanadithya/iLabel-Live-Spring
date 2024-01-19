package holdings.indsys.iLabel.Master.ItemSubMaster.RoutingHeader;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutingHeaderRepository extends MongoRepository<RoutingHeader, ObjectId> {
}
