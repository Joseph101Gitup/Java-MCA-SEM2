import java.io.*;
import java.net.*;
import java.util.*;

class ClientHandler extends Thread {
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private static Vector<ClientHandler> clients = new Vector<>();

    public ClientHandler(Socket socket) throws Exception {
        this.socket = socket;
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
        clients.add(this);
    }

    public void run() {
        try {
            output.writeUTF("Welcome to Public Chat! Type 'quit' to exit.");

            while (true) {
                String message = input.readUTF();

                if (message.equalsIgnoreCase("quit")) {
                    break;
                }

                System.out.println("Message Received: " + message);

                // Broadcast to all clients
                for (ClientHandler client : clients) {
                    if (client != this) {
                        client.output.writeUTF("User: " + message);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Client disconnected.");
        } finally {
            try {
                clients.remove(this);
                socket.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server Started...");
            
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New Client Connected!");
                ClientHandler client = new ClientHandler(socket);
                client.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}