Feature: Deuce and Advantage

  Scenario: Game is in deuce
  Given Player A has won 3 point(s) and Player B has won 3 point(s)
  And I check for deuce and advantage
  Then the game should be in deuce

  Scenario: Player A wins a point while Player B has advantage
  Given Player A has won 3 point(s) and Player B has won 3 point(s)
  And I check for deuce and advantage
  When "Player B" scores a point
  And I check for deuce and advantage
  When "Player A" scores a point
  And I check for deuce and advantage
  When "Player A" scores a point
  And I check for deuce and advantage
  When "Player A" scores a point
  And I check for deuce and advantage
  And the score should be "Win ! - 40"

  Scenario: Player A has advantage after deuce
  Given Player A has won 3 point(s) and Player B has won 3 point(s)
  And I check for deuce and advantage
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

  Scenario: No deuce when no tie 2
    Given Player A has won 2 point(s) and Player B has won 3 point(s)
    When I check for deuce and advantage
    And "Player A" scores a point
    And I check for deuce and advantage
    And "Player B" scores a point
    And I check for deuce and advantage
    And "Player A" scores a point
    And I check for deuce and advantage
    Then the score should be "40 - 40"
    And the game should be in deuce

  Scenario: Player A Equalizes after advantage
    Given Player A has won 2 point(s) and Player B has won 3 point(s)
    And "Player A" scores a point
    And I check for deuce and advantage
    Then the game should be in deuce
    Then the score should be "40 - 40"

  Scenario: Back to deuce after advantage
    Given Player A has won 2 point(s) and Player B has won 3 point(s)
    And "Player A" scores a point
    And I check for deuce and advantage
    Then the game should be in deuce
    Then the score should be "40 - 40"

  Scenario: Back to 40-40 after advantage
    Given Player A has won 2 point(s) and Player B has won 3 point(s)
    When "Player B" scores a point
    And I check for deuce and advantage
    Then the game should not be in endgame
    And the score should be "30 - Win !"

  Scenario: Win
    Given Player A has won 2 point(s) and Player B has won 3 point(s)
    When "Player B" scores a point
    And I check for deuce and advantage
    Then the game should not be in endgame
