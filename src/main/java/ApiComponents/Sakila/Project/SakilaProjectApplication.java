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


}
