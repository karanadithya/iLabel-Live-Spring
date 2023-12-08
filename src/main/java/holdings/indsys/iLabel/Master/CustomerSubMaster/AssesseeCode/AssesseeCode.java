package holdings.indsys.iLabel.Master.CustomerSubMaster.AssesseeCode;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "AssesseeCode")
public class AssesseeCode {
    @MongoId
    private ObjectId id;
    private String description;
    private String type;
}
