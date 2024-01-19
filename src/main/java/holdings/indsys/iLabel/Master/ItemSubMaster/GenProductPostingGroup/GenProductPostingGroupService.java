package holdings.indsys.iLabel.Master.ItemSubMaster.GenProductPostingGroup;

import holdings.indsys.iLabel.Master.ItemSubMaster.GenProductPostingGroup.dto.GenProductPostingGroupRequest;
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
public class GenProductPostingGroupService {
    private final GenProductPostingGroupRepository repository;
    private final ModelMapper mapper;

    public ResponseEntity<?> addNew(GenProductPostingGroupRequest request) {
        GenProductPostingGroup genProductPostingGroup = mapper.map(request, GenProductPostingGroup.class);
        repository.save(genProductPostingGroup);
        log.info("GenProductPostingGroup {} added successfully", genProductPostingGroup.getId());
        return new ResponseEntity<>(genProductPostingGroup, HttpStatus.CREATED);
    }

    public ResponseEntity<?> addMany(List<GenProductPostingGroupRequest> requestList) {
        List<GenProductPostingGroup> genProductPostingGroupList = requestList
                .stream().map(request -> mapper.map(request, GenProductPostingGroup.class)).toList();
        repository.saveAll(genProductPostingGroupList);
        log.info("{} GenProductPostingGroups added successfully", genProductPostingGroupList.size());
        return new ResponseEntity<>(genProductPostingGroupList, HttpStatus.CREATED);
    }

    public ResponseEntity<?> update(GenProductPostingGroupRequest request) {
        GenProductPostingGroup genProductPostingGroup = mapper.map(request, GenProductPostingGroup.class);
        repository.save(genProductPostingGroup);
        log.info("GenProductPostingGroup {} added successfully", genProductPostingGroup.getId());
        return new ResponseEntity<>(genProductPostingGroup, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<?> getAll() {
        List<GenProductPostingGroup> routingLineList = repository.findAll();
        return new ResponseEntity<>(routingLineList, HttpStatus.OK);
    }

    public ResponseEntity<?> delete(ObjectId id) {
        repository.deleteById(id);
        log.info("GenProductPostingGroup {} deleted successfully", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
