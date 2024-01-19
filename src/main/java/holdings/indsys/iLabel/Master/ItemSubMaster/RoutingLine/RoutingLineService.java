package holdings.indsys.iLabel.Master.ItemSubMaster.RoutingLine;

import holdings.indsys.iLabel.Master.ItemSubMaster.RoutingLine.dto.RoutingLineRequest;
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
public class RoutingLineService {

    private final RoutingLineRepository repository;
    private final ModelMapper mapper;

    public ResponseEntity<?> addNew(RoutingLineRequest request) {
        RoutingLine routingLine = mapper.map(request, RoutingLine.class);
        repository.save(routingLine);
        log.info("RoutingLine {} added successfully", routingLine.getId());
        return new ResponseEntity<>(routingLine, HttpStatus.CREATED);
    }

    public ResponseEntity<?> addMany(List<RoutingLineRequest> requestList) {
        List<RoutingLine> routingLineList = requestList
                .stream().map(request -> mapper.map(request, RoutingLine.class)).toList();
        repository.saveAll(routingLineList);
        log.info("{} RoutingLines added successfully", routingLineList.size());
        return new ResponseEntity<>(routingLineList, HttpStatus.CREATED);
    }

    public ResponseEntity<?> update(RoutingLineRequest request) {
        RoutingLine routingLine = mapper.map(request, RoutingLine.class);
        repository.save(routingLine);
        log.info("RoutingLine {} added successfully", routingLine.getId());
        return new ResponseEntity<>(routingLine, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<?> getAll() {
        List<RoutingLine> routingLineList = repository.findAll();
        return new ResponseEntity<>(routingLineList, HttpStatus.OK);
    }

    public ResponseEntity<?> delete(ObjectId id) {
        repository.deleteById(id);
        log.info("RoutingLine {} deleted successfully", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
