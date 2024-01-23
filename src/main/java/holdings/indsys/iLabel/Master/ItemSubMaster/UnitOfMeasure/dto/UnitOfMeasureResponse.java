package holdings.indsys.iLabel.Master.ItemSubMaster.UnitOfMeasure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitOfMeasureResponse {
    private String id;
    private String code;
    private String description;
    private String internationalStandardCode;
}
