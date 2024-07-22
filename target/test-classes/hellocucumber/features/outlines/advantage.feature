Feature: Advantage

  Scenario: Game is in deuce at 40 points each
    Given Player A has won 3 point(s) and Player B has won 3 point(s)
    When I check for deuce and advantage
    Then the game "should not" be in advantage

  Scenario Outline: Checking for Advantage
    Given Player A has won <PlayerA_Points> point(s) and Player B has won <PlayerB_Points> point(s)
    When I check for deuce and advantage
    And "Player A" scores a point
    And I check for deuce and advantage
    Then the game <Advantage_Status> be in deuce

    Examples:
      | PlayerA_Points | PlayerB_Points | Score          | Advantage_Status |
      | 0              | 0              | 15 - love      | should not   |
      | 1              | 0              | 30 - love      | should not   |
      | 2              | 0              | 40 - love      | should not   |
      | 3              | 0              | Win ! - love   | should not   |
      | 0              | 1              | 15 - 15        | should not   |
      | 1              | 1              | 30 - 15        | should not   |
      | 2              | 1              | 40 - 15        | should not   |
      | 3              | 1              | Win ! - 15     | should not   |
      | 0              | 2              | 15 - 30        | should not   |
      | 1              | 2              | 30 - 30        | should not   |
      | 2              | 2              | 40 - 30        | should not   |
      | 3              | 2              | Win ! - 30     | should not   |
      | 0              | 3              | 15 - 40        | should not   |
      | 1              | 3              | 30 - 40        | should not   |
      | 2              | 3              | 40 - 40        | should       |
      | 3              | 3              | Advantage - 40 | should not   |
