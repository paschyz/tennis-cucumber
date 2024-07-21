package hellocucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TennisGameSteps {

    private Player playerOne;
    private Player playerTwo;
    private Game game;


    @Before
    public void setUp() {
        playerOne = null;
        playerTwo = null;
        game = null;
    }
    @Given("both players have a score of {int}")
    public void both_players_have_a_score_of(Integer score) {
        playerOne = new Player("Player One");
        playerTwo = new Player("Player Two");
        playerOne.setScoreIndex(score);
        playerTwo.setScoreIndex(score);
        game = new Game(playerOne, playerTwo);
    }

    @Given("one player has a score of {int}")
    public void one_player_has_a_score_of(Integer score) {
        if (playerOne == null) {
            playerOne = new Player("Player One");
        }
        playerOne.setScoreIndex(score);
        if (playerTwo != null) {
            game = new Game(playerOne, playerTwo);
        }
    }

    @And("the other player has a score of {int}")
    public void the_other_player_has_a_score_of(Integer score) {
        if (playerTwo == null) {
            playerTwo = new Player("Player Two");
        }
        playerTwo.setScoreIndex(score);
        if (playerOne != null) {
            game = new Game(playerOne, playerTwo);
        }
    }

    @And("the other player has a score less than {int}")
    public void the_other_player_has_a_score_less_than(Integer score) {
        if (playerTwo == null) {
            playerTwo = new Player("Player Two");
        }
        Random random = new Random();
        int randomScoreIndex = random.nextInt(score);
        playerTwo.setScoreIndex(randomScoreIndex);
        if (playerOne != null) {
            game = new Game(playerOne, playerTwo);
        }
    }
    @When("one player scores a point")
    public void one_player_scores_a_point() {
        game.randomPlayerWinsPoint();
    }

    @When("I check for deuce")
    public void check() {
        game.checkDeuce();
    }

    @When("I check for advantage")
    public void checkAdvantage() {
        game.checkAdvantage();
    }
    @When("the leading player scores a point")
    public void the_leading_player_scores_a_point() {
        if(playerOne.getScoreIndex() > playerTwo.getScoreIndex()){
            playerOne.winPoint();
        }else {
            playerTwo.winPoint();
        }
    }


    @Then("the game should be in deuce")
    public void the_game_should_be_in_deuce() {
        assertEquals(true, game.isDeuce());
    }

    @Then("the game should be in advantage for the leading player")
    public void the_game_should_be_in_advantage_for_the_leading_player() {
        assertEquals(true, game.isAdvantage());
    }

    @Then("the leading player should win the game")
    public void the_leading_player_should_win_the_game() {
        String winner = game.checkWinner();
        assertEquals("Player One", winner);
    }


}
