import java.io.*;
import java.net.*;

class FileServer {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Server started...");

            while (true) {
                Socket s = ss.accept();
                System.out.println("Client connected");

                new ClientHandler(s).start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class ClientHandler extends Thread {
    Socket s;

    ClientHandler(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            while (true) {
                int choice = dis.readInt();

                if (choice == 1) { // Upload
                    String localFile = dis.readUTF();  
                    String serverFile = dis.readUTF();
                    long size = dis.readLong();

                    FileOutputStream fos = new FileOutputStream(serverFile);
                    byte[] buffer = new byte[4096];
                    int read;
                    long remaining = size;

                    while ((read = dis.read(buffer, 0,
                            (int) Math.min(buffer.length, remaining))) > 0) {
                        fos.write(buffer, 0, read);
                        remaining -= read;
                    }

                    fos.close();
                    dos.writeUTF("File uploaded successfully");

                } else if (choice == 2) { // Download
                    String serverFile = dis.readUTF();
                    String localFile = dis.readUTF(); // read but not used on server
                    
                    File file = new File(serverFile);
                    
                    if (!file.exists()) {
                        dos.writeLong(-1);
                        continue;
                    }

                    dos.writeLong(file.length());
                    FileInputStream fis = new FileInputStream(file);
                    byte[] buffer = new byte[4096];
                    int read;

                    while ((read = fis.read(buffer)) > 0) {
                        dos.write(buffer, 0, read);
                    }

                    fis.close();

                } else {
                    break;
                }
            }

            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
