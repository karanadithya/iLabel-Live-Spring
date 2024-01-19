package holdings.indsys.iLabel.Master.ItemSubMaster.GSTGroup;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GstGroupRepository extends MongoRepository<GstGroup, String> {
}
