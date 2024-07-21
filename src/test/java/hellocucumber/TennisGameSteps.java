package hellocucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TennisGameSteps {

    private Player playerA;
    private Player playerB;
    private Game game;
    private String currentScore;


    @Before
    public void setUp() {
        playerA = null;
        playerB = null;
        game = null;
        currentScore = "";

    }
    @Given("both players have a score of {int}")
    public void both_players_have_a_score_of(Integer score) {
        playerA = new Player("Player One");
        playerB = new Player("Player Two");
        playerA.setScoreIndex(score);
        playerB.setScoreIndex(score);
        game = new Game(playerA, playerB);
    }

    @Given("one player has a score of {int}")
    public void one_player_has_a_score_of(Integer score) {
        if (playerA == null) {
            playerA = new Player("Player One");
        }
        playerA.setScoreIndex(score);
        if (playerB != null) {
            game = new Game(playerA, playerB);
        }
    }


    @Given("Player A has won {int} point\\(s) and Player B has won {int} point\\(s)")
    public void player_a_has_won_point_and_player_b_has_won_points(int pointsA, int pointsB) {
        playerA = new Player("Player A");
        playerB = new Player("Player B");
        playerA.setScoreIndex(pointsA);
        playerB.setScoreIndex(pointsB);
        game = new Game(playerA, playerB);
    }
    @And("the other player has a score of {int}")
    public void the_other_player_has_a_score_of(Integer score) {
        if (playerB == null) {
            playerB = new Player("Player Two");
        }
        playerB.setScoreIndex(score);
        if (playerA != null) {
            game = new Game(playerA, playerB);
        }
    }

    @And("the other player has a score less than {int}")
    public void the_other_player_has_a_score_less_than(Integer score) {
        if (playerB == null) {
            playerB = new Player("Player Two");
        }
        Random random = new Random();
        int randomScoreIndex = random.nextInt(score);
        playerB.setScoreIndex(randomScoreIndex);
        if (playerA != null) {
            game = new Game(playerA, playerB);
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
        if(playerA.getScoreIndex() > playerB.getScoreIndex()){
            playerA.winPoint();
        }else {
            playerB.winPoint();
        }
    }

    @When("{string} scores a point")
    public void player_scores_a_point(String playerName) {
        switch (playerName) {
            case ("Player A"):
                playerA.winPoint();
                break;
            case ("Player B"):
                playerB.winPoint();
                break;
            default:
                throw new IllegalArgumentException("Unknown player name: " + playerName);
        }
    }
    @When("the score is requested")
    public void the_score_is_requested() {
        currentScore=game.getScore();
    }
    @Then("the score should be {string}")
    public void the_score_should_be(String expectedScore) {
        assertEquals(expectedScore, currentScore);
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



    @Then("{string} should win the game")
    public void player_should_win_the_game(String playerName) {
        String winner = game.checkWinner();
        assertEquals(playerName, winner);
    }
    @Then("{string} should be in advantage")
    public void player_should_be_in_advantage(String playerName) {
        Player player;
        switch (playerName) {
            case ("Player A"):
                player = playerA;
                break;
            case ("Player B"):
                player = playerB;
                break;
            default:
                throw new IllegalArgumentException("Unknown player name: " + playerName);
        }
        assertEquals("Advantage", player.getScore(true));
    }
  
  
      @When("the player with the lower score scores two points")
    public void the_player_with_the_lower_score_scores_two_points() {
        if(playerOne.getScoreIndex() > playerTwo.getScoreIndex()){
            playerTwo.winPoint();
            playerTwo.winPoint();
        }else {
            playerOne.winPoint();
            playerOne.winPoint();
        }
    }


    //Long deuce scenario

    @When("the player with the lower score scores three points")
    public void the_player_with_the_lower_score_scores_three_points() {
        if(playerOne.getScoreIndex() > playerTwo.getScoreIndex()){
            playerTwo.winPoint();
            playerTwo.winPoint();
            playerTwo.winPoint();
        }else {
            playerOne.winPoint();
            playerOne.winPoint();
            playerOne.winPoint();
        }
    }



}
