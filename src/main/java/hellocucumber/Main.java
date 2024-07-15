package hellocucumber;

public class Main {
    public static void main(String[] args) {
        Player playerOne = new Player("x");
        Player playerTwo = new Player("y");
        Game game = new Game(playerOne, playerTwo);
        game.play();
    }
}
