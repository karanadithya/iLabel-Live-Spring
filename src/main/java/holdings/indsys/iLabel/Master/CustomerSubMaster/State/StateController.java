package holdings.indsys.iLabel.Master.CustomerSubMaster.State;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/master/state-code")
@Tag(name = "State")
public class StateController {
    private final StateService service;

    @PostMapping("/create")
    public ResponseEntity<?> createState(@RequestBody State state) {
        return ResponseEntity.ok(service.addNewState(state));
    }

    @PostMapping()
    public ResponseEntity<?> createStateMany(@RequestBody List<State> state) {
        return ResponseEntity.ok(service.addNewStateMany(state));
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
