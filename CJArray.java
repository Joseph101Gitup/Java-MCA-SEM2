import java.util.*;

class CJArray {
    public static void main(String args[]) {
        int a[][] ; // Corrected array declaration
        int r, c, i, j;
        Scanner s;
        s = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns:");
        r = s.nextInt();
        c = s.nextInt();

        a = new int[r][]; 
        for (i = 0; i < r; i++) {
            a[i] = new int[c+i];
        }
        
        for (i = 0; i < r; i++) { 
            for (j = 0; j < c+i; j++) {
                System.out.println("Enter a[" + i + "][" + j + "]:");
                a[i][j] = s.nextInt();
            }
        }   
        for (i = 0; i < r; i++) {
            for (j = 0; j < c+i; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println(" ");
        }
        s.close(); 
    }
}