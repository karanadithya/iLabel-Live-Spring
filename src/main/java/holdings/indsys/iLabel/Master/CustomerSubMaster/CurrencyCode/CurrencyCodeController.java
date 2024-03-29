package holdings.indsys.iLabel.Master.CustomerSubMaster.CurrencyCode;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/master/currency-code")
@Tag(name = "Currency Code", description = "Currency Code API")
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

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
