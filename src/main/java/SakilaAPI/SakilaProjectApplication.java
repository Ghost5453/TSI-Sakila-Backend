package SakilaAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/")
@CrossOrigin (origins = {"http://localhost:8080/", "http://localhost:3000/"})
public class SakilaProjectApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(SakilaProjectApplication.class, args);
	}
}
