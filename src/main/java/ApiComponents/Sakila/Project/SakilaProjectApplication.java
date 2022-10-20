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
	public SakilaProjectApplication(ActorRepo myActorRepo)
	{
		this.actorRepo = myActorRepo;
	}

	public static void main(String[] args) {

		SpringApplication.run(SakilaProjectApplication.class, args);
	}

	@GetMapping("/allActors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepo.findAll();
	}


}
