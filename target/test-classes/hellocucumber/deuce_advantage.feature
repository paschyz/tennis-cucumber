Feature: Deuce and Advantage

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