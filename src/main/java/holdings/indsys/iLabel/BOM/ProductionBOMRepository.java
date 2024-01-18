package holdings.indsys.iLabel.BOM;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionBOMRepository extends MongoRepository<ProductionBOM, ObjectId> {
    ProductionBOM findByProductionBOMNo(String productionBOMNo);
}
