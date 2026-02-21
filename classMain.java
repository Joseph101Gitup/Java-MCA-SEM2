import java.util.Scanner;

class Student {
    private int sno;
    private String sname;
    private String sprogram;

    // Read student details
    public void read() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Number (sno): ");
        sno = sc.nextInt();
        sc.nextLine();  // Clear newline

        System.out.print("Enter Student Name: ");
        sname = sc.nextLine();

        System.out.print("Enter Student Program: ");
        sprogram = sc.nextLine();
    }

    // Display student details
    public void display() {
        System.out.println("Student Number: " + sno);
        System.out.println("Student Name: " + sname);
        System.out.println("Program: " + sprogram);
    }

    // Compare two student objects
    public boolean compare(Student s) {
        return this.sno == s.sno &&
               this.sname.equals(s.sname) &&
               this.sprogram.equals(s.sprogram);
    }
}

public class classMain {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();

        System.out.println("Enter details of first student:");
        s1.read();

        System.out.println("\nEnter details of second student:");
        s2.read();

        System.out.println("\n--- Student 1 Details ---");
        s1.display();

        System.out.println("\n--- Student 2 Details ---");
        s2.display();

        // Compare
        boolean isEqual = s1.compare(s2);
        System.out.println("\nAre both students equal? " + isEqual);
    }
}
