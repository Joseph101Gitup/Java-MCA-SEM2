import java.util.Scanner;

class Employee {
    int eno;
    String ename;
    double sal;

    void read(Scanner sc) {
        System.out.print("Enter Employee Number: ");
        eno = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee Name: ");
        ename = sc.nextLine();
        System.out.print("Enter Employee Salary: ");
        sal = sc.nextDouble();
    }

    void display() {
        System.out.println(eno + "\t" + ename + "\t" + sal);
    }

    boolean compareEno(int e) {
        return this.eno == e;
    }
}

public class Employee1{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        Employee[] emp = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.err.println("Enter details for Employee " + (i + 1) + ":");
            emp[i] = new Employee();
            emp[i].read(sc);
        }

        System.out.println("\n Empoloyee Details:\n");
        System.out.println("Eno\tEname\tSalary");
        for (int i = 0; i < n; i++) {   
            emp[i].display();
        }

        System.out.print("\nEnter Employee Number to search: ");
        int searchEno = sc.nextInt();

        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (emp[i].compareEno(searchEno)) {
                System.out.println("Employee found:");
                emp[i].display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee with number " + searchEno + " not found.");
        }
    }
}
