import java.util.Scanner;

// User-defined exception class
class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}

public class UserDefinedException {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter age: ");
            int age = sc.nextInt();

            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or above");
            }

            System.out.println("Eligible to vote");
        }

        catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        finally {
            sc.close();
        }
    }
}
