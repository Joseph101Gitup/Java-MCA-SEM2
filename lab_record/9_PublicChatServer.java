/*
     Program to implement public chatting.
     Multi-threaded server side for public room chat.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.io.*;
import java.net.*;
import java.util.*;

public class PublicChatServer {
    private static Set<DataOutputStream> clientWriters = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Public Chat Server is running on port 9000...");
        try (ServerSocket serverSocket = new ServerSocket(9000)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private DataOutputStream out;
        private DataInputStream in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                
                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                String message;
                while (true) {
                    message = in.readUTF();
                    if (message.equalsIgnoreCase("bye")) break;
                    System.out.println("Broadcast: " + message);
                    synchronized (clientWriters) {
                        for (DataOutputStream writer : clientWriters) {
                            writer.writeUTF(message);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            } finally {
                if (out != null) {
                    synchronized (clientWriters) {
                        clientWriters.remove(out);
                    }
                }
                try { socket.close(); } catch (IOException e) {}
            }
        }
    }
}
