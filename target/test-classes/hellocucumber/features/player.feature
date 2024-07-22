Feature: Player Management

  Scenario: Creating multiple players
    Given I have created a player named "Player A"
    And I have created a player named "Player B"
    Then "Player A"'s name should be "Player A"
    And "Player B"'s name should be "Player B"
    And "Player A"'s score should be 0
    And "Player B"'s score should be 0

  Scenario: Creating a new player
    Given I have created a player named "Player A"
    Then "Player A"'s name should be "Player A"
    And "Player A"'s score should be 0
