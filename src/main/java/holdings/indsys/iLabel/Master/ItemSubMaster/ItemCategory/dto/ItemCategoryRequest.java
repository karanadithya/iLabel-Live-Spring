package holdings.indsys.iLabel.Master.ItemSubMaster.ItemCategory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCategoryRequest {
    private ObjectId id;
    private String code;
    private String parentCategory;
    private String description;
    private String indentation;
    private String presentationOrder;
    private String hasChildren;
}
