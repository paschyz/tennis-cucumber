package hellocucumber;

public class Main {
    public static void main(String[] args) {
        Player playerOne = new Player("gaveen");
        Player playerTwo = new Player("paschyz");
        Game game = new Game(playerOne, playerTwo);
        game.play();
    }
}
