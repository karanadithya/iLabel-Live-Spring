package holdings.indsys.iLabel.Master.ItemSubMaster.RoutingLine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "RoutingLine")
public class RoutingLine {

    @MongoId
    private ObjectId id;
    private String routingNo;
    private String versionCode;
    private String operationNo;
    private String nextOperationNo;
    private String previousOperationNo;
    private String type;
    private String no;
    private String workCenterNo;
    private String workCenterGroupCode;
    private String description;
    private String setupTime;
    private String runTime;
    private String waitTime;
    private String moveTime;
    private String fixedScrapQuantity;
    private String lotSize;
    private String scrapFactorPercentage;
    private String setupTimeUnitCode;
    private String runTimeUnitCode;
    private String waitTimeUnitCode;
    private String moveTimeUnitCode;
    private String minimumProcessTime;
    private String maximumProcessTime;
    private String concurrentCapacities;
    private String sendAheadQuantity;
    private String routingLinkCode;
    private String standardTaskCode;
    private String unitCostPer;
    private String recalculate;
    private String sequenceNoForward;
    private String sequenceNoBackward;
    private String fixedScrapQuantityAccumulated;
    private String scrapFactorPercentageAccumulated;
}
