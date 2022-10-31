package ApiComponents.Sakila.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

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

	public static void main(String[] args) {

		SpringApplication.run(SakilaProjectApplication.class, args);
	}

	@GetMapping("/allActors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepo.findAll();
	}

	@GetMapping("/allAddresses")
	public @ResponseBody
	Iterable<Address> getAllAddresses(){
		return addressRepo.findAll();
	}
}
