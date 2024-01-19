package holdings.indsys.iLabel.Master.ItemSubMaster.UnitOfMeasure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "UnitOfMeasure")
public class UnitOfMeasure {

    @MongoId
    private ObjectId id;
    @Indexed(unique = true)
    private String code;
    private String description;
    private String internationalStandardCode;

}
