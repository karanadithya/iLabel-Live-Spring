package holdings.indsys.iLabel.Master.CustomerSubMaster.GeneralBusinessPostingGroup;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/masters/customer-sub-master/businessPostingGroup")
public class GeneralBusinessPostingGroupController {

    private final GeneralBusinessPostingGroupService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody GeneralBusinessPostingGroup postingGroup) {
        return ResponseEntity.ok(service.addNew(postingGroup));
    }

    @PostMapping()
    public ResponseEntity<?> createMany(@RequestBody List<GeneralBusinessPostingGroup> postingGroup) {
        return ResponseEntity.ok(service.addMany(postingGroup));
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
