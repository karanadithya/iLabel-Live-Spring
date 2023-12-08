package holdings.indsys.iLabel.Master.CustomerSubMaster.BusinessPostingGroup;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "BusinessPostingGroup")
public class BusinessPostingGroup {
    @MongoId
    private ObjectId id;
    private String code;
    private String description;
    private String defVatBusPostingGroup;
}
