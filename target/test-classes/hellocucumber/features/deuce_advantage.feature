Feature: Deuce and Advantage

  Scenario: Game is in deuce
  Given Player A has won 3 point(s) and Player B has won 3 point(s)
  And I check for deuce and advantage
  Then the game should be in deuce

  Scenario: Player B wins a point while Player A has advantage
  Given Player A has won 4 point(s) and Player B has won 3 point(s)
  When "Player A" scores a point
  And I check for deuce and advantage
  Then "Player A" should win the game

  Scenario: Player A has advantage after deuce
  Given Player A has won 3 point(s) and Player B has won 3 point(s)
  When "Player A" scores a point
  And I check for deuce and advantage
  Then "Player A" should be in advantage
  And the game should not be in deuce

  Scenario: Remove advantage after advantage
  Given Player A has won 4 point(s) and Player B has won 3 point(s)
  When "Player B" scores a point
  And I check for deuce and advantage
  Then "Player A" should not be in advantage

  Scenario: No deuce when no tie
    Given Player A has won 4 point(s) and Player B has won 3 point(s)
    When I check for deuce and advantage
    Then the game should not be in deuce

  Scenario: Back to deuce after advantage
    Given Player A has won 4 point(s) and Player B has won 3 point(s)
    When "Player B" scores a point
    And I check for deuce and advantage
    Then the game should be in deuce
    Then the score should be "40 - 40"

  Scenario: Back to 40-40 after advantage
    Given Player A has won 4 point(s) and Player B has won 3 point(s)
    When "Player B" scores a point
    And I check for deuce and advantage
    Then the score should be "40 - 40"


