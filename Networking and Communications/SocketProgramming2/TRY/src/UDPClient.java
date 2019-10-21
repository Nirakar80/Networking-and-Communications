import java.io.*;
import java.net.*;

public class UDPClient 
{

	public static void main(String[] args) 
	{
		try
		{
			String HostName = new String ("127.0.1");
			
			if (args.length > 0)
				HostName = args[0];
			
			BufferedReader Input =new BufferedReader(new InputStreamReader(System.in));
			
			DatagramSocket Client_Socket = new DatagramSocket();
			InetAddress IP = InetAddress.getByName(HostName);
			
			System.out.println("Connecting to" + IP + " via UDP port 7080");
			
			byte[] receive = new byte[1024];
			byte[] send = new byte[1024];
			
			System.out.println("Enter your message: ");
			String message = Input.readLine();
			send =  message.getBytes();
			
			System.out.println("Sending " + send.length + "bytes to server.");
			
			DatagramPacket 
		}
	}

}
