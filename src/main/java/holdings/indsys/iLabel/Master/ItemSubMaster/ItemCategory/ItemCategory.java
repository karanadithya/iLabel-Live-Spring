package holdings.indsys.iLabel.Master.ItemSubMaster.ItemCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "ItemCategory")
public class ItemCategory {
    @MongoId
    private ObjectId id;
    private String code;
    private String parentCategory;
    private String description;
    private String indentation;
    private String presentationOrder;
    private String hasChildren;
}
