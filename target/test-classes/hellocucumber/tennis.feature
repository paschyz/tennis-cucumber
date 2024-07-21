Feature: Tennis Game

  Scenario: Deuce scenario
    Given both players have a score of 3
    When one player scores a point
    When I check for deuce
    Then the game should be in deuce

  Scenario: Advantage scenario
    Given one player has a score of 4
    And the other player has a score of 3
    When the leading player scores a point
    When I check for advantage
    Then the game should be in advantage for the leading player

  Scenario: Player wins scenario
    Given one player has a score of 4
    And the other player has a score less than 3
    When the leading player scores a point
    Then the leading player should win the game
  
  Scenario: Comeback to deuce scenario
    Given one player has a score of 3
    And the other player has a score of 1
    When the player with the lower score scores two points
    When I check for deuce
    Then the game should be in deuce

  Scenario: Long deuce scenario
    Given both players have a score of 3
    When the score ties 10 times at deuce
    And one player eventually scores two consecutive points
    Then that player should win the game