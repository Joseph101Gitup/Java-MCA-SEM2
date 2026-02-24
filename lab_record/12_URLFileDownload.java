/*
     Program to download a file from given URL.
     This program reads a resource from a URL and saves it locally.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class URLFileDownload {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter URL of the file to download: ");
        String urlString = scanner.nextLine();
        System.out.print("Enter local filename to save as: ");
        String fileName = scanner.nextLine();

        try {
            URL url = new URL(urlString);
            DataInputStream in = new DataInputStream(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            fileOutputStream.close();
            in.close();
            System.out.println("File downloaded successfully.");
        } catch (IOException e) {
            System.out.println("Error downloading file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
