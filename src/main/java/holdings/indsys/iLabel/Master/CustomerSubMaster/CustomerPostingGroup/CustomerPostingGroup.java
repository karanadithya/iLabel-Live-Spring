package holdings.indsys.iLabel.Master.CustomerSubMaster.CustomerPostingGroup;

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
@Document(collection = "CustomerPostingGroup")
public class CustomerPostingGroup {
    @MongoId
    private ObjectId id;
    private String code;
    private String receivablesAccount;
    private String serviceChargeAcc;
    private String paymentDiscDebitAcc;
    private String invoiceRoundingAccount;
    private String additionalFeeAccount;
    private String interestAccount;
    private String debitCurrApplnRndgAcc;
    private String creditCurrApplnRndgAcc;
    private String debitRoundingAccount;
    private String creditRoundingAccount;
    private String paymentDiscCreditAcc;
    private String paymentToleranceDebitAcc;
    private String paymentToleranceCreditAcc;
    private String addFeeperLineAccount;
    private String Description;
}
