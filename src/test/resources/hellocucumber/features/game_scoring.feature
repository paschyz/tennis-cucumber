Feature: Game Scoring
  Scenario: Initial Game State
    Given Player A has won 0 point(s) and Player B has won 0 point(s)
    When I check for deuce and advantage
    Then the score should be "love - love"

  Scenario: Player A scores a point
    Given Player A has won 0 point(s) and Player B has won 0 point(s)
    When "Player A" scores a point
    And I check for deuce and advantage
    Then the score should be "15 - love"

  Scenario: Player A scores a point
    Given Player A has won 1 point(s) and Player B has won 1 point(s)
    When "Player A" scores a point
    And I check for deuce and advantage
    Then the score should be "30 - 15"

  Scenario: Player A wins the game at 4 points
    Given Player A has won 4 point(s) and Player B has won 0 point(s)
    And I check for deuce and advantage
    Then "Player A" should win the game

  Scenario: Player A scores the winning point
    Given Player A has won 3 point(s) and Player B has won 0 point(s)
    When "Player A" scores a point
    And I check for deuce and advantage
    Then "Player A" should win the game

