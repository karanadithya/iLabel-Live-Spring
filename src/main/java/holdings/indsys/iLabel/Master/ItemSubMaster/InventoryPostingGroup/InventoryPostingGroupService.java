package holdings.indsys.iLabel.Master.ItemSubMaster.InventoryPostingGroup;

import holdings.indsys.iLabel.Master.ItemSubMaster.InventoryPostingGroup.dto.InventoryPostingGroupRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryPostingGroupService {
    private final InventoryPostingGroupRepository repository;
    private final ModelMapper mapper;

    public ResponseEntity<?> addNew(InventoryPostingGroupRequest request) {
        InventoryPostingGroup inventoryPostingGroup = mapper.map(request, InventoryPostingGroup.class);
        repository.save(inventoryPostingGroup);
        log.info("InventoryPostingGroup {} added successfully", inventoryPostingGroup.getId());
        return new ResponseEntity<>(inventoryPostingGroup, HttpStatus.CREATED);
    }

    public ResponseEntity<?> addMany(List<InventoryPostingGroupRequest> requestList) {
        List<InventoryPostingGroup> routingLineList = requestList
                .stream().map(request -> mapper.map(request, InventoryPostingGroup.class)).toList();
        repository.saveAll(routingLineList);
        log.info("{} InventoryPostingGroups added successfully", routingLineList.size());
        return new ResponseEntity<>(routingLineList, HttpStatus.CREATED);
    }

    public ResponseEntity<?> update(InventoryPostingGroupRequest request) {
        InventoryPostingGroup inventoryPostingGroup = mapper.map(request, InventoryPostingGroup.class);
        repository.save(inventoryPostingGroup);
        log.info("InventoryPostingGroup {} added successfully", inventoryPostingGroup.getId());
        return new ResponseEntity<>(inventoryPostingGroup, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<?> getAll() {
        List<InventoryPostingGroup> routingLineList = repository.findAll();
        return new ResponseEntity<>(routingLineList, HttpStatus.OK);
    }

    public ResponseEntity<?> delete(ObjectId id) {
        repository.deleteById(id);
        log.info("InventoryPostingGroup {} deleted successfully", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
