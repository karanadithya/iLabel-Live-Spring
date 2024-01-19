package holdings.indsys.iLabel.Master.ItemSubMaster.UnitOfMeasure;

import holdings.indsys.iLabel.Master.ItemSubMaster.UnitOfMeasure.dto.UnitOfMeasureRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/masters/items/unitOfMeasure")
@Tag(name = "Unit of Measure", description = "Item Sub Master Unit of Measure")
public class UnitOfMeasureController {

    private final UnitOfMeasureService service;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody UnitOfMeasureRequest unitOfMeasure){
        return ResponseEntity.ok(service.addNew(unitOfMeasure));
    }

    @PostMapping("/bulk")
    public ResponseEntity<?> createMany(@RequestBody List<UnitOfMeasureRequest> unitOfMeasures){
        return ResponseEntity.ok(service.addMany(unitOfMeasures));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody UnitOfMeasureRequest unitOfMeasure){
        return ResponseEntity.ok(service.update(unitOfMeasure));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ObjectId id){
        return ResponseEntity.ok(service.delete(id));
    }
}
