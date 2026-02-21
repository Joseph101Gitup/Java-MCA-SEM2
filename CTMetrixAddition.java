import java.util.*;

class CTMetrixAddition {
    public static void main(String args[]) {
        int a[][] ,b[][], sum[][]; 
        int r, c, i, j;
        Scanner s;
        s = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns:");
        r = s.nextInt();
        c = s.nextInt();

        System.out.println("Enter elements of first matrix:");
        a = new int[r][c]; 
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                System.out.println("Enter a[" + i + "][" + j + "]:");
                a[i][j] = s.nextInt();
            }
        }
        System.out.println("Enter elements of second matrix:");
        b = new int[r][c];
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                System.out.println("Enter b[" + i + "][" + j + "]:");
                b[i][j] = s.nextInt();
            }
        }
        sum = new int[r][c];
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        System.out.println("First matrix is:");
        for (i = 0; i < r; i++) { 
            for (j = 0; j < c; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Second matrix is:");
        for (i = 0; i < r; i++) {   
            for (j = 0; j < c; j++) {
                System.out.print(b[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Sum of the two matrices:");
        for (i = 0; i < r; i++) {   
            for (j = 0; j < c; j++) {
                System.out.print(sum[i][j] + "\t");
            }
            System.out.println();
        }

        s.close(); 
    }
}