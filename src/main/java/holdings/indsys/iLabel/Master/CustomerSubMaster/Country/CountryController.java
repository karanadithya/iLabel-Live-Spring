package holdings.indsys.iLabel.Master.CustomerSubMaster.Country;

import holdings.indsys.iLabel.Master.CustomerSubMaster.CurrencyCode.CurrencyCode;
import holdings.indsys.iLabel.Master.CustomerSubMaster.CurrencyCode.CurrencyCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/master/country-region")
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
}
