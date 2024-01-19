package holdings.indsys.iLabel.Master.ItemSubMaster.HsnSac;

import holdings.indsys.iLabel.Master.ItemSubMaster.HsnSac.dto.HsnSacRequest;
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
public class HsnSacService {
    private final HsnSacRepository repository;
    private final ModelMapper mapper;

    public ResponseEntity<?> addNew(HsnSacRequest request) {
        HsnSac hsnSac = mapper.map(request, HsnSac.class);
        repository.save(hsnSac);
        log.info("HsnSac {} added successfully", hsnSac.getId());
        return new ResponseEntity<>(hsnSac, HttpStatus.CREATED);
    }

    public ResponseEntity<?> addMany(List<HsnSacRequest> requestList) {
        List<HsnSac> hsnSacList = requestList
                .stream().map(request -> mapper.map(request, HsnSac.class)).toList();
        repository.saveAll(hsnSacList);
        log.info("{} HsnSac added successfully", hsnSacList.size());
        return new ResponseEntity<>(hsnSacList, HttpStatus.CREATED);
    }

    public ResponseEntity<?> update(HsnSacRequest request) {
        HsnSac hsnSac = mapper.map(request, HsnSac.class);
        repository.save(hsnSac);
        log.info("HsnSac {} added successfully", hsnSac.getId());
        return new ResponseEntity<>(hsnSac, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<?> getAll() {
        List<HsnSac> routingLineList = repository.findAll();
        return new ResponseEntity<>(routingLineList, HttpStatus.OK);
    }

    public ResponseEntity<?> delete(ObjectId id) {
        repository.deleteById(id);
        log.info("HsnSac {} deleted successfully", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
