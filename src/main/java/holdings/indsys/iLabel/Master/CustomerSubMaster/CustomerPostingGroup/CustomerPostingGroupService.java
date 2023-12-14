package holdings.indsys.iLabel.Master.CustomerSubMaster.CustomerPostingGroup;

import holdings.indsys.iLabel.Master.CustomerSubMaster.State.State;
import holdings.indsys.iLabel.Master.CustomerSubMaster.State.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerPostingGroupService {

    private final CustomerPostingGroupRepository repository;

    public List<CustomerPostingGroup> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<?> addNew(CustomerPostingGroup customerPostingGroup) {
        return ResponseEntity.ok(repository.save(customerPostingGroup));
    }

    public ResponseEntity<?> addMany(List<CustomerPostingGroup> customerPostingGroup) {
        return ResponseEntity.ok(repository.saveAll(customerPostingGroup));
    }
}
