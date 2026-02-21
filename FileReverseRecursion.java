import java.io.*;

public class FileReverseRecursion {

    static void reverseDisplay(FileInputStream fin) throws IOException {
        int ch = fin.read();
        if (ch == -1)
            return;

        reverseDisplay(fin);
        System.out.print((char) ch);
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java FileReverseRecursion <filename>");
            return;
        }

        try (FileInputStream fin = new FileInputStream(args[0])) {
            System.out.println("File content in reverse order:");
            reverseDisplay(fin);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
