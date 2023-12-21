package holdings.indsys.iLabel.Master.CustomerSubMaster.AssesseeCode;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/master/assessee-code")
public class AssesseeCodeController {

    private final AssesseeCodeService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AssesseeCode assesseeCode) {
        return ResponseEntity.ok(service.addNew(assesseeCode));
    }

    @PostMapping()
    public ResponseEntity<?> createMany(@RequestBody List<AssesseeCode> assesseeCodes) {
        return ResponseEntity.ok(service.addMany(assesseeCodes));
    }
}
