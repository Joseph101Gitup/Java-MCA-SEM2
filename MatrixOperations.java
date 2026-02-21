import java.util.Scanner;

public class MatrixOperations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input matrix dimensions
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        // Declare matrices
        int[][] A = new int[rows][cols];
        int[][] B = new int[rows][cols];

        // Input Matrix A
        System.out.println("\nEnter elements of Matrix A:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // Input Matrix B
        System.out.println("\nEnter elements of Matrix B:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // ------ Matrix Addition ------
        int[][] add = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                add[i][j] = A[i][j] + B[i][j];
            }
        }

        // ------ Matrix Multiplication ------
        int[][] mul = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mul[i][j] = A[i][j] * B[i][j]; // element-wise multiplication
            }
        }

        // Display results
        System.out.println("\nMatrix Addition (A + B):");
        printMatrix(add);

        System.out.println("\nMatrix Multiplication (A * B):");
        printMatrix(mul);

        sc.close();
    }

    // Method to print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
