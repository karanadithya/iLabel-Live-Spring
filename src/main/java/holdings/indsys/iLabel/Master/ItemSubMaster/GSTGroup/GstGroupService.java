package holdings.indsys.iLabel.Master.ItemSubMaster.GSTGroup;

import holdings.indsys.iLabel.Master.ItemSubMaster.GSTGroup.dto.GstGroupRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GstGroupService {
    private final GstGroupRepository repository;
    private final ModelMapper mapper;

    public ResponseEntity<?> addNew(GstGroupRequest request) {
        GstGroup gstGroup = mapper.map(request, GstGroup.class);
        repository.save(gstGroup);
        log.info("GstGroup {} added successfully", gstGroup.getId());
        return new ResponseEntity<>(gstGroup, HttpStatus.CREATED);
    }

    public ResponseEntity<?> addMany(List<GstGroupRequest> requestList) {
        List<GstGroup> gstGroupList = requestList
                .stream().map(request -> mapper.map(request, GstGroup.class)).toList();
        repository.saveAll(gstGroupList);
        log.info("{} GstGroups added successfully", gstGroupList.size());
        return new ResponseEntity<>(gstGroupList, HttpStatus.CREATED);
    }

    public ResponseEntity<?> update(GstGroupRequest request) {
        GstGroup gstGroup = mapper.map(request, GstGroup.class);
        repository.save(gstGroup);
        log.info("GstGroup {} added successfully", gstGroup.getId());
        return new ResponseEntity<>(gstGroup, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<?> getAll() {
        List<GstGroup> routingLineList = repository.findAll();
        return new ResponseEntity<>(routingLineList, HttpStatus.OK);
    }

    public ResponseEntity<?> delete(String id) {
        repository.deleteById(id);
        log.info("RoutingLine {} deleted successfully", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
