import java.io.*;
import java.net.*;

class PublicMClient {
    public static void main(String args[]) {
        try {
            Socket cs = new Socket("172.16.2.15", 1234); // CHANGE IP

            DataInputStream sin = new DataInputStream(cs.getInputStream());
            DataOutputStream sout = new DataOutputStream(cs.getOutputStream());
            BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));

            // Receive thread
            Thread receive = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("\n" + sin.readUTF());
                    }
                } catch (Exception e) {}
            });
            receive.start();

            // Enter name
            System.out.print("Enter your name: ");
            String name = kin.readLine();
            sout.writeUTF(name);

            // Send messages
            String msg;
            while (true) {
                msg = kin.readLine();
                sout.writeUTF(msg);

                if (msg.equalsIgnoreCase("quit"))
                    break;
            }

            cs.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
