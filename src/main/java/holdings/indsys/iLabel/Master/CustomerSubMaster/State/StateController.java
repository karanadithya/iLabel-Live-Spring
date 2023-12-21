package holdings.indsys.iLabel.Master.CustomerSubMaster.State;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/master/state-code")
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
}
