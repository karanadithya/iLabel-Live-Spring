package holdings.indsys.iLabel.Master.ItemSubMaster.RoutingHeader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoutingHeaderRequest {
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
