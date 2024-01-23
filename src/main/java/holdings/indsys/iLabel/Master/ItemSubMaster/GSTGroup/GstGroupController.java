package holdings.indsys.iLabel.Master.ItemSubMaster.GSTGroup;

import holdings.indsys.iLabel.Master.ItemSubMaster.GSTGroup.dto.GstGroupRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/masters/itemSubMaster/GstGroup")
@Tag(name = "GstGroup", description = "Item Sub Master - GstGroup")
public class GstGroupController {
    private final GstGroupService service;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody GstGroupRequest request) {
        return ResponseEntity.ok(service.addNew(request));
    }

    @PostMapping("/all")
    public ResponseEntity<?> createMany(@RequestBody List<GstGroupRequest> request) {
        return ResponseEntity.ok(service.addMany(request));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody GstGroupRequest request) {
        return ResponseEntity.ok(service.update(request));
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
