/*
     Program to implement one-one chatting.
     This is the Client side for 1-to-1 chat.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6000)) {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            String receiveMsg, sendMsg;
            while (true) {
                System.out.print("Client: ");
                sendMsg = scanner.nextLine();
                out.writeUTF(sendMsg);
                if (sendMsg.equalsIgnoreCase("bye")) break;

                receiveMsg = in.readUTF();
                if (receiveMsg != null) {
                    if (receiveMsg.equalsIgnoreCase("bye")) {
                        System.out.println("Server ended the chat.");
                        break;
                    }
                    System.out.println("Server: " + receiveMsg);
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
