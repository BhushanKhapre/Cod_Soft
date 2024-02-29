package Codsoft_Task1;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        Random random = new Random();
        char op;

        System.out.println("Welcome to the Number Guessing Game!");

        int score = 0;

        do {
            int guessedNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 5;

            System.out.println("I have selected a number between 1 and 100. Can you guess it? You have \u03325 Attempts");

            while (attempts < maxAttempts) {
                System.out.print("Enter the number you guess: ");
                int userGuess = sc1.nextInt();
                sc1.nextLine();
                attempts++;

                if (userGuess == guessedNumber) {
                    System.out.println("Congratulations! You guessed the number " + guessedNumber + " in " + "\u0332" + attempts + " attempts.");
                    score++;
                    break;
                } else if (userGuess < guessedNumber) {
                    System.out.println("Too low! Try again. " + "\u0332" + (maxAttempts - attempts) + " attempts left !" );
                } else {
                    System.out.println("Too high! Try again. " + "\u0332" + (maxAttempts - attempts) + " attempts left !" );
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + guessedNumber + ".");
            }
            System.out.println("Game over! Your score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            while (true) {
                op = sc.next().charAt(0);
                if (op == 'Y' || op == 'y' || op == 'N' || op == 'n')
                    break;
                else
                    System.out.println("Enter Y for (yes) or N for (no)");
            }
        } while (op == 'Y' || op == 'y');
    }
}
