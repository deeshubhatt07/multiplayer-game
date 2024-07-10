import java.util.Scanner;

public class Game {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1st player --------------------------------");
        System.out.println("Enter the health for the first player");
        int firstPlayerHealth = scanner.nextInt();
        System.out.println("Enter the strength for the first player");
        int firstPlayerStrength = scanner.nextInt();
        System.out.println("Enter the Attack for the first player");
        int firstPlayerAttack = scanner.nextInt();

        System.out.println("2nd player --------------------------------");
        System.out.println("Enter the health for the second player");
        int secondPlayerHealth = scanner.nextInt();
        System.out.println("Enter the strength for the second player");
        int secondPlayerStrength = scanner.nextInt();
        System.out.println("Enter the Attack for the second player");
        int secondPlayerAttack = scanner.nextInt();
        
    }
}