public class SimpleCalculator {
    
    public static void main(String[] args) {
        // Check if sufficient arguments are provided
        if (args.length < 3) {
            System.out.println("Usage: java SimpleCalculator <number1> <operator> <number2>");
            System.out.println("Operators: +, -, *, /, %, ^");
            System.out.println("Example: java SimpleCalculator 10 + 5");
            return;
        }
        
        try {
            // Parse command-line arguments
            double num1 = Double.parseDouble(args[0]);
            String operator = args[1];
            double num2 = Double.parseDouble(args[2]);
            
            double result = 0;
            boolean validOperation = true;
            
            // Perform calculation using switch-case
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    System.out.println(num1 + " + " + num2 + " = " + result);
                    break;
                    
                case "-":
                    result = num1 - num2;
                    System.out.println(num1 + " - " + num2 + " = " + result);
                    break;
                    
                case "*":
                case "x":
                case "X":
                    result = num1 * num2;
                    System.out.println(num1 + " * " + num2 + " = " + result);
                    break;
                    
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed!");
                        validOperation = false;
                    } else {
                        result = num1 / num2;
                        System.out.println(num1 + " / " + num2 + " = " + result);
                    }
                    break;
                    
                case "%":
                    if (num2 == 0) {
                        System.out.println("Error: Modulo by zero is not allowed!");
                        validOperation = false;
                    } else {
                        result = num1 % num2;
                        System.out.println(num1 + " % " + num2 + " = " + result);
                    }
                    break;
                    
                case "^":
                case "**":
                    result = Math.pow(num1, num2);
                    System.out.println(num1 + " ^ " + num2 + " = " + result);
                    break;
                    
                default:
                    System.out.println("Error: Invalid operator '" + operator + "'");
                    System.out.println("Supported operators: +, -, *, /, %, ^");
                    validOperation = false;
            }
            
            // Display result summary
            if (validOperation) {
                System.out.println("\nCalculation completed successfully!");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format!");
            System.out.println("Please enter valid numbers.");
            System.out.println("Example: java SimpleCalculator 10 + 5");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
