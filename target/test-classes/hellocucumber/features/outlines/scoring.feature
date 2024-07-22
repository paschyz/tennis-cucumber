Feature: Tennis Game Scoring

  Scenario: Initial Game State
    Given Player A has won 0 point(s) and Player B has won 0 point(s)
    When I check for deuce and advantage
    Then the score should be "love - love"

  Scenario Outline: Player A scores a point
    Given Player A has won <PlayerA_Points> point(s) and Player B has won <PlayerB_Points> point(s)
    And I check for deuce and advantage
    When "Player A" scores a point
    And I check for deuce and advantage
    Then the score should be "<Expected_Score>"

    Examples:
      | PlayerA_Points | PlayerB_Points | Expected_Score |
      | 0              | 0              | 15 - love      |
      | 1              | 0              | 30 - love      |
      | 2              | 0              | 40 - love      |
      | 3              | 0              | Win ! - love   |
      | 0              | 1              | 15 - 15        |
      | 1              | 1              | 30 - 15        |
      | 2              | 1              | 40 - 15        |
      | 3              | 1              | Win ! - 15     |
      | 0              | 2              | 15 - 30        |
      | 1              | 2              | 30 - 30        |
      | 2              | 2              | 40 - 30        |
      | 3              | 2              | Win ! - 30     |
      | 0              | 3              | 15 - 40        |
      | 1              | 3              | 30 - 40        |
      | 2              | 3              | 40 - 40        |
      | 3              | 3              | Advantage - 40 |

