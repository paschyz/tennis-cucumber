package hellocucumber;

import java.util.List;

public class Player {
    private String name;
    private int scoreIndex;


    public Player(String name) {
        this.name = name;
        this.scoreIndex = 0;
    }

    public String getName() {
        return name;
    }

    public int getScoreIndex() {
        return scoreIndex;
    }
    public String getScore(boolean isDeuce){
        if(isDeuce){
            switch (scoreIndex){
                case(0):return "love";
                case(1):return "15";
                case(2):return "30";
                case(3):return "40";
                case(4):return "Advantage";
                case(5):return "Win !";
                default:throw new IllegalArgumentException("Invalid score: " + scoreIndex);
            }
        }else{

        switch (scoreIndex){
            case(0):return "love";
            case(1):return "15";
            case(2):return "30";
            case(3):return "40";
            case(4):return "Win !";
            default:throw new IllegalArgumentException("Invalid score: " + scoreIndex);
        }
        }
    }
    public void winPoint(){
        this.scoreIndex++;
    }

    public void setScoreIndex(int scoreIndex) {
        this.scoreIndex = scoreIndex;
    }
}
