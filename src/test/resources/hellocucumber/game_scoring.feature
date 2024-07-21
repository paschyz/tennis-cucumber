Feature: Game Scoring
  Scenario: Initial Game State
    Given Player A has won 0 point(s) and Player B has won 0 point(s)
    When the score is requested
    Then the score should be "love - love"

  Scenario: Player A scores a point
    Given Player A has won 0 point(s) and Player B has won 0 point(s)
    When "Player A" scores a point
    And the score is requested
    Then the score should be "15 - love"

  Scenario: Player B scores a point
    Given Player A has won 1 point(s) and Player B has won 1 point(s)
    When the score is requested
    Then the score should be "15 - 15"

  Scenario: Player A wins the game
    Given Player A has won 4 point(s) and Player B has won 0 point(s)
    When the score is requested
    Then "Player A" should win the game