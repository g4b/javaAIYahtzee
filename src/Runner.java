import java.util.Scanner;

public class Runner {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.next();
        Player player = new Player(name);
        Computer computer = new Computer();
        System.out.println(player.name + " is playing against the amazing Yahtzee AI, " + computer.name +
                ". Let the game begin...");
        // CAREFUL WITH INFINITE LOOPS BELOW
        while(player.score <= 25 && computer.score <=25){
            player.playerRoll();
            computer.computerRoll(true);
        }
        if (player.score == 25) {
            System.out.println(player.name + " wins!");
        } else {
            System.out.println(computer.name + " wins!");
        }
    }
}
