package holdings.indsys.iLabel.Master.ItemSubMaster.UnitOfMeasure;

import holdings.indsys.iLabel.Master.ItemSubMaster.UnitOfMeasure.dto.UnitOfMeasureRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UnitOfMeasureService {

    private final UnitOfMeasureRepository repository;


    public ResponseEntity<?> addNew(UnitOfMeasureRequest unitOfMeasureRequest) {
        UnitOfMeasure unitOfMeasure = UnitOfMeasure.builder()
                .code(unitOfMeasureRequest.getCode())
                .description(unitOfMeasureRequest.getDescription())
                .internationalStandardCode(unitOfMeasureRequest.getInternationalStandardCode())
                .build();
        repository.save(unitOfMeasure);
        log.info("UnitOfMeasure {} added successfully", unitOfMeasure.getId());
        return new ResponseEntity<>(unitOfMeasure, HttpStatus.CREATED);
    }

    public ResponseEntity<?> addMany(List<UnitOfMeasureRequest> unitOfMeasuresRequest) {
        List<UnitOfMeasure> unitOfMeasures = unitOfMeasuresRequest
                .stream()
                .map(unitOfMeasureRequest -> UnitOfMeasure.builder()
                        .code(unitOfMeasureRequest.getCode())
                        .description(unitOfMeasureRequest.getDescription())
                        .internationalStandardCode(unitOfMeasureRequest.getInternationalStandardCode())
                        .build())
                .toList();
        repository.saveAll(unitOfMeasures);
        log.info("{} UnitOfMeasures added successfully", unitOfMeasures.size());
        return new ResponseEntity<>(unitOfMeasures, HttpStatus.CREATED);
    }

    public ResponseEntity<?> update(UnitOfMeasureRequest unitOfMeasureRequest) {
        UnitOfMeasure unitOfMeasure = UnitOfMeasure.builder()
                .code(unitOfMeasureRequest.getCode())
                .description(unitOfMeasureRequest.getDescription())
                .internationalStandardCode(unitOfMeasureRequest.getInternationalStandardCode())
                .build();
        repository.save(unitOfMeasure);
        log.info("UnitOfMeasure {} updated successfully", unitOfMeasure.getId());
        return new ResponseEntity<>(unitOfMeasure, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<?> getAll() {
        List<UnitOfMeasure> unitOfMeasures = repository.findAll();
        return new ResponseEntity<>(unitOfMeasures, HttpStatus.OK);
    }

    public ResponseEntity<?> delete(ObjectId id) {
        repository.deleteById(id);
        log.info("UnitOfMeasure {} deleted successfully", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
