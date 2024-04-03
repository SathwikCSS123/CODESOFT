import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 100;
        int targetNumber = (int) (Math.random() * (max - min + 1) + min);
        int attempts = 0;
        int guess = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between " + min + " and " + max + ". Try to guess it.");

        while (guess != targetNumber) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number " + targetNumber + " correctly in " + attempts + " attempts.");
            }
        }
        scanner.close();
    }
}
