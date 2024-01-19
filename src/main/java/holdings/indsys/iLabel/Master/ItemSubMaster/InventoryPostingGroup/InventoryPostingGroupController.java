package holdings.indsys.iLabel.Master.ItemSubMaster.InventoryPostingGroup;

import holdings.indsys.iLabel.Master.ItemSubMaster.InventoryPostingGroup.dto.InventoryPostingGroupRequest;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/masters/items/inventoryPostingGroup")
public class InventoryPostingGroupController {
    private final InventoryPostingGroupService service;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody InventoryPostingGroupRequest request) {
        return ResponseEntity.ok(service.addNew(request));
    }

    @PostMapping("/bulk")
    public ResponseEntity<?> createMany(@RequestBody List<InventoryPostingGroupRequest> request) {
        return ResponseEntity.ok(service.addMany(request));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody InventoryPostingGroupRequest request) {
        return ResponseEntity.ok(service.update(request));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ObjectId id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
