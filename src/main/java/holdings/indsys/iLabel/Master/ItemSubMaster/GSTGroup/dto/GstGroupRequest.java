package holdings.indsys.iLabel.Master.ItemSubMaster.GSTGroup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GstGroupRequest {
    private ObjectId id;
    private String gstGroupType;
    private String gstPlaceOfSupply;
    private String description;
    private String reverseCharge;
}
