Feature: Search for related genres
  As a User, I would like to chose a genre so that I can have the moves of that genre recommended

  Scenario: Shows the moves of the chosen genre
    Given a users favourite movie
    When the user searches the genra
    Then the program retent the movies