package holdings.indsys.iLabel.Master.ItemSubMaster.UnitOfMeasure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "UnitOfMeasure")
public class UnitOfMeasure {

    @MongoId
    private ObjectId id;
    private String code;
    private String description;
    private String internationalStandardCode;

}
