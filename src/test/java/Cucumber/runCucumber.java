package Cucumber;

import ApiComponents.Sakila.SakilaProjectApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = SakilaProjectApplication.class)
public class runCucumber {

}
