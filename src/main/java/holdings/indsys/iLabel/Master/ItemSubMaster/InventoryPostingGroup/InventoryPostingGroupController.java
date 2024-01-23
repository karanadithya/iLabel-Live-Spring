package holdings.indsys.iLabel.Master.ItemSubMaster.InventoryPostingGroup;

import holdings.indsys.iLabel.Master.ItemSubMaster.InventoryPostingGroup.dto.InventoryPostingGroupRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/masters/itemSubMaster/inventoryPostingGroup")
@Tag(name = "Inventory Posting Group", description = "Item Sub Master - Inventory Posting Group")
public class InventoryPostingGroupController {
    private final InventoryPostingGroupService service;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody InventoryPostingGroupRequest request) {
        return ResponseEntity.ok(service.addNew(request));
    }

    @PostMapping("/all")
    public ResponseEntity<?> createMany(@RequestBody List<InventoryPostingGroupRequest> request) {
        return ResponseEntity.ok(service.addMany(request));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody InventoryPostingGroupRequest request) {
        return ResponseEntity.ok(service.update(request));
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ObjectId id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
