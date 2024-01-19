package holdings.indsys.iLabel.Master.CustomerSubMaster.AssesseeCode;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/master/assessee-code")
@Tag(name = "AssesseeCode", description = "AssesseeCode API")
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

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<AssesseeCode> assesseeCodes = service.getAll();
        return ResponseEntity.ok(assesseeCodes);
    }
}
