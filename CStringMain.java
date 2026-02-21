import java.util.Scanner;

class CString {
    private String str;

    // Read string
    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        str = sc.nextLine();
    }

    // Display string
    public void display() {
        System.out.println("String: " + str);
    }

    // Compare two CString objects
    // Returns true if equal, else false
    public boolean compare(CString s) {
        return this.str.equals(s.str);
    }

    // Add two strings (same as concat but returns new CString)
    public CString add(CString s) {
        CString temp = new CString();
        temp.str = this.str + s.str;
        return temp;
    }

    // Concatenate (same as add, but kept as separate method for requirement)
    public CString concatenate(CString s) {
        CString temp = new CString();
        temp.str = this.str.concat(s.str);
        return temp;
    }
}

public class CStringMain {
    public static void main(String[] args) {

        CString s1 = new CString();
        CString s2 = new CString();

        System.out.println("Enter first string:");
        s1.read();

        System.out.println("Enter second string:");
        s2.read();

        System.out.print("\nFirst ");
        s1.display();

        System.out.print("Second ");
        s2.display();

        // Compare
        boolean isEqual = s1.compare(s2);
        System.out.println("\nAre both strings equal? " + isEqual);

        // Add
        CString addResult = s1.add(s2);
        System.out.print("Addition result: ");
        addResult.display();

        // Concatenate
        CString concatResult = s1.concatenate(s2);
        System.out.print("Concatenation result: ");
        concatResult.display();
    }
}
