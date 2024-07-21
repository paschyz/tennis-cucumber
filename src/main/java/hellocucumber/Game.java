package hellocucumber;

import java.util.Random;

public class Game {
    private Player playerOne;
    private Player playerTwo;

    private boolean isDeuce = false;
    private boolean isAdvantage = false;

    public Game(Player playerOne, Player playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public boolean isDeuce() {
        return isDeuce;
    }

    public boolean isAdvantage() {
        return isAdvantage;
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
                isDeuce=true;
        }
    }

    public void checkAdvantage(){
            if (playerOne.getScoreIndex()>=playerTwo.getScoreIndex()+1 || playerTwo.getScoreIndex()>=playerOne.getScoreIndex()+1 ){
                isAdvantage=true;
            }
            checkResetAdvantage();
    }

    public void checkResetAdvantage(){
        if (playerOne.getScoreIndex() == playerTwo.getScoreIndex()){
            resetPoints();
        }
    }

    public void resetPoints(){
        isAdvantage=false;
        playerOne.setScoreIndex(3);
        playerTwo.setScoreIndex(3);
    }


    public void play(){
        Integer roundCount = 1;
        while(true){
            randomPlayerWinsPoint();
            if(!isDeuce){
                checkDeuce();
            }else{
                checkAdvantage();
            }
            displayScores(roundCount);
            String winnerName= checkWinner();
            if(winnerName != null){
                System.out.println("\n" + winnerName+ " wins !");
                return;
            }
            roundCount++;
        }
    }
}
