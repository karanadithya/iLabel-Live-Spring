package holdings.indsys.iLabel.Master.ItemSubMaster.RoutingHeader;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "RoutingHeader")
public class RoutingHeader {
    @MongoId
    private ObjectId id;
    private String routingNo;
    private String description;
    private String description2;
    private String searchDescription;
    private String lastDateModified;
    private String status;
    private String type;
    private String versionNo;
    private String noSeries;
}
