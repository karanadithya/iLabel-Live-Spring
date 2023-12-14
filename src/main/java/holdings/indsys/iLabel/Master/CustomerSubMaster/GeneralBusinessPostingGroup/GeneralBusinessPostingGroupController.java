package holdings.indsys.iLabel.Master.CustomerSubMaster.GeneralBusinessPostingGroup;

import holdings.indsys.iLabel.Master.CustomerSubMaster.Country.Country;
import holdings.indsys.iLabel.Master.CustomerSubMaster.Country.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
}
