//package ServerClientChat;
import java.io.*;
import java.net.*;

class MClient {
    public static void main(String arge[]) {
        try {
            Socket cs = new Socket("localhost", 1234);

            DataInputStream sin, kin;
            DataOutputStream sout;

            sin = new DataInputStream(cs.getInputStream());
            sout = new DataOutputStream(cs.getOutputStream());
            kin = new DataInputStream(System.in);

            for (;;) {
                String str = sin.readUTF();   
                System.out.println(str);

                System.out.println("Enter DATA/quit");
                str = kin.readLine();        

                sout.writeUTF(str);          

                if (str.equals("quit")) {
                    break;
                }
            }
            cs.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
