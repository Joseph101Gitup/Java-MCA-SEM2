import java.io.*;
import java.util.*;

public class FWrite {
    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the file name:");
        String fn = s.nextLine();

        try (FileOutputStream fout = new FileOutputStream(fn)) {

            while (true) {
                System.out.println("Enter data / quit");
                String data = s.nextLine();

                if (data.equalsIgnoreCase("quit"))
                    break;

                fout.write((data + System.lineSeparator()).getBytes());
                fout.write("\n".getBytes());
            }

            System.out.println("Data written successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        s.close();
    }
}
