package holdings.indsys.iLabel.BOM.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItemDAO {
    private String ProductionBOMNo;
    private String versionCode;
    private String lineNo;
    private String type;
    private String no;
    private String description;
    private String unitMeasureCode;
    private String quantity;
    private String position;
    private String position2;
    private String position3;
    private String leadTimeOffset;
    private String routineLinkCode;
    private String scrapPercentage;
    private String variantCode;
    private String startingDate;
    private String endingDate;
    private String length;
    private String width;
    private String weight;
    private String depth;
    private String calculationFormula;
    private String quantityPer;
    private String principalInput;
    private String color;
    private String denier;
}
