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

	@GetMapping("/actors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepo.findAll();
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Actor> updateEmployee(@PathVariable(value = "id") int actorID,
												@Validated @RequestBody Actor actorDetails) throws ResourceAccessException {
		Actor actor = actorRepo.findById(actorID)
				.orElseThrow(() -> new ResourceAccessException("Employee not found for this id :: " + actorID));

		actor.setID(actorDetails.getID());
		actor.setActorLastName(actorDetails.getActorLastName());
		actor.setFirstName(actorDetails.getFirstName());
		final Actor updatedEmployee = actorRepo.save(actor);
		return ResponseEntity.ok(updatedEmployee);
	}

	@GetMapping("/addresses")
	public @ResponseBody
	Iterable<Address> getAllAddresses(){
		return addressRepo.findAll();
	}
}
