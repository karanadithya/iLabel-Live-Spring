package holdings.indsys.iLabel.Master.ItemSubMaster.RoutingLine;

import holdings.indsys.iLabel.Master.ItemSubMaster.RoutingLine.dto.RoutingLineRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/masters/itemSubMaster/routingLine")
@Tag(name = "RoutingLine", description = "Item Sub Master - RoutingLine")
public class RoutingLineController {

    private final RoutingLineService service;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody RoutingLineRequest request) {
        return ResponseEntity.ok(service.addNew(request));
    }

    @PostMapping("/all")
    public ResponseEntity<?> createMany(@RequestBody List<RoutingLineRequest> request) {
        return ResponseEntity.ok(service.addMany(request));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody RoutingLineRequest request) {
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
