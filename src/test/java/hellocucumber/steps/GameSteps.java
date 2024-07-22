package hellocucumber.steps;

import hellocucumber.Game;
import hellocucumber.Player;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.*;

public class GameSteps {

    private Player playerA;
    private Player playerB;
    private Game game;
    private String currentScore;


    private Player getPlayerByName(String playerName) {
        switch (playerName) {
            case "Player A":
                return playerA;
            case "Player B":
                return playerB;
            default:
                throw new IllegalArgumentException("Unknown player: " + playerName);
        }
    }

    @Before
    public void setUp() {
        playerA = null;
        playerB = null;
        game = null;
        currentScore = "";

    }

    @When("I check for deuce and advantage")
    public void checkDeuceAndAdvantage() {
        game.checkDeuce();
        game.checkResetAdvantage();
        game.checkAdvantage();
    }

    @Given("Player A has won {int} point\\(s) and Player B has won {int} point\\(s)")
    public void player_a_has_won_point_and_player_b_has_won_points(int pointsA, int pointsB) {
        playerA = new Player("Player A");
        playerB = new Player("Player B");
        playerA.setScoreIndex(pointsA);
        playerB.setScoreIndex(pointsB);
        game = new Game(playerA, playerB);
    }

    @When("{string} scores a point")
    public void player_scores_a_point(String playerName) {
        getPlayerByName(playerName).winPoint();
    }
    @Then("the score should be {string}")
    public void the_score_should_be(String expectedScore) {

        currentScore=game.getScore();
        assertEquals(expectedScore, currentScore);
    }

    @Then("the game {string} be in deuce")
    public void the_game_should_be_in_deuce(String status) {
        if (status.equals("should")) {
            assertTrue(game.isDeuce());
        } else {
            assertFalse(game.isDeuce());
        }
    }
    @Then("the game should be in deuce")
    public void the_game_should_be_in_deuce() {
        assertTrue(game.isDeuce());
    }

    @Then("the game should not be in deuce")
    public void the_game_should_not_be_in_deuce() {
        assertFalse(game.isDeuce());
    }

    @Then("the game {string} be in advantage")
    public void the_game_should_be_in_advantage(String status) {
        if (status.equals("should")) {
            assertTrue(game.isAdvantage());
        } else {
            assertFalse(game.isAdvantage());
        }
    }
    @Then("the game should be in advantage")
    public void the_game_should_be_in_advantage() {
        assertTrue(game.isAdvantage());
    }

    @Then("the game should not be in advantage")
    public void the_game_should_not_be_in_advantage() {
        assertFalse(game.isAdvantage());
    }

    @Then("the game should be in endgame")
    public void the_game_should_be_in_endgame() {
        assertTrue(game.isEndgame());
    }

    @Then("the game should not be in endgame")
    public void the_game_should_not_be_in_endgame() {
        assertFalse(game.isEndgame());
    }

    @Then("{string} should win the game")
    public void player_should_win_the_game(String playerName) {
        String winner = game.checkWinner();
        assertEquals(playerName, winner);
    }
    @Then("{string} should be in advantage")
    public void player_should_be_in_advantage(String playerName) {
        Player player = getPlayerByName(playerName);
        assertEquals("Advantage", player.getScore(game.isEndgame()));
    }

    @Then("{string} should not be in advantage")
    public void player_should_not_be_in_advantage(String playerName) {
        Player player = getPlayerByName(playerName);
        assertNotEquals("Advantage", player.getScore(game.isEndgame()));
    }
}
