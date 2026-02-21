import java.net.*;
import java.util.*;

public class LoginServer {

    // Simulated database
    static HashMap<String, String> database = new HashMap<>();

    public static void main(String[] args) {
        try {
            // Add sample users
            database.put("john", "1234");
            database.put("alice", "pass");
            database.put("admin", "admin123");

            DatagramSocket serverSocket = new DatagramSocket(5000);
            System.out.println("UDP Login Server Started...");

            byte[] receiveData = new byte[1024];
            byte[] sendData;

            while (true) {

                DatagramPacket receivePacket =
                        new DatagramPacket(receiveData, receiveData.length);

                serverSocket.receive(receivePacket);

                String clientData = new String(receivePacket.getData(), 0,
                        receivePacket.getLength());

                System.out.println("Received: " + clientData);

                // Format: username:password
                String[] parts = clientData.split(":");
                String username = parts[0];
                String password = parts[1];

                String response;

                if (database.containsKey(username) &&
                        database.get(username).equals(password)) {
                    response = "LOGIN SUCCESS";
                } else {
                    response = "LOGIN FAILED";
                }

                sendData = response.getBytes();

                InetAddress clientIP = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                DatagramPacket sendPacket =
                        new DatagramPacket(sendData, sendData.length,
                                clientIP, clientPort);

                serverSocket.send(sendPacket);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}