package holdings.indsys.iLabel.Master.CustomerSubMaster.PaymentTerm;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentTermService {

    private final PaymentTermRepository repository;

    public List<PaymentTerm> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<?> addNew(PaymentTerm paymentTerm) {
        return ResponseEntity.ok(repository.save(paymentTerm));
    }

    public ResponseEntity<?> addMany(List<PaymentTerm> paymentTerm) {
        return ResponseEntity.ok(repository.saveAll(paymentTerm));
    }
}
