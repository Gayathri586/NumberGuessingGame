import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5;   
        int rounds = 3;        
        int score = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("You have " + rounds + " rounds to play.");

        // Loop for multiple rounds
        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("\nRound " + round + " begins!");
            System.out.println("Guess the number between " + lowerBound + " and " + upperBound);
boolean guess = false;
            // Loop for attempts
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts.");
                    guess = true;
                    // Points based on attempts
                    score += (maxAttempts - attempts + 1) * 10;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guess) {
                System.out.println("❌ You’ve used all attempts! The number was " + numberToGuess);
            }
        }

        System.out.println("\n🏆 Game Over! Your final score: " + score);
        sc.close();
    }
}