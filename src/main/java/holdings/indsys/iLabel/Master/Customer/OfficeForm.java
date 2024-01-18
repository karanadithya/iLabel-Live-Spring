package holdings.indsys.iLabel.Master.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfficeForm {
    private String customerAccountIncharge;
    private String creditLimit;
    private String creditPeriod;
    private String paymentTerms;
    private String refVistedBy;
    private String approvedBy;
    private String dateOfApproval;
}
