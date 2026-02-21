//Write a program to display he size of the given file
import java.io.*;
import java.util.*;

public class FSixe {
    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        String fn;
        FileInputStream fin;
        int count=0;
        int ch;
        s = new Scanner(System.in);
        System.out.println("Enter the file name:");
        fn = s.nextLine();

        try  {
            fin = new FileInputStream(fn);
            while (true) {
                ch = fin.read();
                if (ch == -1)
                    break;
                count++;
            }
            fin.close();
            System.out.println("The size of the file is: " + count + " bytes");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        s.close();
    }
}