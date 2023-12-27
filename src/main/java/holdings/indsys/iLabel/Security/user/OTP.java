package holdings.indsys.iLabel.Security.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class OTP {
    private String timeStamp;
    private String code;

    public OTP(String code){
        this.code = code;
        this.timeStamp = String.valueOf(System.currentTimeMillis());
    }
}
