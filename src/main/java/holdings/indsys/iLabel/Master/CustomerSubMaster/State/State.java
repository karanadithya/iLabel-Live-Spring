package holdings.indsys.iLabel.Master.CustomerSubMaster.State;

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
@Document(collection = "State")
public class State {
    @MongoId
    private ObjectId id;
    @Indexed(unique = true)
    private String code;
    private String description;
    private String gst_state_code;

    public State(String code, String description, String gst_state_code) {
        this.code = code;
        this.description = description;
        this.gst_state_code = gst_state_code;
    }
}
