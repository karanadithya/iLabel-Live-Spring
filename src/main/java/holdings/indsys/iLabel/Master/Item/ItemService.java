package holdings.indsys.iLabel.Master.Item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public ResponseEntity<?> addNew(Item item) {
        return ResponseEntity.ok(itemRepository.save(item));
    }

    public ResponseEntity<?> addMany(List<Item> items) {
        return ResponseEntity.ok(itemRepository.saveAll(items));
    }
}
