package holdings.indsys.iLabel.Master.ItemSubMaster.GSTGroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "GST-Group")
public class GstGroup {
    @MongoId
    private ObjectId id;
    private String gstGroupType;
    private String gstPlaceOfSupply;
    private String description;
    private String reverseCharge;
}
