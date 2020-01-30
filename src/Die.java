import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Die {

    public int dieScore;
    public int rollsRemaining;
    public int[] rolls;

    public Die(){
        this.dieScore = 0;
        this.rollsRemaining = 2;
    }

    public int getDieScore(){
        return this.dieScore;
    }

    public int getRollsRemaining(){
        return this.rollsRemaining;
    }

    public void setNumRolls() {
        int[] rolls = new int[5];
        this.rollsRemaining--;
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int newFace = rand.nextInt(6) + 1;
            rolls[i] = newFace;
        }
        this.rolls = rolls;
    }

    public int[] getNumRolls() {
        return this.rolls;
    }

    public String getStringRolls(int[] rolls){
        return Arrays.toString(rolls);
    }

    public void calcScore(int[] rolls, boolean playerUsing){
        if (playerUsing){
            Scanner sc = new Scanner(System.in);
            System.out.println("Please type, as a number, the category in which you wish to score your rolls. Categories are: " +
                "3 of a Kind (0), Straights (1), Full House (2), and Yahtzee (3). Note: all computer rolls will be scored " +
                    "in the 3 of a Kind Category.");
            int category = Integer.parseInt(sc.next());
            int[] rollsSorted = this.sorted(rolls);
            switch (category) {
                case 0:
                    this.dieScore += threeKind(rollsSorted);
                    break;
                case 1:
                    this.dieScore += straights(rollsSorted);
                    break;
                case 3:
                    this.dieScore += yahtzee(rollsSorted);
                    break;
                default:
                    this.dieScore += 0;
            }
        } else {
            this.dieScore += threeKind(rolls);
        }
    }

    public int threeKind(int[] rolls){
        int matchPairCount = 0;
        for (int i = 0; i < rolls.length - 2; i++){
            for (int j = 1; j < rolls.length - 1; j++){
                if (rolls[i] == rolls[j] || rolls[i] == rolls[j + 1]){
                    matchPairCount++;
                }
            }
            if (matchPairCount >= 2){
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
        if (consecutiveCount >= 3){
            return 10 * consecutiveCount;
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

    // Bubble sort -- adapted from my earlier sort visualization assignment in Github
    public int[] sorted(int[] rolls){
        for (int i = 0; i < rolls.length - 1; i++){
            for (int j = 0; j < rolls.length - i - 1; j++){
                if (rolls[j] > rolls[j + 1]){
                    int placeholder = rolls[j];
                    rolls[j] = rolls[j + 1];
                    rolls[j + 1] = placeholder;
                }
            }
        }
        System.out.println(Arrays.toString(rolls));
        return rolls;
    }

    public void initiateRoll(){
        this.setNumRolls();
        int[] numRolls = this.getNumRolls();
        String stringRolls = this.getStringRolls(numRolls);
        System.out.println("Current roll: " + stringRolls + " Rolls remaining: " + this.rollsRemaining);
        Scanner sc = new Scanner(System.in);
        System.out.println("Roll again (0) or score (1)?");
        switch(Integer.parseInt(sc.next())) {
            case 0:
                if (this.rollsRemaining == 1) {
                    int[] newNumRolls = this.getNumRolls();
                    String newRolls = this.getStringRolls(newNumRolls);
                    System.out.println("New roll: " + newRolls);
                    this.calcScore(this.getNumRolls(), true);
                } else {
                    System.out.print("You are out of rolls. Your roll will now be scored automatically.");
                    this.calcScore(numRolls, true);
                }
                this.rollsRemaining = 2;
                break;
            case 1:
                this.calcScore(numRolls, true);
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}