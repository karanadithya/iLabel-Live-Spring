package holdings.indsys.iLabel.Master.Item;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/masters/items")
@Tag(name = "Item")
public class ItemController {

    private final ItemService itemService;

    /**
     * Create a new item.
     *
     * @param item The item object to be created.
     * @return The response entity with the result of the creation.
     */
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Item item) {
        // Add the new customer to the service
        return ResponseEntity.ok(itemService.addNew(item));
    }

    /**
     * Create multiple items.
     *
     * @param items The list of items to create.
     * @return The response entity with the result of the create operation.
     */
    @PostMapping()
    public ResponseEntity<?> createMany(@RequestBody List<Item> items) {
        // Return the response entity with the result of the create operation
        return ResponseEntity.ok(itemService.addMany(items));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(itemService.getAll());
    }


}
