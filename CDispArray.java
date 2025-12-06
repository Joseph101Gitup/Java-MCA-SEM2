// A function read and returns a array another function displays the array the 
// third function takes an array and an searching value return the index if found or -1 if not founds
import java.util.*;

class CDispArray {
    
    // Function to read and return an array
    static int[] readArray(int n, Scanner s) {
        int arr[] = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element[" + i + "]:");
            arr[i] = s.nextInt();
        }
        return arr;
    }

    // Function to display an array
    static void displayArray(int arr[]) {
        System.out.println("Array elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    // Function to search and return index
    static int searchArray(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // Found
            }
        }
        return -1; // Not found
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n, key;

        System.out.println("Enter number of elements:");
        n = s.nextInt();

        // Read array
        int arr[] = readArray(n, s);

        // Display array
        displayArray(arr);

        // Search value
        System.out.println("Enter value to search:");
        key = s.nextInt();

        int index = searchArray(arr, key);

        if (index == -1)
            System.out.println("Value not found.");
        else
            System.out.println("Value found at index: " + index);

        s.close();
    }
}
