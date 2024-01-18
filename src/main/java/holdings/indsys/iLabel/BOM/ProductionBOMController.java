package holdings.indsys.iLabel.BOM;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/productionBOM")
public class ProductionBOMController {

    private final ProductionBOMService productionBOMService;

    /**
     * Create a new item.
     *
     * @param productionBOM The item object to be created.
     * @return The response entity with the result of the creation.
     */
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductionBOM productionBOM) {
        // Add the new customer to the service
        return ResponseEntity.ok(productionBOMService.addNew(productionBOM));
    }

    /**
     * Create multiple items.
     *
     * @param productionBOMS The list of items to create.
     * @return The response entity with the result of the create operation.
     */
    @PostMapping()
    public ResponseEntity<?> createMany(@RequestBody List<ProductionBOM> productionBOMS) {
        // Return the response entity with the result of the create operation
        return ResponseEntity.ok(productionBOMService.addMany(productionBOMS));
    }

    /**
     * Retrieves all production BOMs.
     *
     * @return ResponseEntity with the list of production BOMs
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<ProductionBOM> productionBOMs = productionBOMService.getAll();
        return ResponseEntity.ok(productionBOMs);
    }

    @GetMapping("/{productionBOMNo}")
    public ResponseEntity<?> getProductionBOM(@PathVariable String productionBOMNo) {
        return ResponseEntity.ok(productionBOMService.getProductionBOM(productionBOMNo));
    }

    @GetMapping("/lineItem/{productionBOMNo}")
    public ResponseEntity<?> getLineItem(@PathVariable String productionBOMNo) {
        return ResponseEntity.ok(productionBOMService.getLineItem(productionBOMNo));
    }
}
