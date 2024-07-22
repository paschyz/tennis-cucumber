package hellocucumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the name of the first player:");
            String name1 = scanner.nextLine();
            System.out.println("Enter the name of the second player:");
            String name2 = scanner.nextLine();

            Player playerOne = new Player(name1);
            Player playerTwo = new Player(name2);
            Game game = new Game(playerOne, playerTwo);

            System.out.println("Choose mode: \n1. Manual\n2. Automatic");
            int mode = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            if (mode == 1) {
                game.playManual();
            } else if (mode == 2) {
                game.playAutomatic();
            } else {
                System.out.println("Invalid option. Please choose 1 or 2.");
                continue;  // Skip to the next iteration of the loop
            }

            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                System.out.println("Thanks for playing!");
                break;  // Exit the loop and end the game
            }
        }
    }
}
