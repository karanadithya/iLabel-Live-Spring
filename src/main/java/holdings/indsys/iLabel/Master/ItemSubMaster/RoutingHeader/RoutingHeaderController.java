package holdings.indsys.iLabel.Master.ItemSubMaster.RoutingHeader;

import holdings.indsys.iLabel.Master.ItemSubMaster.RoutingHeader.dto.RoutingHeaderRequest;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/masters/items/routingHeader")
public class RoutingHeaderController {

    private final RoutingHeaderService service;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody RoutingHeaderRequest request) {
        return ResponseEntity.ok(service.addNew(request));
    }

    @PostMapping("/bulk")
    public ResponseEntity<?> createMany(@RequestBody List<RoutingHeaderRequest> request) {
        return ResponseEntity.ok(service.addMany(request));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody RoutingHeaderRequest request) {
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
