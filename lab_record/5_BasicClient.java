/*
     Program to implement server client communication.
     This is the Client side using TCP sockets.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.io.*;
import java.net.*;

public class BasicClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(hostname, port)) {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Hello Server!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            String response = in.readUTF();
            System.out.println("From Server: " + response);

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
