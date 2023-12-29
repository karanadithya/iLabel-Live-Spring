package holdings.indsys.iLabel.Master.CustomerSubMaster.GeneralBusinessPostingGroup;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeneralBusinessPostingGroupService {

    private final GeneralBusinessPostingGroupRepository repository;

    public List<GeneralBusinessPostingGroup> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<?> addNew(GeneralBusinessPostingGroup postingGroup) {
        return ResponseEntity.ok(repository.save(postingGroup));
    }

    public ResponseEntity<?> addMany(List<GeneralBusinessPostingGroup> postingGroup) {
        return ResponseEntity.ok(repository.saveAll(postingGroup));
    }
}
