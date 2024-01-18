package holdings.indsys.iLabel.BOM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ProductionBOM")
public class ProductionBOM {

    @MongoId
    private String id;
    private String productionBOMNo;
    private String description;
    private String description2;
    private String searchName;
    private String unitOfMeasureCode;
    private String lowLevelCode;
    private String creationDate;
    private String lastDateModified;
    private String status;
    private String versionNos;
    private String noSeries;
    private List<LineItem> lineItems;
}
