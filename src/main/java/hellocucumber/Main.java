package hellocucumber;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //Player playerOne = new Player("gaveen");//W men
        //Player playerTwo = new Player("paschyz");
        //Game game = new Game(playerOne, playerTwo);
        //game.play();
       
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the first player");
        String name1 = scanner.nextLine();
        System.out.println("Enter the name of the second player");
        String name2 = scanner.nextLine();
        Player playerOne = new Player(name1);
        Player playerTwo = new Player(name2);
        Game game = new Game(playerOne, playerTwo);
        game.play();
    }
}
