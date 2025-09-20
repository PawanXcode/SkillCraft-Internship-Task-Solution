import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int number = rand.nextInt(100) + 1; // 1 to 100
        int guess = 0;

        System.out.println("I have chosen a number between 1 and 100. Try to guess it!");

        while (guess != number) {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();

            if (guess > number) {
                System.out.println("Too high, try again.");
            } else if (guess < number) {
                System.out.println("Too low, try again.");
            } else {
                System.out.println("Correct! You guessed it.");
            }
        }

        sc.close();
    }
}
