package holdings.indsys.iLabel.Master.CustomerSubMaster.CustomerPostingGroup;

import holdings.indsys.iLabel.Master.CustomerSubMaster.State.State;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/master/customer-posting-group")
public class CustomerPostingGroupController {

    private final CustomerPostingGroupService service;
    @PostMapping("/create")
    public ResponseEntity<?> createState(@RequestBody CustomerPostingGroup customerPostingGroup) {
        return ResponseEntity.ok(service.addNew(customerPostingGroup));
    }

    @PostMapping()
    public ResponseEntity<?> createStateMany(@RequestBody List<CustomerPostingGroup> customerPostingGroup) {
        return ResponseEntity.ok(service.addMany(customerPostingGroup));
    }
}
