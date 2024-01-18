package holdings.indsys.iLabel.Master;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentLocation {
    String location;
    String shortLocation;
    double latitude;
    double longitude;
}
