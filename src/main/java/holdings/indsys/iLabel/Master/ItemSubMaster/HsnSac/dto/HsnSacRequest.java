package holdings.indsys.iLabel.Master.ItemSubMaster.HsnSac.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HsnSacRequest {
    private ObjectId id;
    private String code;
    private String gstGroupCode;
    private String description;
    private String type;
}
