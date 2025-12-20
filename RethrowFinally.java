import java.util.Scanner;

public class RethrowFinally {

    // Method that catches and re-throws exception
    static void divide(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Result = " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("Exception caught in divide() method");
            throw e;   // re-throwing exception
        }
        finally {
            System.out.println("Finally block in divide() executed");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            divide(a, b);
        }
        catch (ArithmeticException e) {
            System.out.println("Exception caught again in main()");
        }
        finally {
            sc.close();
            System.out.println("Finally block in main() executed");
        }
    }
}
