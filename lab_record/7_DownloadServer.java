/*
     A file name is given in the client, download the content from the server.
     Server side for file download.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.io.*;
import java.net.*;

public class DownloadServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7000)) {
            System.out.println("Download Server listening on port 7000...");
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Client connected.");
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    String fileName = in.readUTF();
                    System.out.println("Client requested file: " + fileName);

                    File file = new File(fileName);
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                    if (file.exists() && !file.isDirectory()) {
                        out.writeUTF("FOUND");
                        out.writeLong(file.length());
                        FileInputStream fis = new FileInputStream(file);
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = fis.read(buffer)) != -1) {
                            out.write(buffer, 0, bytesRead);
                        }
                        fis.close();
                        System.out.println("File sent successfully.");
                    } else {
                        out.writeUTF("NOT_FOUND");
                        System.out.println("File not found.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
