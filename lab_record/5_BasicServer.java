/*
     Program to implement server client communication.
     This is the Server side using TCP sockets.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.io.*;
import java.net.*;

public class BasicServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server is listening on port 5000...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String text = in.readUTF();
            System.out.println("Received from client: " + text);
            out.writeUTF("Server received: " + text);

            socket.close();
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
