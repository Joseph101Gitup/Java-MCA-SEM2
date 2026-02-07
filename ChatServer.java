import java.io.*;
import java.net.*;
import java.util.*;

class ChatServer {

    static Vector<ClientHandler> clients = new Vector<>();

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Chat Server started...");

            while (true) {
                Socket s = ss.accept();
                System.out.println("New client connected");

                ClientHandler ch = new ClientHandler(s);
                clients.add(ch);
                ch.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void broadcast(String msg, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(msg);
            }
        }
    }
}

class ClientHandler extends Thread {
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;

    ClientHandler(Socket s) {
        this.s = s;
        try {
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
        } catch (Exception e) {}
    }

    public void run() {
        try {
            String name = dis.readUTF();
            ChatServer.broadcast(name + " joined the chat", this);

            while (true) {
                String msg = dis.readUTF();
                if (msg.equalsIgnoreCase("exit")) break;

                ChatServer.broadcast(name + ": " + msg, this);
            }

            ChatServer.clients.remove(this);
            ChatServer.broadcast(name + " left the chat", this);
            s.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void sendMessage(String msg) {
        try {
            dos.writeUTF(msg);
        } catch (Exception e) {}
    }
}
