import java.util.Scanner;

class Calculator {
    private double num1;
    private double num2;

    public Calculator(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double add() { 
        return num1 + num2; 
    }

    public double subtract() { 
        return num1 - num2; 
    }

    public double multiply() { 
        return num1 * num2; 
    }

    public double divide() {
        if (num2 == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return 0;
        }
        return num1 / num2;
    }
}

public class CalculatorMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        Calculator calc = new Calculator(a, b);

        System.out.println("\n------ MENU ------");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
        do {
            
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Result: " + calc.add());
                    break;

                case 2:
                    System.out.println("Result: " + calc.subtract());
                    break;

                case 3:
                    System.out.println("Result: " + calc.multiply());
                    break;

                case 4:
                    System.out.println("Result: " + calc.divide());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
