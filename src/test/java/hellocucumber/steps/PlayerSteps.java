package hellocucumber.steps;

import hellocucumber.Game;
import hellocucumber.Player;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerSteps {

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

    @Given("I have created a player named {string}")
    public void i_have_created_a_player_named(String playerName) {
        switch (playerName) {
            case ("Player A"):
                playerA = new Player(playerName);
                break;
            case ("Player B"):
                playerB = new Player(playerName);
                break;
            default:
                throw new IllegalArgumentException("Unknown player name: " + playerName);
        }
    }

    @Then("{string}'s name should be {string}")
    public void the_player_s_name_should_be(String playerName, String expectedName) {
        Player player = getPlayerByName(playerName);
        assertEquals(expectedName, player.getName());
    }

    @Then("{string}'s score should be {int}")
    public void the_player_s_score_should_be(String playerName,Integer expectedScore) {
        Player player = getPlayerByName(playerName);
        assertEquals(expectedScore, player.getScoreIndex());
    }
}
