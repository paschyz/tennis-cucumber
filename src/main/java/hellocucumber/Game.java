package hellocucumber;

import java.util.Random;

public class Game {
    private Player playerOne;
    private Player playerTwo;
    static final Integer MAX_POINTS =40;

    private boolean isDeuce = false;
    private boolean isAdvantage = false;


    public Game(Player playerOne, Player playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }
    public void randomPlayerWinsPoint(){
        givePoint(selectRandomWinner());
    }

    public Integer selectRandomWinner(){
        Random random = new Random();
        Integer randomWinnerIndex= random.nextInt(2);
        return randomWinnerIndex;
    }

    public void givePoint(Integer playerIndex){
        switch (playerIndex){
            case(0):
                playerOne.winPoint();
                break;
            case(1):
                playerTwo.winPoint();
                break;
            default:throw new IllegalArgumentException("Invalid Index: " + playerIndex);
        }
    }

    public void displayScores(Integer roundNumber){
        System.out.println("-------------ROUND "+ roundNumber+ "--------------");
        System.out.println(playerOne.getName()+ " : " + playerOne.getScore(isDeuce));
        System.out.println(playerTwo.getName()+ " : " + playerTwo.getScore(isDeuce));

    }

    public void displayDeuceAndAdvantage(){
        System.out.println("deuce : " + isDeuce);
        System.out.println("advantage : " + isAdvantage);
    }

    public String checkWinner() {
        if (playerOne.getScoreIndex() >= 4 && playerOne.getScoreIndex() >= playerTwo.getScoreIndex() + 2) {
            return playerOne.getName();
        } else if (playerTwo.getScoreIndex() >= 4 && playerTwo.getScoreIndex() >= playerOne.getScoreIndex() + 2) {
            return playerTwo.getName();
        }
        return null;
    }
    public void checkDeuce(){
        if (playerOne.getScoreIndex()>= 3 && playerTwo.getScoreIndex() >= 3 ){
            if (playerOne.getScoreIndex()==playerTwo.getScoreIndex() ){
                isDeuce=true;
            }
        }
    }

    public void checkAdvantage(){
        if (playerOne.getScoreIndex()>= 3 && playerTwo.getScoreIndex() >= 3 ){
            if (playerOne.getScoreIndex()>=playerTwo.getScoreIndex()+1 || playerTwo.getScoreIndex()>=playerOne.getScoreIndex()+1 ){
                isAdvantage=true;
            }
            checkResetAdvantage();
        }
    }

    public void checkResetAdvantage(){
        if (playerOne.getScoreIndex() == playerTwo.getScoreIndex()){
            isAdvantage=false;
            playerOne.setScoreIndex(3);
            playerTwo.setScoreIndex(3);
        }
    }


    public void play(){
        Integer roundCount = 1;
        while(true){
            randomPlayerWinsPoint();
            checkDeuce();
            checkAdvantage();
            String winnerName= checkWinner();
            displayScores(roundCount);
            if(winnerName != null){
                System.out.println("\n" + winnerName+ " wins !");
                return;
            }
            roundCount++;
        }
    }
}
