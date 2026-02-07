package ServerClientChat;
import java.io.*;
import java.net.*;
import java.util.*;

class POneClient extends Thread {
    Socket as;
    DataInputStream sin;
    DataOutputStream sout;

    static LinkedList<POneClient> clientList = new LinkedList<>();

    public POneClient(Socket s) throws Exception {
        as = s;
        sin = new DataInputStream(as.getInputStream());
        sout = new DataOutputStream(as.getOutputStream());

        synchronized (clientList) {
            clientList.add(this);
        }
    }

    public void run() {
        try {
            sout.writeUTF("Welcome to Public Chat System");

            while (true) {
                String msg = sin.readUTF();

                if (msg.equalsIgnoreCase("quit")) {
                    break;
                }

                System.out.println("Client: " + msg);
                broadcast(msg);
            }

            as.close();
            synchronized (clientList) {
                clientList.remove(this);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    void broadcast(String msg) {
        synchronized (clientList) {
            for (POneClient c : clientList) {
                try {
                    c.sout.writeUTF("Public: " + msg);
                } catch (Exception e) {}
            }
        }
    }
}

class PublicServer {
    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Public Chat Server Started...");

            while (true) {
                Socket as = ss.accept();
                System.out.println("Client Connected");

                POneClient obj = new POneClient(as);
                obj.start();
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
