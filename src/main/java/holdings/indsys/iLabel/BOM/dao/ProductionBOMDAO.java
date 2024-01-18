package holdings.indsys.iLabel.BOM.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionBOMDAO {
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
}
