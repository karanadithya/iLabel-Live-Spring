package holdings.indsys.iLabel.Master.CustomerSubMaster.CurrencyCode;

import holdings.indsys.iLabel.Master.CustomerSubMaster.PaymentTerm.PaymentTerm;
import holdings.indsys.iLabel.Master.CustomerSubMaster.PaymentTerm.PaymentTermRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyCodeService {

    private final CurrencyCodeRepository repository;

    public List<CurrencyCode> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<?> addNew(CurrencyCode currencyCode) {
        return ResponseEntity.ok(repository.save(currencyCode));
    }

    public ResponseEntity<?> addMany(List<CurrencyCode> currencyCode) {
        return ResponseEntity.ok(repository.saveAll(currencyCode));
    }
}
