/*
     Program to implement connection less communication.
     UDP connectionless client side.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        try (DatagramSocket ds = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {
            
            InetAddress ip = InetAddress.getLocalHost();
            byte buf[] = null;
            
            while (true) {
                System.out.print("Enter UDP message: ");
                String inp = scanner.nextLine();
                buf = inp.getBytes();
                
                DatagramPacket dpSend = new DatagramPacket(buf, buf.length, ip, 10000);
                ds.send(dpSend);
                
                if (inp.equalsIgnoreCase("bye")) break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
