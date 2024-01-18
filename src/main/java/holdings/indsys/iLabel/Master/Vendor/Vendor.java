package holdings.indsys.iLabel.Master.Vendor;

import holdings.indsys.iLabel.Master.CurrentLocation;
import holdings.indsys.iLabel.Master.Customer.OfficeForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private String email;
    private String customerReference;
    private String companyName;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zipcode;
    private String nearestLandMark;
    private String premise;
    private String statuaryStatus;
    private String establishmentDate;
    private String landLine;
    private String mobile;
    private String website;
    private String numberOfEmployee;
    private String companyTurnOver;
    private String accountNumber;
    private String bankName;
    private String branch;
    private String purchaseContactPerson;
    private String purchasePersonMobile;
    private String purchasePersonEmail;
    private String accountsContactPerson;
    private String accountsPersonMobile;
    private String accountsPersonEmail;
    private String proprietorName;
    private String proprietorMobile;
    private String proprietorEmail;
    private String cinNum;
    private String panNum;
    private String gstAndArnNum;
    private String signatureAndSeal;
    private String remarks;
    private String vendorPostingGroup;
    private String currencyCode;
    private String paymentTermsCode;
    private String executiveCode;
    private String country;
    private String generalBusinessPostingGroup;
    private String stateCode;
    private String assesseeCode;
    private String gstCustomerType;
    private String gstRegistrationType;


    private Boolean status; //to check whether vendor is verified or not
    private CurrentLocation currentLocation;
    private OfficeForm officeForm;
}
