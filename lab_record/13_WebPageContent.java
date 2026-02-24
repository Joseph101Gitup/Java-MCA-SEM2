/*
     Program to display the content of a webpage.
     This program reads and prints the source HTML of a webpage.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WebPageContent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Webpage URL (with http/https): ");
        String urlString = scanner.nextLine();

        try {
            URL url = new URL(urlString);
            DataInputStream in = new DataInputStream(url.openStream());
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            System.out.println("\n--- Webpage Content ---");
            while ((bytesRead = in.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, bytesRead));
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Error reading webpage: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
