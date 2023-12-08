package holdings.indsys.iLabel.Master.CustomerSubMaster.Currency;

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
@Document(collection = "Currency")
public class Currency {
    @MongoId
    private ObjectId id;
    private String lastDateModified;
    private String lastDateAdjusted;
    private String isoCode;
    private String isoNumericCode;
    private String unrealizedGainsAcc;
    private String realizedGainsAcc;
    private String unrealizedLossesAcc;
    private String realizedLossesAcc;
    private String invoiceRoundingPrecision;
    private String invoiceRoundingType;
    private String amountRoundingPrecision;
    private String unitAmountRoundingPrecision;
    private String description;
    private String amountDecimalPlaces;
    private String unitAmountDecimalPlaces;
    private String realizedGLGainsAccount;
    private String realizedGLLossesAccount;
    private String applnRoundingPrecision;
    private String emuCurrency;
    private String currencyFactor;
    private String residualGainsAccount;
    private String residualLossesAccount;
    private String paymentTolerancePercentage;
}
