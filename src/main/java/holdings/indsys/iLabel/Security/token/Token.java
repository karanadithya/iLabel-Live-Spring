package holdings.indsys.iLabel.Security.token;

import holdings.indsys.iLabel.Security.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tokens")
public class Token {

    @Id
    private String id;
    private String token;
    private TokenType tokenType;
    private boolean expired;
    private boolean revoked;
    private User user;
}
