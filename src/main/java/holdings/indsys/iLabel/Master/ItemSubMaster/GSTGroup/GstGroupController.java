package holdings.indsys.iLabel.Master.ItemSubMaster.GSTGroup;

import holdings.indsys.iLabel.Master.ItemSubMaster.GSTGroup.dto.GstGroupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/masters/items/GstGroup")
public class GstGroupController {
    private final GstGroupService service;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody GstGroupRequest request) {
        return ResponseEntity.ok(service.addNew(request));
    }

    @PostMapping("/bulk")
    public ResponseEntity<?> createMany(@RequestBody List<GstGroupRequest> request) {
        return ResponseEntity.ok(service.addMany(request));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody GstGroupRequest request) {
        return ResponseEntity.ok(service.update(request));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
