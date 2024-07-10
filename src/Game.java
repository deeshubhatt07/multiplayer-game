import java.util.Scanner;

public class Game {

    private Player firstPlayer;
    private Player secondPlayer;
    private Scanner scanner;

    public Game() {
        this.scanner = new Scanner(System.in);
    }
    private Player setPlayer(String playerName) {
        Player player = new Player();

        System.out.println("Enter the health for the "+playerName+" player");
        player.setHealth(scanner.nextInt());
        System.out.println("Enter the strength for the "+playerName+" player");
        player.setStrength(scanner.nextInt());
        System.out.println("Enter the Attack for the "+playerName+" player");
        player.setAttack(scanner.nextInt());

        return player;
    }

    private void playTurn(Player attacker, Player defender) {
        int attackerDiceValue = rollDice();
        int defenderDiceValue = rollDice();

        int attackDamage = attackerDiceValue * attacker.getAttack();
        int defenseDamage = defenderDiceValue * defender.getStrength();

        int damageTaken = attackDamage - defenseDamage;

        if (damageTaken > 0) {
            int newHealth = defender.getHealth() - damageTaken;
            defender.setHealth(newHealth);
        }

        System.out.println(attackerDiceValue + " * " + attacker.getAttack() + " = " + attackDamage);
        System.out.println(defenderDiceValue + " * " + defender.getStrength() + " = " + defenseDamage);
        System.out.println("Player A Health: " + firstPlayer.getHealth());
        System.out.println("Player B Health: " + secondPlayer.getHealth());
        System.out.println();
    }

    private int rollDice() {
        return (int) (Math.random() * 6) + 1; // Roll a 6-sided die
    }

    public void setPlayers() {
        System.out.println("Setting up players...");
        System.out.println("1st player --------------------------------");
        firstPlayer = setPlayer("First");
        System.out.println("2nd player --------------------------------");
        secondPlayer = setPlayer("Second");
    }

    public void startGame() {
        System.out.println("Game starts!");

        boolean playerTurn = (firstPlayer.getHealth() < secondPlayer.getHealth()); // Player with lower health attacks first

        while (firstPlayer.getHealth() > 0 && secondPlayer.getHealth() > 0) {
            if (playerTurn) {
                playTurn(firstPlayer, secondPlayer);
            } else {
                playTurn(secondPlayer, firstPlayer);
            }
            playerTurn = !playerTurn; // Switch turns
        }

        // Determine winner
        if (firstPlayer.getHealth() <= 0) {
            System.out.println("Player B wins!");
        } else {
            System.out.println("Player A wins!");
        }
    }
    
    public static void main(String args[]) {
        Game game = new Game();

        game.setPlayers();

        game.startGame();
    }
}