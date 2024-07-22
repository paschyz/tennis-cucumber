Feature: Tennis Game Winning

  Scenario Outline: Player A scores the winning point
    Given Player A has won <PlayerA_Points> point(s) and Player B has won <PlayerB_Points> point(s)
    When "Player A" scores a point
    And I check for deuce and advantage
    Then "Player A" should win the game

  Examples:
    | PlayerA_Points | PlayerB_Points |
    | 3              | 0              |
    | 3              | 1              |
    | 3              | 2              |

  Scenario: Player A wins the game at 4 points
    Given Player A has won 4 point(s) and Player B has won 0 point(s)
    When I check for deuce and advantage
    Then "Player A" should win the game

  Scenario: Player A wins a point while Player B has advantage
    Given Player A has won 3 point(s) and Player B has won 3 point(s)
    And I check for deuce and advantage
    And "Player B" scores a point
    And I check for deuce and advantage
    And "Player A" scores a point
    And I check for deuce and advantage
    And "Player A" scores a point
    And I check for deuce and advantage
    And "Player A" scores a point
    And I check for deuce and advantage
    Then the score should be "Win ! - 40"