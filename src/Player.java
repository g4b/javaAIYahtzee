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
            this.playerDie.firstRoll();
            this.score += this.playerDie.getDieScore();
        } else {
            System.out.println("error");
        }

    }
}
