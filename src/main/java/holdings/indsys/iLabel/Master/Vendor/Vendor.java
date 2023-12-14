package holdings.indsys.iLabel.Master.Vendor;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Vendor")
public class Vendor {
    @MongoId
    private ObjectId id;
    private String name;
}
