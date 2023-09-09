import java.util.Random;
import java.util.Scanner;

public class Task1NumberGuessing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int low = 1;
        int high = 100;
        int maxAttempts = 10;
        int totalRounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game (Task1)!");
        boolean rePlay = true;

        while (rePlay) {
            int targetNumber = rand.nextInt(high - low + 1) + low;
            int attempts = 0;

            System.out.println("Number is between " + low + " to " + high);
            System.out.println("You have " + maxAttempts + " attempts to guess it");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = input.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts");
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts == maxAttempts) {
                    System.out.println("You are unable to guess,  The correct number was: " + targetNumber);
                }
            }

            System.out.print("Do you want to play again? (1/0): ");
            int flag = input.nextInt();
            if (flag != 0)
                rePlay = true;
            else
                rePlay = false;
            totalRounds++;
        }

        System.out.println("Thanks for playing! You've won: " + score + " games out of " + totalRounds);

        input.close();
    }
}
