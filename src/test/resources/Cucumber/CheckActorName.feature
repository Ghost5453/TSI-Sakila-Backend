Feature: Search for Actor
  As a user, I would like to search for an actor by there first or last name

  Scenario: Search for actor by name
    Given I would like to find an actor
    When I search for the actor
    Then I would like to see a list of actors with that name