Feature: Remove an actor from the database
  As an admin, I would like to remove an actor from the database when they are not needed

  Scenario: Remove an actor from the database
    Given an actor is no longer needed
    When the admin removes the actor
    Then the actor is removed and shows some feedback