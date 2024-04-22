import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 100;
    private static final int MAX_ATTEMPTS = 7;
    private static final int ROUNDS = 3;

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to the Guess the Number Game!");

        int totalScore = playGame();

        System.out.println("\nGame over! Your total score is: " + totalScore);
    }

    private static int playGame() {
        int totalScore = 0;

        for (int round = 1; round <= ROUNDS; round++) {
            System.out.println("\nRound " + round + " of " + ROUNDS);

            int secretNumber = generateRandomNumber();

            int roundScore = playRound(secretNumber);
            totalScore += roundScore;
        }

        return totalScore;
    }

    private static int generateRandomNumber() {
        return RANGE_START + random.nextInt(RANGE_END - RANGE_START + 1);
    }

    private static int playRound(int secretNumber) {
        int attempts = 0;
        int score = 0;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess (attempt " + (attempts + 1) + " of " + MAX_ATTEMPTS + "): ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You've guessed the number.");
                score = calculateScore(attempts);
                break;
            } else if (userGuess < secretNumber) {
                System.out.println("The number is higher than your guess.");
            } else {
                System.out.println("The number is lower than your guess.");
            }
        }

        if (attempts == MAX_ATTEMPTS && score == 0) {
            System.out.println("Sorry! You've reached the maximum attempts. The secret number was: " + secretNumber);
        }

        return score;
    }

    private static int calculateScore(int attempts) {
        return MAX_ATTEMPTS - attempts + 1;
    }
}