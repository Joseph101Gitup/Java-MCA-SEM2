import java.io.*;
import java.net.*;
import java.util.*;

class ChatClient {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 1234);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            dos.writeUTF(name);

            // Thread to receive messages
            new Thread(() -> {
                try {
                    while (true) {
                        String msg = dis.readUTF();
                        System.out.println(msg);
                    }
                } catch (Exception e) {}
            }).start();

            // Sending messages
            while (true) {
                String msg = sc.nextLine();
                dos.writeUTF(msg);
                if (msg.equalsIgnoreCase("exit")) break;
            }

            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
