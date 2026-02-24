/*
     Transient keyword usage.
     Demonstrating how to skip specific attributes during serialization using the transient keyword.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.io.*;

class SecretUser implements Serializable {
    String username;
    transient String password; // Will not be serialized

    SecretUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

public class TransientSerialization {
    public static void main(String[] args) {
        SecretUser su = new SecretUser("admin", "secret123");
        String filename = "secret.ser";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(su);
            System.out.println("Object with transient field serialized.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            SecretUser su2 = (SecretUser) in.readObject();
            System.out.println("De-serialized SecretUser:");
            System.out.println("Username: " + su2.username);
            System.out.println("Password (transient): " + su2.password); // Should be null
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
