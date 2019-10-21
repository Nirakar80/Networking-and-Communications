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
			
			DatagramPacket Send_Packet = new DatagramPacket(send, send.length, IP, 7080);
			
			Client_Socket.send(Send_Packet);
			
			DatagramPacket Receive_Packet = new DatagramPacket(receive, receive.length);
			
			System.out.println("Waiting for packet return");
			
			try
			{
				Client_Socket.receive(Receive_Packet);
				String modify = new String(Receive_Packet.getData());
				
				InetAddress Return_IP =  Receive_Packet.getAddress();
				int Port = Receive_Packet.getPort();
				System.out.println("From Server at: " + Return_IP +": " + Port );
				System.out.println("Message: " + modify);
			}
			catch (SocketTimeoutException e)
			{
				System.out.println("Timeout Occured");
			}
			
			Client_Socket.close();
		}
		catch (UnknownHostException u)
		{
			System.err.print(u);
		}
		catch (IOException i)
		{
			System.err.print(i);
		}
		
	}

}
