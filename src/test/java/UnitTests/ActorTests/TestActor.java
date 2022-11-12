package UnitTests.ActorTests;

import SakilaAPI.ActorComponents.Actor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestActor {
    private Actor testActor = new Actor(
            600,
            "TEST",
            "TESTSON"
    );
    private Actor testActorNoID = new Actor(
            "TEST 2",
            "TESTSON JR."
    );
    private Actor testBlankActor = new Actor();

    //region Get Tests

    @Test
    public void testGetActorID()
    {
        Assertions.assertEquals(600, testActor.getID(), "Couldn't get ID");
    }

    @Test
    public void testGetBlankActorID()
    {
        Assertions.assertEquals(0, testBlankActor.getID(), "Couldn't get the blank actor's ID");
    }

    @Test
    public void testGetActorFName()
    {
        Assertions.assertEquals("TEST", testActor.getActorFirstName(), "Couldn't get actor's first name");
    }

    @Test
    public void  testGetActorLName()
    {
        Assertions.assertEquals("TESTSON", testActor.getActorLastName(), "Couldn't get actor's last name");
    }

    @Test
    public void testGetNamedActorFName()
    {
        Assertions.assertEquals("TEST 2", testActorNoID.getActorFirstName(), "Couldn't get named actor's first name");
    }

    @Test
    public void  testGetNamedActorLName()
    {
        Assertions.assertEquals("TESTSON JR.", testActorNoID.getActorLastName(), "Couldn't get named actor's last name");
    }

    //endregion

    //region Set Tests

    @Test
    public void testSetActorID()
    {
        testActor.setID(200);
        Assertions.assertEquals(200, testActor.getID(), "Couldn't set ID");
    }

    @Test
    public void testSetBlankActorID()
    {
        testBlankActor.setID(30);
        Assertions.assertEquals(30, testBlankActor.getID(), "Couldn't set the blank actor's ID");
    }

    @Test
    public void testSetActorFName()
    {
        testActor.setFirstName("NEW NAME");
        Assertions.assertEquals("NEW NAME", testActor.getActorFirstName(), "Couldn't set actor's first name");
    }

    @Test
    public void  testSetActorLName()
    {
        testActor.setActorLastName("NEW LAST NAME");
        Assertions.assertEquals("NEW LAST NAME", testActor.getActorLastName(), "Couldn't set actor's last name");
    }

    @Test
    public void testSetNamedActorFName()
    {
        testActorNoID.setFirstName("NEW NAME B");
        Assertions.assertEquals("NEW NAME B", testActorNoID.getActorFirstName(), "Couldn't set named actor's first name");
    }

    @Test
    public void  testSetNamedActorLName()
    {
        testActorNoID.setActorLastName("NEW LAST NAME B");
        Assertions.assertEquals("NEW LAST NAME B", testActorNoID.getActorLastName(), "Couldn't set named actor's last name");
    }

    //endregion
}
