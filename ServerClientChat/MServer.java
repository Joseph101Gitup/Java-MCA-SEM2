//package ServerClientChat;
import java.io.*;
import java.net.*;


class OneClient extends Thread{
	Socket as;
	DataInputStream sin;
	DataOutputStream sout;
	public OneClient(Socket s) throws Exception
	{
		as = s;
		sin = new DataInputStream(as.getInputStream());
		sout = new DataOutputStream(as.getOutputStream());
	}
	public void run(){
		try{
			String str = "welcome";
			for(;;){
				sout.writeUTF("From Srever :"+str);
				str = sin.readUTF();
				if(str.equals("quit"))
					break;
				System.out.println("From Client :"+str);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
class MServer
{
	public static void main(String args[])
	{
		ServerSocket ss;
		try{
			ss = new ServerSocket(1234);
			for(;;){
				System.out.println("Server Waiting....");
				Socket as=ss.accept();
				System.out.println("Client Connected");
				OneClient obj = new OneClient(as);
				obj.start();
		}
	}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
