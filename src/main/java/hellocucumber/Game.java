package hellocucumber;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Player playerOne;
    private final Player playerTwo;

    private boolean isDeuce = false;
    private boolean isAdvantage = false;
    private boolean isEndgame = false;

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public boolean isDeuce() {
        return isDeuce;
    }

    public boolean isAdvantage() {
        return isAdvantage;
    }

    public boolean isEndgame() {
        return isEndgame;
    }

    public void randomPlayerWinsPoint() {
        givePoint(selectRandomWinner());
    }

    public Integer selectRandomWinner() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public void givePoint(Integer playerIndex) {
        switch (playerIndex) {
            case 0:
                playerOne.winPoint();
                break;
            case 1:
                playerTwo.winPoint();
                break;
            default:
                throw new IllegalArgumentException("Invalid Index: " + playerIndex);
        }
    }

    public void displayScores(Integer roundNumber) {
        System.out.println("-------------ROUND " + roundNumber + "--------------");
        System.out.println(getScore());
        System.out.println("");
    }

    public void displayDeuceAndAdvantage() {
        System.out.println("deuce : " + isDeuce);
        System.out.println("advantage : " + isAdvantage);
        System.out.println("endgame : " + isEndgame);
    }

    public String checkWinner() {
        int scoreOne = convertScoreToNumeric(playerOne.getScore(isEndgame));
        int scoreTwo = convertScoreToNumeric(playerTwo.getScore(isEndgame));

        // Check if Player One is the winner
        if (scoreOne >= 4 && scoreOne >= scoreTwo + 2) {
            return playerOne.getName();
        }
        // Check if Player Two is the winner
        else if (scoreTwo >= 4 && scoreTwo >= scoreOne + 2) {
            return playerTwo.getName();
        }
        // No winner yet
        return null;
    }

    public void checkDeuce() {
        // Check if both players are at deuce (both at 40)
        if (playerTwo.getScore(isEndgame).equals("40") && playerOne.getScore(isEndgame).equals("40")) { // 3 represents "40"
            isDeuce = true;
            isEndgame = true;
        } else {
            isDeuce = false;
        }
    }

    public void checkAdvantage() {
        int scoreOne = convertScoreToNumeric(playerOne.getScore(isEndgame));
        int scoreTwo = convertScoreToNumeric(playerTwo.getScore(isEndgame));

        // Check if either player has an advantage
        if (scoreOne >= 4 && scoreOne >= scoreTwo + 1) {
            isAdvantage = true;
        } else if (scoreTwo >= 4 && scoreTwo >= scoreOne + 1) {
            isAdvantage = true;
        } else {
            isAdvantage = false;
        }
    }

    public void checkResetAdvantage() {
        int scoreOne = convertScoreToNumeric(playerOne.getScore(isEndgame));
        int scoreTwo = convertScoreToNumeric(playerTwo.getScore(isEndgame));

        // Reset advantage if scores are equal and advantage was active
        if (scoreOne == scoreTwo && isAdvantage) {
            resetPoints();
        }
    }

    private int convertScoreToNumeric(String score) {
        switch (score) {
            case "love":
                return 0;
            case "15":
                return 1;
            case "30":
                return 2;
            case "40":
                return 3;
            case "Advantage":
                return 4; // Representing advantage as 4
            case "Win !":
                return 5; // Representing win as 5
            default:
                throw new IllegalArgumentException("Invalid score: " + score);
        }
    }

    public void resetPoints() {
        playerOne.setScoreIndex(3);
        playerTwo.setScoreIndex(3);
        isAdvantage = false;
        isDeuce = true;
    }

    public String getScore() {
        return playerOne.getScore(isEndgame) + " - " + playerTwo.getScore(isEndgame);
    }

    public void playAutomatic() {
        Integer roundCount = 1;
        while (true) {
            randomPlayerWinsPoint();
            checkDeuce();
            checkResetAdvantage();
            checkAdvantage();
            String winnerName = checkWinner();
            displayScores(roundCount);
            if (winnerName != null) {
                System.out.println("\n" + winnerName + " wins !");
                return;
            }
            roundCount++;
        }
    }

    public void playManual() {
        Scanner scanner = new Scanner(System.in);
        Integer roundCount = 1;
        while (true) {
            System.out.println("Enter the name of the player who won the point (or 'exit' to end):");
            String winner = scanner.nextLine();
            if (winner.equalsIgnoreCase("exit")) {
                System.out.println("Game ended by user.");
                return;
            }
            if (winner.equals(playerOne.getName())) {
                givePoint(0);
            } else if (winner.equals(playerTwo.getName())) {
                givePoint(1);
            } else {
                System.out.println("Invalid player name. Please try again.");
                continue;
            }
            checkDeuce();
            checkResetAdvantage();
            checkAdvantage();
            String winnerName = checkWinner();
            displayScores(roundCount);
            if (winnerName != null) {
                System.out.println("\n" + winnerName + " wins !");
                return;
            }
            roundCount++;
        }
    }
}
