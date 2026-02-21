public class DisplayRecursive {

    // Display from n to 1 (descending)
    public static void displayDescending(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        displayDescending(n - 1);
    }

    // Display from 1 to n (ascending)
    public static void displayAscending(int n) {
        if (n == 0) {
            return;
        }
        displayAscending(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.print("Display from n to 1: ");
        displayDescending(n);

        System.out.println();

        System.out.print("Display from 1 to n: ");
        displayAscending(n);
    }
}
