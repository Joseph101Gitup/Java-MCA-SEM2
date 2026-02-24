/*
     HAS A Serialization.
     Demonstrating serialization with object composition (HAS-A relationship).
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.io.*;

class Address implements Serializable {
    String city;
    Address(String city) { this.city = city; }
}

class Employee implements Serializable {
    String name;
    Address address; // HAS-A
    Employee(String name, Address addr) {
        this.name = name;
        this.address = addr;
    }
}

public class HASASerialization {
    public static void main(String[] args) {
        Address addr = new Address("New York");
        Employee emp = new Employee("Bob", addr);
        String filename = "emp_hasa.ser";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(emp);
            System.out.println("Object (HAS-A) serialized.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Employee emp2 = (Employee) in.readObject();
            System.out.println("De-serialized (HAS-A) Employee: Name=" + emp2.name + ", City=" + emp2.address.city);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
