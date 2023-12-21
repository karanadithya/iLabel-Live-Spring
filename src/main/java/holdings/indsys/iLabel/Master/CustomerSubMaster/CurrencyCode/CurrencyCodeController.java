package holdings.indsys.iLabel.Master.CustomerSubMaster.CurrencyCode;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/master/currency-code")
public class CurrencyCodeController {
    private final CurrencyCodeService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CurrencyCode currencyCode) {
        return ResponseEntity.ok(service.addNew(currencyCode));
    }

    @PostMapping()
    public ResponseEntity<?> createMany(@RequestBody List<CurrencyCode> currencyCode) {
        return ResponseEntity.ok(service.addMany(currencyCode));
    }
}
