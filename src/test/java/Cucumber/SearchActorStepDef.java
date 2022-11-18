package Cucumber;

import SakilaAPI.ActorComponents.Actor;
import SakilaAPI.ActorComponents.ActorRepo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SearchActorStepDef
{
    @Autowired
    ActorRepo testActorRepo;
    String testFirstName;
    String testLastName;
    Actor testActor;
    List<Actor> resultsActor;

    @Given("I would like to find an actor")
    public void iWouldLikeToFindAnActor() {
       testFirstName = "GRACE";

    }

    @When("I search for the actor")
    public void iSearchForTheActor() {
        resultsActor = testActorRepo.findActorLikeName(testFirstName);
        testActor = resultsActor.get(0);
        
    }

    @Then("I would like to see a list of actors with that name")
    public void iWouldLikeToSeeAListOfActorsWithThatName() {
        Assertions.assertEquals("GRACE", testActor.getActorFirstName(), "First name didn't match");
        Assertions.assertEquals("MOSTEL", testActor.getActorLastName(), "Last name didn't match");
    }
}
