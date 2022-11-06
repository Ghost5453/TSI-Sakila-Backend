package SakilaAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/")
@CrossOrigin
public class SakilaProjectApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(SakilaProjectApplication.class, args);
	}
}
