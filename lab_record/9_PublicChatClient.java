/*
     Program to implement public chatting.
     Client side for connecting to a multi-client chat room.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PublicChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9000)) {
            System.out.println("Connected to the public chat!");
            
            // Thread to read messages from server
            new Thread(() -> {
                try {
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    String msg;
                    while (true) {
                        msg = in.readUTF();
                        System.out.println("\n[Public] " + msg);
                        System.out.print("> ");
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            }).start();

            // Main thread to send messages
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String message;
            System.out.print("> ");
            while (true) {
                message = scanner.nextLine();
                out.writeUTF(message);
                if (message.equalsIgnoreCase("bye")) break;
            }
            socket.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
