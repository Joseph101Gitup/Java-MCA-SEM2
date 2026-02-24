/*
     Menu driven program for String operations:
     a. Length of string, b. Compare equality, c. Extract substring, d. Upper/Lower case, e. Reverse.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String str1, str2;

        do {
            System.out.println("\n--- String Operations Menu ---");
            System.out.println("1. Length of string");
            System.out.println("2. Compare for equality");
            System.out.println("3. Extract substring");
            System.out.println("4. Convert to Upper/Lower case");
            System.out.println("5. Reverse a string");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter string: ");
                    str1 = scanner.nextLine();
                    System.out.println("Length: " + str1.length());
                    break;
                case 2:
                    System.out.print("Enter first string: ");
                    str1 = scanner.nextLine();
                    System.out.print("Enter second string: ");
                    str2 = scanner.nextLine();
                    if (str1.equals(str2)) {
                        System.out.println("Strings are equal.");
                    } else {
                        System.out.println("Strings are not equal.");
                    }
                    break;
                case 3:
                    System.out.print("Enter string: ");
                    str1 = scanner.nextLine();
                    System.out.print("Enter start index: ");
                    int start = scanner.nextInt();
                    System.out.print("Enter end index: ");
                    int end = scanner.nextInt();
                    if (start >= 0 && end <= str1.length() && start < end) {
                        System.out.println("Substring: " + str1.substring(start, end));
                    } else {
                        System.out.println("Invalid indices.");
                    }
                    break;
                case 4:
                    System.out.print("Enter string: ");
                    str1 = scanner.nextLine();
                    System.out.println("Uppercase: " + str1.toUpperCase());
                    System.out.println("Lowercase: " + str1.toLowerCase());
                    break;
                case 5:
                    System.out.print("Enter string: ");
                    str1 = scanner.nextLine();
                    String reversed = new StringBuilder(str1).reverse().toString();
                    System.out.println("Reversed string: " + reversed);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
        
        scanner.close();
    }
}
