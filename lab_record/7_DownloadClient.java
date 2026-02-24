/*
     A file name is given in the client, download the content from the server.
     Client side for requesting and saving file content.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class DownloadClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name to download from server: ");
        String fileName = scanner.nextLine();

        try (Socket socket = new Socket("localhost", 7000)) {
            DataOutputStream outRequest = new DataOutputStream(socket.getOutputStream());
            outRequest.writeUTF(fileName);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            String response = in.readUTF();

            if (response.equals("FOUND")) {
                long fileSize = in.readLong();
                FileOutputStream fos = new FileOutputStream("downloaded_" + fileName);
                byte[] buffer = new byte[4096];
                int bytesRead;
                long totalRead = 0;
                while (totalRead < fileSize && (bytesRead = in.read(buffer, 0, (int)Math.min(buffer.length, fileSize - totalRead))) != -1) {
                    fos.write(buffer, 0, bytesRead);
                    totalRead += bytesRead;
                }
                fos.close();
                System.out.println("File " + fileName + " downloaded as 'downloaded_" + fileName + "' (" + totalRead + " bytes)");
            } else {
                System.out.println("Server says: File not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
