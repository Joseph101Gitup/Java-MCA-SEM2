import java.util.Scanner;

public class MultipleCatch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            int result = a / b;   // May cause ArithmeticException
            System.out.println("Result = " + result);

            int[] arr = new int[5];
            arr[10] = 100;        // May cause ArrayIndexOutOfBoundsException
        }

        catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed");
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of range");
        }

        catch (Exception e) {
            System.out.println("Error: General exception occurred");
        }

        finally {
            System.out.println("Program execution completed");
            sc.close();
        }
    }
}
