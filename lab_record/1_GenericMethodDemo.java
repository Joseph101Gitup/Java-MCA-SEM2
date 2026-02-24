/*
     Write a program to implement a Generic method.
     This program demonstrates a generic method that can print arrays of different types.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
public class GenericMethodDemo {

    // Generic method to print array elements
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create arrays of Integer, Double and Character
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.println("Array intArray contains:");
        printArray(intArray); // pass an Integer array

        System.out.println("\nArray doubleArray contains:");
        printArray(doubleArray); // pass a Double array

        System.out.println("\nArray charArray contains:");
        printArray(charArray); // pass a Character array
    }
}
