import java.io.*;
import java.util.*;

public class FindReplace {

    static void process(List<String> lines, int index, String find, String replace, StringBuilder result) {
        if (index == lines.size())
            return;

        result.append(lines.get(index).replace(find, replace))
              .append(System.lineSeparator());

        process(lines, index + 1, find, replace, result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String filename = sc.nextLine();

        System.out.print("Enter word to find: ");
        String find = sc.nextLine();

        System.out.print("Enter word to replace: ");
        String replace = sc.nextLine();

        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
            return;
        }

        StringBuilder result = new StringBuilder();
        process(lines, 0, find, replace, result);

        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(result.toString());
            System.out.println("Find and replace completed.");
        } catch (IOException e) {
            System.out.println("Error writing file");
        }

        sc.close();
    }
}
