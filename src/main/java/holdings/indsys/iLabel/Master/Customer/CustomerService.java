package holdings.indsys.iLabel.Master.Customer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public ResponseEntity<?> addNew(Customer customer) {
        return ResponseEntity.ok(customerRepository.save(customer));
    }

    public ResponseEntity<?> addMany(List<Customer> customer) {
        return ResponseEntity.ok(customerRepository.saveAll(customer));
    }
}
