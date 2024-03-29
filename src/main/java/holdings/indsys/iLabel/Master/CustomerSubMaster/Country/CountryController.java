package holdings.indsys.iLabel.Master.CustomerSubMaster.Country;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/master/country-region")
@Tag(name = "Country", description = "Country API")
public class CountryController {

    private final CountryService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Country country) {
        return ResponseEntity.ok(service.addNew(country));
    }

    @PostMapping()
    public ResponseEntity<?> createMany(@RequestBody List<Country> country) {
        return ResponseEntity.ok(service.addMany(country));
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
