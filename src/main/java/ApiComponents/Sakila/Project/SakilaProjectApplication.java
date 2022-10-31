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
	@GetMapping("/actor")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepo.findAll();
	}

	@GetMapping("/actor/{id}")
	public Actor getSignalActor(@PathVariable(value = "id") int actorID)
	{
		return actorRepo.findById(actorID).orElseThrow(() -> new ResourceAccessException("Actor not found at index " + actorID));
	}

	@GetMapping("/address")
	public @ResponseBody
	Iterable<Address> getAllAddresses(){
		return addressRepo.findAll();
	}

	@GetMapping("/address/{id}")
	public Address getSignalAddress(@PathVariable(value = "id") int addressID)
	{
		return  addressRepo.findById(addressID).orElseThrow(() -> new ResourceAccessException("Address not found at index " + addressID));
	}
	//endregion

	//region PutMappings
	@PutMapping("/actor/{id}")
	public ResponseEntity<Actor> updateActor(@PathVariable(value = "id") int actorID, @Validated @RequestBody Actor actorDetails)
			throws ResourceAccessException {
		Actor actor = actorRepo.findById(actorID)
				.orElseThrow(() -> new ResourceAccessException("Actor not found at index " + actorID));

		actor.setID(actorDetails.getID());
		actor.setActorLastName(actorDetails.getActorLastName());
		actor.setFirstName(actorDetails.getFirstName());
		final Actor updatedEmployee = actorRepo.save(actor);
		return ResponseEntity.ok(updatedEmployee);
	}

//	@PutMapping("/address/{id}")
//	public ResponseEntity<Address> updateAddress(@PathVariable(value = "id") int addressID, @Validated @RequestBody Address addressDetails)
//		throws ResourceAccessException{
//		Address address = addressRepo.findById(addressDetails.getAddressID()).orElseThrow(() -> new ResourceAccessException("Address not found for this id :: " + addressID));
//
//	}
	//endregion

}
