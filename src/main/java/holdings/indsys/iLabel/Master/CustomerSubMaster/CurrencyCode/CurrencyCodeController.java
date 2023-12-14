package holdings.indsys.iLabel.Master.CustomerSubMaster.CurrencyCode;

import holdings.indsys.iLabel.Master.CustomerSubMaster.PaymentTerm.PaymentTerm;
import holdings.indsys.iLabel.Master.CustomerSubMaster.PaymentTerm.PaymentTermService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
