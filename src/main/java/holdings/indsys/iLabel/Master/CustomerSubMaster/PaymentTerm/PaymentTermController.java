package holdings.indsys.iLabel.Master.CustomerSubMaster.PaymentTerm;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/master/payment-term")
public class PaymentTermController {

    private final PaymentTermService service;

    @PostMapping("/create")
    public ResponseEntity<?> createState(@RequestBody PaymentTerm paymentTerm) {
        return ResponseEntity.ok(service.addNew(paymentTerm));
    }

    @PostMapping()
    public ResponseEntity<?> createStateMany(@RequestBody List<PaymentTerm> paymentTerm) {
        return ResponseEntity.ok(service.addMany(paymentTerm));
    }
}
