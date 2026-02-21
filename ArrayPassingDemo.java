public class ArrayPassingDemo {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        // 1. Passing whole array
        System.out.println("1. Passing whole array:");
        printArray(numbers);

        // 2. Passing array element
        System.out.println("\n2. Passing an array element:");
        printElement(numbers[2]); // pass a single element

        // 3. Passing array to a method that returns array
        System.out.println("\n3. Returning an array from a method:");
        int[] doubled = doubleArray(numbers);
        printArray(doubled);

        // 4. Passing an anonymous array
        System.out.println("\n4. Passing an anonymous array:");
        printArray(new int[]{5, 10, 15, 20});
    }

    // ---------------- Methods -------------------

    // 1. Passing array as argument
    public static void printArray(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // 2. Passing a single element of array
    public static void printElement(int value) {
        System.out.println("Element: " + value);
    }

    // 3. Returning an array from a method
    public static int[] doubleArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] * 2; // double each value
        }
        return result;
    }
}
