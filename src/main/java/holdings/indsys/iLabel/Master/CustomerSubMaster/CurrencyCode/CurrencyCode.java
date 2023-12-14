package holdings.indsys.iLabel.Master.CustomerSubMaster.CurrencyCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CurrencyCode")
public class CurrencyCode {
    @MongoId
    private ObjectId id;
    @Indexed(unique = true)
    private String code;
    private String iso_code;
    private String description;

}
