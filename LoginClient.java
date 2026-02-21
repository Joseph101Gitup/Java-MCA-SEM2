import java.io.*;
import java.net.*;

public class LoginClient {

    public static void main(String[] args) {

        try {
            DatagramSocket clientSocket = new DatagramSocket();

            BufferedReader keyboard =
                    new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter Username: ");
            String username = keyboard.readLine();

            System.out.print("Enter Password: ");
            String password = keyboard.readLine();

            String sendData = username + ":" + password;

            byte[] sendBuffer = sendData.getBytes();

            InetAddress serverAddress =
                    InetAddress.getByName("localhost"); // change to remote IP

            DatagramPacket sendPacket =
                    new DatagramPacket(sendBuffer, sendBuffer.length,
                            serverAddress, 5000);

            clientSocket.send(sendPacket);

            byte[] receiveBuffer = new byte[1024];

            DatagramPacket receivePacket =
                    new DatagramPacket(receiveBuffer, receiveBuffer.length);

            clientSocket.receive(receivePacket);

            String response =
                    new String(receivePacket.getData(), 0,
                            receivePacket.getLength());

            System.out.println("Server Response: " + response);

            clientSocket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}