package SakilaAPI.CustomerComponents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController
{
    @Autowired
    private CustomerRepo customerRepo;

    public CustomerController(CustomerRepo myCustomerRepo)
    {
        customerRepo = myCustomerRepo;
    }

    // Get all
    @GetMapping("")
    public @ResponseBody
    Iterable<Customer> getAllACustomers(){
        return customerRepo.findAll();
    }

    // Create
    @PostMapping("")
    public Customer createCustomer(@Validated @RequestBody CustomerModel customer)
    {
        Customer newCustomer = new Customer(customer.getCustomerID(),customer.getStoreIDFromCustomer(), customer.getCustomerFirstName(), customer.getCustomerLastName(), customer.getCustomerEmail(), customer.getAddressIDFromCustomer(), customer.getIsCusterActive());
        return customerRepo.save(newCustomer);
    }

    // Get by ID (Read)
    @GetMapping("/{id}")
    public Customer getSignalCustomer(@PathVariable(value = "id") int customerID)
    {
        return customerRepo.findById(customerID).orElseThrow(() -> new ResourceAccessException("Customer not found at index " + customerID));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") int customerID,
                                             @Validated @RequestBody CustomerModel customerDetails)
            throws ResourceAccessException {
        Customer customer = customerRepo.findById(customerID)
                .orElseThrow(() -> new ResourceAccessException("Customer not found by " + customerID));

        customer.setCustomerFirstName(customerDetails.getCustomerFirstName());
        customer.setCustomerLastName(customerDetails.getCustomerLastName());
        customer.setCustomerEmail(customerDetails.getCustomerEmail());
        customer.setAddressIDFromCustomer(customerDetails.getAddressIDFromCustomer());
        customer.setCustomerIsActive(customerDetails.getIsCusterActive());

        final Customer updatedEmployee = customerRepo.save(customer);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") int customerID)
            throws ResourceAccessException{
        Customer customer = customerRepo.findById(customerID)
                .orElseThrow(() -> new ResourceAccessException("Actor not found at index " + customerID));

        customerRepo.deleteById(customerID);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);

        return response;
    }
}
