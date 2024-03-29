package holdings.indsys.iLabel.Master.CustomerSubMaster.PaymentTerm;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/master/payment-term")
@Tag(name = "Payment Term")
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

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
