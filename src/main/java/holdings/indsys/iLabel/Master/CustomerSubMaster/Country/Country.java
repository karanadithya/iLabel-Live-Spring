package holdings.indsys.iLabel.Master.CustomerSubMaster.Country;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Country")
public class Country {
    @MongoId
    private ObjectId id;
    private String code;
    private String name;
    private String isoCode;
    private Number isoNumericCode;
    private String eUCountryRegionCode;
    private String intrastateCode;
    private String addressFormat;
    private String contactAddressFormat;
}
