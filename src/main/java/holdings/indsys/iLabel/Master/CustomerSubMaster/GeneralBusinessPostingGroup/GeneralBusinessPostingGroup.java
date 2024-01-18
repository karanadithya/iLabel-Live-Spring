package holdings.indsys.iLabel.Master.CustomerSubMaster.GeneralBusinessPostingGroup;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "GeneralBusinessPostingGroup")
public class GeneralBusinessPostingGroup {
    @MongoId
    private ObjectId id;
    @Indexed(unique = true)
    private String code;
    private String description;
}
