import java.util.Scanner;

public class Player {
    public String name;
    public int score;
    public Die playerDie;

    public Player(String name){
        this.name = name;
        this.score = 0;
        this.playerDie = new Die();
    }

    public String getName(){
        return this.name;
    }

    public Die getPlayerDie(){
        return this.playerDie;
    }

    public void playerRoll(){
        System.out.println(this.name + "'s turn!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 'return' to roll die");
        if (scanner.nextLine().equals("")){
            System.out.print(this.name + " is rolling...");
            int[] numRolls = this.playerDie.getNumRolls();
            String stringRolls = this.playerDie.getStringRolls(numRolls);
            int rollsRemaining = this.playerDie.getRollsRemaining();
            System.out.println("Current roll: " + stringRolls + " Rolls remaining: " + rollsRemaining);
            Scanner sc = new Scanner(System.in);
            System.out.println(" Roll again or score?");
            switch(sc.next()) {
                case "Roll again":
                    if (rollsRemaining == 1) {
                        int[] newNumRolls = this.playerDie.getNumRolls();
                        String newRolls = this.playerDie.getStringRolls(newNumRolls);
                        System.out.println("New roll: " + newRolls);
                        this.playerDie.calcScore(this.playerDie.getNumRolls(), true);
                    } else {
                        System.out.print("You are out of rolls. Your roll will now be scored automatically.");
                        this.playerDie.calcScore(numRolls, true);
                    }
                    break;
                case "score":
                    this.playerDie.calcScore(numRolls, true);
                    break;
                default:
                    System.out.println("error");
                    break;
                }
            this.score += this.playerDie.getDieScore();
            System.out.println("Player score: " + score);
        } else {
            System.out.println("error");
        }

    }
}
