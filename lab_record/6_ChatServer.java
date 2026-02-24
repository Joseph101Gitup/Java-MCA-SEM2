/*
     Program to implement one-one chatting.
     This is the Server side for 1-to-1 chat.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            System.out.println("Chat Server started on port 6000...");
            Socket socket = serverSocket.accept();
            System.out.println("Client joined.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            String receiveMsg, sendMsg;
            while (true) {
                receiveMsg = in.readUTF();
                if (receiveMsg != null) {
                    if (receiveMsg.equalsIgnoreCase("bye")) {
                        System.out.println("Client left the chat.");
                        break;
                    }
                    System.out.println("Client: " + receiveMsg);
                }

                System.out.print("Server: ");
                sendMsg = scanner.nextLine();
                out.writeUTF(sendMsg);
                if (sendMsg.equalsIgnoreCase("bye")) break;
            }
            socket.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
