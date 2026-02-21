import java.io.*;
import java.net.*;
import java.util.Scanner;

class FileClient {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 1234);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Upload");
                System.out.println("2. Download");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                dos.writeInt(choice);

                if (choice == 1) {
                    System.out.print("Enter file name to upload: ");
                    String filename = sc.next();

                    File file = new File(filename);
                    FileInputStream fis = new FileInputStream(file);

                    System.out.print("Enter file name to upload: ");
                    String localFile = sc.next();
                    
                    System.out.print("Enter name to save on server: ");
                    String serverFile = sc.next();
                    
                    dos.writeUTF(localFile);
                    dos.writeUTF(serverFile);
                    
                    dos.writeLong(file.length());

                    byte[] buffer = new byte[4096];
                    int read;

                    while ((read = fis.read(buffer)) > 0) {
                        dos.write(buffer, 0, read);
                    }

                    fis.close();
                    System.out.println(dis.readUTF());

                } else if (choice == 2) {
                    System.out.print("Enter server file name to download: ");
                    String serverFile = sc.next();

                    System.out.print("Enter name to save on client: ");
                    String localFile = sc.next();

                    dos.writeUTF(serverFile);
                    dos.writeUTF(localFile);


                    long size = dis.readLong();
                    if (size == -1) {
                        System.out.println("File not found on server");
                        continue;
                    }

                    FileOutputStream fos = new FileOutputStream(localFile);
                    byte[] buffer = new byte[4096];
                    int read;
                    long remaining = size;

                    while ((read = dis.read(buffer, 0,
                            (int) Math.min(buffer.length, remaining))) > 0) {
                        fos.write(buffer, 0, read);
                        remaining -= read;
                    }

                    fos.close();
                    System.out.println("File downloaded successfully");

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
