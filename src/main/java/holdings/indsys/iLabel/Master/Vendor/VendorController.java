package holdings.indsys.iLabel.Master.Vendor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/masters/vendor")
public class VendorController {

    private final VendorService service;

    /**
     * Create a new vendor.
     *
     * @param vendor The vendor object to be created.
     * @return A ResponseEntity object with the result of the creation.
     */
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Vendor vendor) {
        // Call the service to add the new vendor
        return ResponseEntity.ok(service.addNew(vendor));
    }

    /**
     * Creates multiple vendors.
     *
     * @param vendors The list of vendors to create.
     * @return The response entity with the result of the creation operation.
     */
    @PostMapping()
    public ResponseEntity<?> createMany(@RequestBody List<Vendor> vendors) {
        // Call the addMany method of the service to create the vendors

        // Return the response entity with the created vendors
        return ResponseEntity.ok(service.addMany(vendors));
    }


}
