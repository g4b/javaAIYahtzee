import java.util.Scanner;

public class Runner {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.next();
        Player player = new Player(name);
        Computer computer = new Computer();
        player.playerRoll();
    }
}
