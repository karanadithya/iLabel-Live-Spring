package holdings.indsys.iLabel.Master.ItemSubMaster.ItemCategory;

import holdings.indsys.iLabel.Master.ItemSubMaster.ItemCategory.dto.ItemCategoryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemCategoryService {
    private final ItemCategoryRepository repository;
    private final ModelMapper mapper;

    public ResponseEntity<?> addNew(ItemCategoryRequest request) {
        ItemCategory itemCategory = mapper.map(request, ItemCategory.class);
        repository.save(itemCategory);
        log.info("ItemCategory {} added successfully", itemCategory.getId());
        return new ResponseEntity<>(itemCategory, HttpStatus.CREATED);
    }

    public ResponseEntity<?> addMany(List<ItemCategoryRequest> requestList) {
        List<ItemCategory> itemCategoryList = requestList
                .stream().map(request -> mapper.map(request, ItemCategory.class)).toList();
        repository.saveAll(itemCategoryList);
        log.info("{} ItemCategories added successfully", itemCategoryList.size());
        return new ResponseEntity<>(itemCategoryList, HttpStatus.CREATED);
    }

    public ResponseEntity<?> update(ItemCategoryRequest request) {
        ItemCategory itemCategory = mapper.map(request, ItemCategory.class);
        repository.save(itemCategory);
        log.info("ItemCategory {} added successfully", itemCategory.getId());
        return new ResponseEntity<>(itemCategory, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<?> getAll() {
        List<ItemCategory> routingLineList = repository.findAll();
        return new ResponseEntity<>(routingLineList, HttpStatus.OK);
    }

    public ResponseEntity<?> delete(ObjectId id) {
        repository.deleteById(id);
        log.info("ItemCategory {} deleted successfully", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
