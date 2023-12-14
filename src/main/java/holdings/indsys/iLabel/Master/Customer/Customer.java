package holdings.indsys.iLabel.Master.Customer;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Customer")
public class Customer {
    @MongoId
    private ObjectId id;
    private String name;

}
