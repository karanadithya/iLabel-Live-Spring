package holdings.indsys.iLabel.Master.ItemSubMaster.RoutingHeader;

import holdings.indsys.iLabel.Master.ItemSubMaster.RoutingHeader.dto.RoutingHeaderRequest;
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
public class RoutingHeaderService {

    private final RoutingHeaderRepository repository;
    private final ModelMapper mapper;

    public ResponseEntity<?> addNew(RoutingHeaderRequest request) {
        RoutingHeader routingHeader = mapper.map(request, RoutingHeader.class);
        repository.save(routingHeader);
        log.info("RoutingHeader {} added successfully", routingHeader.getId());
        return new ResponseEntity<>(routingHeader, HttpStatus.CREATED);
    }

    public ResponseEntity<?> addMany(List<RoutingHeaderRequest> requestList) {
        List<RoutingHeader> routingHeaderList = requestList
                .stream().map(request -> mapper.map(request, RoutingHeader.class)).toList();
        repository.saveAll(routingHeaderList);
        log.info("{} RoutingHeader added successfully", routingHeaderList.size());
        return new ResponseEntity<>(routingHeaderList, HttpStatus.CREATED);
    }

    public ResponseEntity<?> update(RoutingHeaderRequest request) {
        RoutingHeader routingHeader = mapper.map(request, RoutingHeader.class);
        repository.save(routingHeader);
        log.info("routingHeader {} updated successfully", routingHeader.getId());
        return new ResponseEntity<>(routingHeader, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<?> getAll() {
        List<RoutingHeader> routingHeaderList = repository.findAll();
        return new ResponseEntity<>(routingHeaderList, HttpStatus.OK);
    }

    public ResponseEntity<?> delete(ObjectId id) {
        repository.deleteById(id);
        log.info("routingHeader {} deleted successfully", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
