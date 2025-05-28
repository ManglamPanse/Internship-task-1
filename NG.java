import java.util.Scanner;
import java.util.Random;

public class NG {

    private static final int MAX_ATTEMPTS = 7;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("=== Welcome to the Number Guessing Game! ===");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nNew Round! Guess a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else if (guess > targetNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The correct number was: " + targetNumber);
            }

            roundsPlayed++;

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); 
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\n=== Game Over ===");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Thanks for playing!");
    }
}
