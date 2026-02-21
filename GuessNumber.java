import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int secret = 25;   // Secret number between 20 and 30
        int guess;
        int attempts = 0;

        System.out.println("Guess a number between 20 and 30:");

        // do-while loop for repeated guessing
        do {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if (guess < secret) {
                System.out.println("Too low! Try again.");
            } else if (guess > secret) {
                System.out.println("Too high! Try again.");
            }

        } while (guess != secret);

        System.out.println("\n🎉 Correct! You guessed the number!");
        System.out.println("Total attempts: " + attempts);

        sc.close();
    }
}
