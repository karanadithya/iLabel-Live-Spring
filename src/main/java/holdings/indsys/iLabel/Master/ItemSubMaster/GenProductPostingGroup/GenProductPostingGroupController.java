package holdings.indsys.iLabel.Master.ItemSubMaster.GenProductPostingGroup;

import holdings.indsys.iLabel.Master.ItemSubMaster.GenProductPostingGroup.dto.GenProductPostingGroupRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/masters/itemSubMaster/GenProductPostingGroup")
@Tag(name = "GenProductPostingGroup", description = "Item Sub Master - GenProductPostingGroup")
public class GenProductPostingGroupController {

    private final GenProductPostingGroupService service;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody GenProductPostingGroupRequest request) {
        return ResponseEntity.ok(service.addNew(request));
    }

    @PostMapping("/all")
    public ResponseEntity<?> createMany(@RequestBody List<GenProductPostingGroupRequest> request) {
        return ResponseEntity.ok(service.addMany(request));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody GenProductPostingGroupRequest request) {

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
