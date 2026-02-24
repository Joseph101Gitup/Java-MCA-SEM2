/*
     Upload the content from client to server.
     Server side for receiving uploaded file content.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.io.*;
import java.net.*;

public class UploadServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            System.out.println("Upload Server listening on port 8000...");
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    String fileName = dis.readUTF();
                    long fileSize = dis.readLong();
                    System.out.println("Receiving file: " + fileName + " (" + fileSize + " bytes)");

                    FileOutputStream fos = new FileOutputStream("uploaded_" + fileName);
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    long totalRead = 0;
                    while (totalRead < fileSize && (bytesRead = dis.read(buffer, 0, (int)Math.min(buffer.length, fileSize - totalRead))) != -1) {
                        fos.write(buffer, 0, bytesRead);
                        totalRead += bytesRead;
                    }
                    fos.close();
                    System.out.println("File uploaded successfully.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
