package SakilaAPI.AddressComponents;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("addresses")
@CrossOrigin
public class AddressController {

    private AddressRepo addressRepo;

    public AddressController (AddressRepo myAddressRepo)
    {
        this.addressRepo = myAddressRepo;
    }

    // Get all
    @GetMapping("")
    public @ResponseBody
    Iterable<Address> getAllAddresses(){
        return addressRepo.findAll();
    }

    // Create
    @PostMapping("")
    public Address createActor(@Validated @RequestBody Address address)
    {
        return addressRepo.save(address);
    }

    // Get by ID (Reed)
    @GetMapping("/{id}")
    public Address getSignalAddress(@PathVariable(value = "id") int addressID)
    {
        return  addressRepo.findById(addressID).orElseThrow(() -> new ResourceAccessException("Address not found at index " + addressID));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable(value = "id") int addressID,
                                             @Validated @RequestBody Address addressDetails)
            throws ResourceAccessException {
        Address address = addressRepo.findById(addressID)
                .orElseThrow(() -> new ResourceAccessException("Actor not found by " + addressID));

        address.setAddressID(addressDetails.getAddressID());
        address.setAddress(addressDetails.getAddress());
        address.setAddressDistrict(addressDetails.getAddressDistrict());
        address.setCityIdFromAddress(addressDetails.getCityIdFromAddress());
        address.setPostCode(addressDetails.getPostCode());
        address.setPhoneNumber(addressDetails.getPhoneNumber());

        final Address updatedEmployee = addressRepo.save(address);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete
    @DeleteMapping("delete/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int addressID)
            throws ResourceAccessException{
        Address address = addressRepo.findById(addressID)
                .orElseThrow(() -> new ResourceAccessException("Actor not found at index " + addressID));

        addressRepo.deleteById(addressID);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);

        return response;
    }
}
