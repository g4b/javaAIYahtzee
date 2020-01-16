import java.util.Scanner;
import java.util.Random;

public class Die {

    public int dieScore;
    public int value;
    public String currentFace;
    public int numRolls;

    public Die(){
        this.dieScore = 0;
        this.currentFace = "1";
        this.numRolls = 0;
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

    public void firstRoll(){
        int[] rolls = new int[5];
        this.numRolls++;
        Random rand = new Random();
        for (int i = 0; i < 5; i++){
            int newFace = rand.nextInt(6) + 1;
            this.currentFace = String.valueOf(newFace);
            this.value = newFace;
            rolls[i] = value;
            //output to screen
        }
        String stringRolls = "[";
        for (int i = 0; i < 5; i++){
            stringRolls += rolls[i];
            if (i == 4){
                stringRolls += "]";
            } else {
                stringRolls += ", ";
            }
        }
        System.out.println("Current roll: " + stringRolls + " Rolls remaining: " + numRolls);
        Scanner sc = new Scanner(System.in);
        System.out.println(" Roll again or score?");
        switch(sc.next()) {
            case "Roll again":
                if (numRolls <= 2){
                    this.firstRoll();
                } else {
                    System.out.print("You are out of rolls. Your roll will now be scored automatically.");
                    this.calcScore(rolls);
                }
                break;
            case "score":
                this.calcScore(rolls);
                break;
            default:
                System.out.println("error");
                break;
        }
    }

    public void calcScore(int[] rolls){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type, as a number, the category in which you wish to score your rolls. Categories are: " +
                "3 of a Kind (0), Straights (1), Full House (2), and Yahtzee (3).");
        int category = Integer.parseInt(sc.next());
        switch (category){
            case 0:
                this.dieScore += threeKind(rolls);
            //case 1:
                //return straights(rolls);
            //case 3:


        }
        //return 0;
    }

    public int threeKind(int[] rolls){
        int score = 0;
        for (int i = 0; i < rolls.length - 2; i++){
            //Stuff
            if ((rolls[i] == rolls[i + 1])&&(rolls[i+1] == rolls[i+2])){
                score += (rolls[i]*3);
                break;
            }
        }
        return score;
    }

    /*public int straights(int[] rolls){
        int score = 0;

    }*/
}
