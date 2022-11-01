package ApiComponents.Sakila.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class SakilaProjectApplication {

	private ActorController actorController;


	@Autowired
	private ActorRepo actorRepo;
	private AddressRepo addressRepo;

	public SakilaProjectApplication(ActorRepo myActorRepo, AddressRepo myAddressRepo)
	{
		this.actorRepo = myActorRepo;
		this.addressRepo = myAddressRepo;
	}

	public static void main(String[] args)
	{
		SpringApplication.run(SakilaProjectApplication.class, args);
	}

	//region GetMappings


	@GetMapping("/addresses")
	public @ResponseBody
	Iterable<Address> getAllAddresses(){
		return addressRepo.findAll();
	}

	@GetMapping("/addresses/{id}")
	public Address getSignalAddress(@PathVariable(value = "id") int addressID)
	{
		return  addressRepo.findById(addressID).orElseThrow(() -> new ResourceAccessException("Address not found at index " + addressID));
	}
	//endregion

	//region PutMappings


//	@PutMapping("/address/{id}")
//	public ResponseEntity<Address> updateAddress(@PathVariable(value = "id") int addressID, @Validated @RequestBody Address addressDetails)
//		throws ResourceAccessException{
//		Address address = addressRepo.findById(addressDetails.getAddressID()).orElseThrow(() -> new ResourceAccessException("Address not found for this id :: " + addressID));
//
//	}
	//endregion

	//region PostMapping


	//endregion

}
