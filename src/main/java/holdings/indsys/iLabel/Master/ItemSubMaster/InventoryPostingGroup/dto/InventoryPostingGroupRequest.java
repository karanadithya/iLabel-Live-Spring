package holdings.indsys.iLabel.Master.ItemSubMaster.InventoryPostingGroup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryPostingGroupRequest {
    private ObjectId id;
    private String code;
    private String description;
}
