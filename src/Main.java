import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String playAgain = "Y";
// Use equalsIgnoreCase for prompt to play again
        while (playAgain.equalsIgnoreCase("Y")) {
            int roll = rollDice();
            System.out.println("You rolled: " + roll);
            // i
            if (roll == 2 || roll == 3 || roll == 12) {
                System.out.println("Craps! You lose.");
            // ii
            } else if (roll == 7 || roll == 11) {
                System.out.println("Natural! You win.");
            // iii
            } else {
                int nextRoll;
                while (true) {
                    // i
                    System.out.println("Trying for point: " + roll);
                    nextRoll = rollDice();
                    // ii
                    if (nextRoll == 7) {
                        System.out.println("You rolled a seven, you lose.");
                        break;
                    // iii
                    } else if (nextRoll == roll) {
                        System.out.println("You made the point! You win!");
                        break;
                    }
                }
            }

            System.out.print("Do you want to play again? [Y/N]: ");
            playAgain = in.nextLine();
        }
    }

    // From mini-lecture
    public static int rollDice() {
        Random rnd = new Random();
        int die1 = rnd.nextInt(6) + 1;
        int die2 = rnd.nextInt(6) + 1;
        int crapsRoll = die1 + die2;
        System.out.println("Rolling dice... Die 1: " + die1 + ", Die 2: " + die2 + ", Craps Roll: " + crapsRoll);
        return crapsRoll;
    }
}
