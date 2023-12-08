package holdings.indsys.iLabel.Master.CustomerSubMaster.State;

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
@Document(collection = "State")
public class State {
    @MongoId
    private ObjectId id;
    private String code;
    private String description;
    private String stateCodeTDS;
    private String stateCodeGST;
}
