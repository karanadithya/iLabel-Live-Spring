package holdings.indsys.iLabel.Master.CustomerSubMaster.State;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StateService {

    private final StateRepository repository;

    public List<State> getAllStates() {
        return repository.findAll();
    }

    public ResponseEntity<?> addNewState(State student) {
        return ResponseEntity.ok(repository.save(student));
    }

    public ResponseEntity<?> addNewStateMany(List<State> student) {
        return ResponseEntity.ok(repository.saveAll(student));
    }
}
