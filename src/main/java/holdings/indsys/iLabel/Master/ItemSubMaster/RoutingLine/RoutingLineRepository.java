package holdings.indsys.iLabel.Master.ItemSubMaster.RoutingLine;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutingLineRepository extends MongoRepository<RoutingLine, ObjectId> {
}
