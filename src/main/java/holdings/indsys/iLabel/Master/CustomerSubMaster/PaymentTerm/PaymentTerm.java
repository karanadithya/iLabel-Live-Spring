package holdings.indsys.iLabel.Master.CustomerSubMaster.PaymentTerm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PaymentTerm")
public class PaymentTerm {
    @MongoId
    private ObjectId id;
    private String code;
    private String dueDateCalculation;
    private String discountDateCalculation;
    private String discountPercentage;
    private String description;
    private String calcPmtDiscOnCrMemos;
}
