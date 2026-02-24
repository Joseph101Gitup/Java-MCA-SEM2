/*
     Program to get protocol, file name, host, path and port of a given URL.
     This program extracts metadata from a URL object.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.net.URL;
import java.util.Scanner;

public class URLInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter URL (e.g., http://www.example.com:80/index.html): ");
        String urlString = scanner.nextLine();

        try {
            URL url = new URL(urlString);
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Default Port: " + url.getDefaultPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("File: " + url.getFile());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Authority: " + url.getAuthority());
        } catch (Exception e) {
            System.out.println("Invalid URL: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
