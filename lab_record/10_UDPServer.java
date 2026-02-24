/*
     Program to implement connection less communication.
     UDP connectionless server side.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try (DatagramSocket ds = new DatagramSocket(10000)) {
            byte[] receive = new byte[65535];
            System.out.println("UDP Server listening on port 10000...");
            
            while (true) {
                DatagramPacket dpReceive = new DatagramPacket(receive, receive.length);
                ds.receive(dpReceive);
                
                String message = new String(dpReceive.getData(), 0, dpReceive.getLength());
                System.out.println("Client: " + message);
                
                if (message.equalsIgnoreCase("bye")) {
                    System.out.println("UDP Server exiting...");
                    break;
                }
                
                // Clear the buffer after every message
                receive = new byte[65535];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
