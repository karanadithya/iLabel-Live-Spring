package holdings.indsys.iLabel.Master.Vendor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorService {
    private final VendorRepository repository;

    /**
     * Retrieves a list of all vendors.
     *
     * @return The list of vendors.
     */
    public List<Vendor> getAll() {
        return repository.findAll();
    }

    /**
     * Add a new vendor to the system.
     *
     * @param vendor the vendor to be added
     * @return the ResponseEntity with the added vendor
     */
    public ResponseEntity<?> addNew(Vendor vendor) {
        return ResponseEntity.ok(repository.save(vendor));
    }

    /**
     * Adds multiple vendors to the repository.
     *
     * @param vendors The list of vendors to be added.
     * @return A ResponseEntity containing the saved vendors.
     */
    public ResponseEntity<?> addMany(List<Vendor> vendors) {
        return ResponseEntity.ok(repository.saveAll(vendors));
    }
}
