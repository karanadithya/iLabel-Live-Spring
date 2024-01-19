package holdings.indsys.iLabel.Master.ItemSubMaster.HsnSac;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "HSN_SAC")
public class HsnSac {
    @MongoId
    private ObjectId id;
    private String code;
    private String gstGroupCode;
    private String description;
    private String type;
}
