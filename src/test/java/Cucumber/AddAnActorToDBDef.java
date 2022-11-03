package Cucumber;


import ApiComponents.Sakila.Project.Actor;
import ApiComponents.Sakila.Project.ActorController;
import ApiComponents.Sakila.Project.ActorRepo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class AddAnActorToDBDef {
    @Autowired
    ActorRepo testActorRepo;
    String testFirstName;
    String testLastName;
    Actor testActor;
    Actor resultsActor;

    @Autowired
    ActorController testActorControler = new ActorController(testActorRepo);

    @Given("a new actor needs to be added")
    public void a_new_actor_needs_to_be_added()
    {
        testFirstName = "Test";
        testLastName = "Testson";
        testActor = new Actor(testFirstName, testLastName);

//        throw new io.cucumber.java.PendingException();
    }

    @When("the admin adds the actor")
    public void the_admin_adds_the_actor()
    {
        testActorRepo.save(testActor);

//        throw new io.cucumber.java.PendingException();
    }

    @Then("the actor will be be added to the database and show the entry")
    public void the_actor_will_be_added_to_the_database_and_show_the_entry()
    {

        resultsActor = testActorRepo.findActorFirstName("Test");

        Assertions.assertEquals("Test",resultsActor.getActorFirstName(),"Mismatch in first name");
        Assertions.assertEquals("Testson", resultsActor.getActorLastName(), "Mismatch in last name");

//        throw new io.cucumber.java.PendingException();
    }
}
