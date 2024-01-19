package holdings.indsys.iLabel.Master.ItemSubMaster.GenProductPostingGroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "GenProductPostingGroup")
public class GenProductPostingGroup {
    @MongoId
    private ObjectId id;
    private String code;
    private String description;
}
