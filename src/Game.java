import java.util.Scanner;

class Player {
    private int health;
    private int strength;
    private int attack;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}

public class Game {
    public Player setPlayer(String playerName) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();

        System.out.println("Enter the health for the "+playerName+"player");
        player.setHealth(scanner.nextInt());
        System.out.println("Enter the strength for the "+playerName+"player");
        player.setStrength(scanner.nextInt());
        System.out.println("Enter the Attack for the "+playerName+"player");
        player.setAttack(scanner.nextInt());

        return player;
    }

    public static void main(String args[]) {
        Game game = new Game();

        System.out.println("1st player --------------------------------");
        Player firstPlayer = game.setPlayer("First");
        System.out.println("2nd player --------------------------------");
        Player secondPlayer = game.setPlayer("Second");

//      To check which player will throw the dice, if true then 2nd player will throw and vice versa
        boolean playerTurn = (firstPlayer.getHealth()>=secondPlayer.getHealth()) ? true : false;

        int i=0;
        while(i<2) {
            if(playerTurn) {
                int secondPlayerDiceValue = (int) (Math.random() * (6 - 1)) + 1;
                playerTurn = false;
            } else {
                int firstPlayerDiceValue = (int) (Math.random() * (6 - 1)) + 1;
                playerTurn = true;
            }
            i++;
        }
    }
}