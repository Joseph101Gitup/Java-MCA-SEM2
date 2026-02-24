/*
     IS A Serialization.
     Demonstrating serialization in an inheritance hierarchy.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.io.*;

class Person implements Serializable {
    String name;
    Person(String name) { this.name = name; }
}

class User extends Person {
    int id;
    User(String name, int id) {
        super(name);
        this.id = id;
    }
}

public class ISASerialization {
    public static void main(String[] args) {
        User u1 = new User("Alice", 501);
        String filename = "user_isa.ser";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(u1);
            System.out.println("Object (IS-A) serialized.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            User u2 = (User) in.readObject();
            System.out.println("De-serialized (IS-A) User: Name=" + u2.name + ", ID=" + u2.id);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
