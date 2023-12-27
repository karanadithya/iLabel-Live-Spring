package holdings.indsys.iLabel.Security.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequestPhone {
    @JsonProperty("mobile_number")
    private String phoneNumber;
    private String otp;
}
