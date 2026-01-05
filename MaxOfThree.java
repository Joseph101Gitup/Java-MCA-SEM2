public class MaxOfThree {

    // Function that returns the maximum of two integers
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        int x = 12;
        int y = 25;
        int z = 7;

        // Use the max function to find the maximum of three numbers
        int maxOfThree = max(max(x, y), z);

        System.out.println("The maximum of " + x + ", " + y + ", and " + z + " is: " + maxOfThree);
    }
}
