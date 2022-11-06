package Cucumber;

import SakilaAPI.ActorComponents.Actor;
import SakilaAPI.ActorComponents.ActorController;
import SakilaAPI.ActorComponents.ActorRepo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class RemoveActorStepDef {

    @Autowired
    ActorRepo testRepo;

    String testFirstName;
    Actor testActor;

    int testActorID;

    @Autowired
    ActorController testController = new ActorController(testRepo);

    @Given("an actor is no longer needed")
    public void an_actor_is_no_longer_needed() {
        testFirstName = "Test";
    }
    @When("the admin removes the actor")
    public void the_admin_removes_the_actor() {

        testActor = testRepo.findActorFirstName(testFirstName);
        testActorID = testActor.getID();
        testRepo.deleteById(testActorID);

    }
    @Then("the actor is removed and shows some feedback")
    public void the_actor_is_removed_and_shows_some_feedback() {
        Assertions.assertEquals(null, testRepo.findById(testActorID), "The Actor still there");
    }
}
