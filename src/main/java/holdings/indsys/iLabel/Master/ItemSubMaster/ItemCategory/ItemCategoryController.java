package holdings.indsys.iLabel.Master.ItemSubMaster.ItemCategory;

import holdings.indsys.iLabel.Master.ItemSubMaster.ItemCategory.dto.ItemCategoryRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/masters/itemSubMaster/itemCategory")
@Tag(name = "Item Category" , description = "Item Sub Master - Item Category")
public class ItemCategoryController {

    private final ItemCategoryService service;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody ItemCategoryRequest request) {
        return ResponseEntity.ok(service.addNew(request));
    }

    @PostMapping("/all")
    public ResponseEntity<?> createMany(@RequestBody List<ItemCategoryRequest> request) {
        return ResponseEntity.ok(service.addMany(request));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody ItemCategoryRequest request) {
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
