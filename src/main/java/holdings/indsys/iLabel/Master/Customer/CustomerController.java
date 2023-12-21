package holdings.indsys.iLabel.Master.Customer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/masters/customer")
public class CustomerController {

    private final CustomerService service;

    /**
     * Create a new customer.
     *
     * @param customer The customer object to be created.
     * @return The response entity with the result of the creation.
     */
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Customer customer) {
        // Add the new customer to the service
        return ResponseEntity.ok(service.addNew(customer));
    }

    /**
     * Create multiple customers.
     *
     * @param customers The list of customers to create.
     * @return The response entity with the result of the create operation.
     */
    @PostMapping()
    public ResponseEntity<?> createMany(@RequestBody List<Customer> customers) {
        // Return the response entity with the result of the create operation
        return ResponseEntity.ok(service.addMany(customers));
    }
}
