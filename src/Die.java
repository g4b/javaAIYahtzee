import java.util.Scanner;
import java.util.Random;

public class Die {

    public int dieScore;
    public int value;
    public String currentFace;
    public int rollsRemaining;

    public Die(){
        this.dieScore = 0;
        this.currentFace = "1";
        this.rollsRemaining = 0;
    }

    public int getValue(){
        return value;
    }

    public int getDieScore(){
        return dieScore;
    }

    public String getCurrentFace(){
        return currentFace;
    }

    public int getRollsRemaining(){
        return rollsRemaining;
    }

    public int[] getNumRolls() {
        int[] rolls = new int[5];
        this.rollsRemaining--;
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int newFace = rand.nextInt(6) + 1;
            this.currentFace = String.valueOf(newFace);
            this.value = newFace;
            rolls[i] = value;
            //output to screen
        }
        return rolls;
    }

    public String getStringRolls(int[] rolls){
        String stringRolls = "[";
        for (int i = 0; i < 5; i++){
            stringRolls += rolls[i];
            if (i == 4){
                stringRolls += "]";
            } else {
                stringRolls += ", ";
            }
        }
        return stringRolls;
    }

    public void calcScore(int[] rolls, boolean playerUsing){
        if (playerUsing){
            Scanner sc = new Scanner(System.in);
            System.out.println("Please type, as a number, the category in which you wish to score your rolls. Categories are: " +
                "3 of a Kind (0), Straights (1), Full House (2), and Yahtzee (3).");
            int category = Integer.parseInt(sc.next());
            switch (category) {
                case 0:
                    this.dieScore += threeKind(rolls);
                    break;
                case 1:
                    this.dieScore += straights(rolls);
                    break;
                case 3:
                    this.dieScore += yahtzee(rolls);
                    break;
                default:
                    this.dieScore += 0;
            }
        } else {
            this.dieScore += threeKind(rolls);
        }
    }

    public int threeKind(int[] rolls){
        for (int i = 0; i < rolls.length - 2; i++){
            //Stuff
            if ((rolls[i] == rolls[i + 1])&&(rolls[i+1] == rolls[i+2])){
                return 20;
            }
        }
        return 0;
    }

    public int straights(int[] rolls){
        int consecutiveCount = 0;
        for (int i = 0; i < rolls.length - 1; i++){
            if (rolls[i + 1] == rolls[i] + 1){
                consecutiveCount++;
            }
        }
        if (consecutiveCount == 3){
            return 30;
        } else if (consecutiveCount == 4){
            return 40;
        } else {
            return 0;
        }
    }

    public int yahtzee(int[] rolls){
        if (threeKind(rolls) == 20){
            for (int i = 0; i < rolls.length - 2; i++){
                if (rolls[i] == rolls[i + 1]){
                    return 50;
                }
            }
        }
        return 0;
    }
}
