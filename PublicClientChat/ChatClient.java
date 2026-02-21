import java.io.*;
import java.net.*;

public class ChatClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            // Thread to receive messages
            Thread receiveThread = new Thread(() -> {
                try {
                    while (true) {
                        String message = input.readUTF();
                        System.out.println(message);
                    }
                } catch (Exception e) {
                    System.out.println("Disconnected from server.");
                }
            });
            receiveThread.start();

            // Send messages
            while (true) {
                String message = keyboard.readLine();
                output.writeUTF(message);

                if (message.equalsIgnoreCase("quit")) {
                    break;
                }
            }

            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}