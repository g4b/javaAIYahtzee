public class Computer extends Player {

    public Computer(){
        super("CARRIE_ANNE");
    }

    public void computerRoll(boolean signal){
        if (signal){
            System.out.println(this.name + "'s turn! " + this.name + " is rolling...");
            System.out.println(this.name + "'s current roll: " + this.playerDie.getStringRolls(this.playerDie.getNumRolls()));
            this.playerDie.calcScore(this.playerDie.getNumRolls(), false);
        } else {
            System.out.println(this.name + " died. Please reload and try again.");
        }
    }

}
