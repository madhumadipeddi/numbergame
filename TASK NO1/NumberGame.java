 import java.util.Scanner;
import java.util.Random;
public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int playAgain;

        do {
            int numberToGuess = rand.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            int guess;
            boolean guessedCorrectly = false;

            System.out.println("Guess a number between 1 and 100. You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                guess = sc.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all attempts. The number was " + numberToGuess);
            }

            System.out.print("Do you want to play again? (1 for Yes / 0 for No): ");
            playAgain = sc.nextInt();

        } while (playAgain == 1);

        System.out.println("Thank you for playing!");
        sc.close();
    }
}

    

