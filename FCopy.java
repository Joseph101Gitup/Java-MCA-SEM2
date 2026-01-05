import java.io.*;

public class FCopy {
    public static void main(String args[]) {

        if (args.length != 2) {
            System.out.println("Usage: java FCopy <source_file> <destination_file>");
            return;
        }

        String source = args[0];
        String destination = args[1];

        int ch, count = 0;

        try (
            FileInputStream fin = new FileInputStream(source);
            FileOutputStream fout = new FileOutputStream(destination)
        ) {
            while ((ch = fin.read()) != -1) {
                fout.write(ch);
                count++;
            }

            System.out.println("File copied successfully.");
            System.out.println("Size of the file: " + count + " bytes");

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
