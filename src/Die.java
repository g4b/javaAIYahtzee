import java.util.Scanner;
import java.util.Random;

public class Die {

    public int value;
    public String currentFace;
    public int numRolls;

    public Die(){
        this.value = 1;
        this.currentFace = "1";
        this.numRolls = 0;
    }

    public int getValue(){
        return value;
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
            System.out.print(currentFace);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Roll again or score?");
        switch(sc.next()) {
            case "Roll again":
                //roll again
                break;
            case "score":
                this.calcScore(rolls);
                break;
            default:
                System.out.println("error");
                break;
        }
    }

    public int calcScore(int[] rolls){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type the category in which you wish to score your rolls. Categories are:" +
                "3 of a Kind, Straights, Full House, and Yahtzee.");
        String category = sc.next();
        switch (category){
            case "3 of a Kind":
                threeKind(rolls);
                break;

        }
    }

    public int threeKind(int[] rolls){
        int score = 0;
        for (int i = 0; i < rolls.length; i++){
            //Stuff
        }
    }
}
