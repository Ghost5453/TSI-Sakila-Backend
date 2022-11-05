package ApiComponents.Sakila;

import ApiComponents.Sakila.ActorComponents.ActorController;
import ApiComponents.Sakila.ActorComponents.ActorRepo;
import ApiComponents.Sakila.AddressComponents.AddressRepo;
import ApiComponents.Sakila.FilmComponents.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;

@SpringBootApplication
@RestController
@RequestMapping("/")
@CrossOrigin
public class SakilaProjectApplication {


	@Autowired
	private ActorRepo actorRepo;
	private AddressRepo addressRepo;
	private FilmRepo filmRepo;

	public SakilaProjectApplication(ActorRepo myActorRepo, AddressRepo myAddressRepo, FilmRepo myFilmRepo)
	{
		this.actorRepo = myActorRepo;
		this.addressRepo = myAddressRepo;
		this.filmRepo = myFilmRepo;
	}

	public static void main(String[] args)
	{
		SpringApplication.run(SakilaProjectApplication.class, args);
	}
}
