package Cucumber;


import ApiComponents.Sakila.Project.Actor;
import ApiComponents.Sakila.Project.ActorRepo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class AddAnActorToDBDef {

    ActorRepo testActorRepo;
    String testFirstName;
    String testLastName;
    Actor testActor;

    @Given("a new actor needs to be added")
    public void a_new_actor_needs_to_be_added()
    {
        testFirstName = "Test";
        testLastName = "Testson";
        testActor = new Actor(testFirstName, testLastName);

        throw new io.cucumber.java.PendingException();
    }

    @When("the admin adds the actor")
    public void the_admin_adds_the_actor()
    {

        testActorRepo.save(testActor);

        throw new io.cucumber.java.PendingException();
    }

    @Then("the actor will be be added to the database and show the entry")
    public void the_actor_will_be_added_to_the_database_and_show_the_entry()
    {

        Assertions.assertEquals("","","");

        throw new io.cucumber.java.PendingException();
    }
}
