package holdings.indsys.iLabel.Master.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Item")
public class Item {

    @MongoId
    private ObjectId id;
    private String description;
    private String searchDescription;
    private String baseUnitMeasure;
    private String inventoryPostingGroup;
    private String genProdPostingGroup;
    private String vatProdPostingGroup;
    private String replenishmentSystem;
    private String reorderingPolicy;
    private String manufacturingPolicy;
    private String itemCategoryCode;
    private String gstGroupCode;
    private String hsnOrSacCode;
    private String gstCredit;
    private String routingNo;
    private String productionBOMNo;
    private String orderTrackingPolicy;
    private String productType;
    private String itemNo;
    private String machineType;
    private String totalPicks;
    private String noOfPicks;
    private String picksCM;
    private String system;
    private String tapeQuality;
    private String totalRequired;
    private String tapeWidth;
    private String boardName;
    private String boardSize;
    private String tagSize;
    private String gsm;
    private String stickerQuality;
    private String stickerSize;
    private String noOfUps;
    private String stickerTotalRequired;
    private String boardTotalRequired;
    private String firstName;
    private String lastName;
    private String state;
    private String password;
    private String role;
    private String shipmentTerms;
    private String colors;
    private String labelType;
    private String entryDate;
    private String documentType;
    private String unit;
    private String width;
    private String height;
    private String quality;
    private String folding;
    private String additionalWork;
    private String remarks;
    private String numberOfPieces;
    private String typeOfApproval;
    private String orderType;
    private String specialInstruction;
    private String finishing;
    private String colorsInformation;
    private String boardType;
    private String noOfRepeats;

}
