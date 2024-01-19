package holdings.indsys.iLabel.Master.CustomerSubMaster.Country;

import com.mongodb.DuplicateKeyException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository repository;

    public List<Country> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<?> addNew(Country country) {
        return ResponseEntity.ok(repository.save(country));
    }

    public ResponseEntity<?> addMany(List<Country> country) {
        return ResponseEntity.ok(repository.saveAll(country));
    }


}
