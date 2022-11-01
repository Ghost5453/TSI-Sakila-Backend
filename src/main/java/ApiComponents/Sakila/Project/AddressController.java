package ApiComponents.Sakila.Project;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class AddressController {

    private AddressRepo addressRepo;

    public AddressController (AddressRepo myAddressRepo)
    {
        this.addressRepo = myAddressRepo;
    }

    // Get all
    @GetMapping("/addresses")
    public @ResponseBody
    Iterable<Address> getAllAddresses(){
        return addressRepo.findAll();
    }

    //
    @GetMapping("/addresses/{id}")
    public Address getSignalAddress(@PathVariable(value = "id") int addressID)
    {
        return  addressRepo.findById(addressID).orElseThrow(() -> new ResourceAccessException("Address not found at index " + addressID));
    }



}
