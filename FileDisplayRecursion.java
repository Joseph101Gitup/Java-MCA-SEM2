import java.io.*;

public class FileDisplayRecursion {

    static void display(FileInputStream fin) throws IOException {
        int ch = fin.read();
        if (ch == -1)
            return;

        System.out.print((char) ch);
        display(fin);
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java FileDisplayRecursion <filename>");
            return;
        }

        try (FileInputStream fin = new FileInputStream(args[0])) {
            System.out.println("File content:");
            display(fin);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
