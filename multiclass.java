// create a class having 2 functions add one takes 2 integers and return sum other takes 2 Strings and return concatenated String.
class MultiClass {
    // Function to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Function to concatenate two strings
    public String add(String str1, String str2) {
        return str1 + str2;
    }

    public static void main(String[] args) {
        MultiClass mc = new MultiClass();

        // Test integer addition
        int intSum = mc.add(5, 10);
        System.out.println("Sum of integers: " + intSum); // Output: 15

        // Test string concatenation
        String strConcat = mc.add("Hello, ", "World!");
        System.out.println("Concatenated string: " + strConcat); // Output: Hello, World!
    }
}