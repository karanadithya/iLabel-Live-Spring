package holdings.indsys.iLabel.Master.ItemSubMaster.HsnSac;

import holdings.indsys.iLabel.Master.ItemSubMaster.HsnSac.dto.HsnSacRequest;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/masters/items/HSN_SAC")
public class HsnSacController {
    private final HsnSacService service;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody HsnSacRequest request) {
        return ResponseEntity.ok(service.addNew(request));
    }

    @PostMapping("/bulk")
    public ResponseEntity<?> createMany(@RequestBody List<HsnSacRequest> request) {
        return ResponseEntity.ok(service.addMany(request));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody HsnSacRequest request) {
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
