Feature: Tennis Game

  Scenario: Initial Game State
    Given both players have a score of 0
    When the score is requested
    Then the score should be "love - love"

  Scenario: Player A wins a point
    Given Player A has won 1 point(s) and Player B has won 0 point(s)
    When the score is requested
    Then the score should be "15 - love"

  Scenario: Player B wins a point
    Given Player A has won 1 point(s) and Player B has won 1 point(s)
    When the score is requested
    Then the score should be "15 - 15"

  Scenario: Player A wins a game
    Given Player A has won 4 point(s) and Player B has won 0 point(s)
    When the score is requested
    Then "Player A" should win the game

  Scenario: Game is in deuce
    Given Player A has won 3 point(s) and Player B has won 3 point(s)
    When I check for deuce
    Then the game should be in deuce



  Scenario: Player B wins a point while Player A has advantage
    Given Player A has won 4 point(s) and Player B has won 3 point(s)
    When "Player A" scores a point
    Then "Player A" should win the game

  Scenario: Player A has advantage
    Given Player A has won 3 point(s) and Player B has won 3 point(s)
    When "Player A" scores a point
    Then "Player A" should be in advantage
    
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

