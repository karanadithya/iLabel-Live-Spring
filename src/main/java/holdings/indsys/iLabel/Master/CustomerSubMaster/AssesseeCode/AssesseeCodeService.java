package holdings.indsys.iLabel.Master.CustomerSubMaster.AssesseeCode;

import holdings.indsys.iLabel.Master.CustomerSubMaster.Country.Country;
import holdings.indsys.iLabel.Master.CustomerSubMaster.Country.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssesseeCodeService {
    private final AssesseeCodeRepository repository;

    public List<AssesseeCode> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<?> addNew(AssesseeCode assesseeCode) {
        return ResponseEntity.ok(repository.save(assesseeCode));
    }

    public ResponseEntity<?> addMany(List<AssesseeCode> assesseeCode) {
        return ResponseEntity.ok(repository.saveAll(assesseeCode));
    }
}
