package ApiComponents.Sakila;

import ApiComponents.Sakila.ActorComponents.ActorController;
import ApiComponents.Sakila.ActorComponents.ActorRepo;
import ApiComponents.Sakila.AddressComponents.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/")
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
