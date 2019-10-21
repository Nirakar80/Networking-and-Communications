import java.net.*;

public class UDPServer 
{

	public static void main(String[] args) throws Exception 
	{
		try
		{
			DatagramSocket Server_Socket =  new DatagramSocket(7080);
			
			byte[] receive = new byte[1024];
			byte[] send = new byte[1024];
			
			while (true)
			{
				receive = new byte[1024];
				DatagramPacket Receive_Packet = new DatagramPacket(receive, receive.length); 
	
				System.out.println("Waiting for packet....");
				Server_Socket.receive(Receive_Packet);
				
				String message = new String(Receive_Packet.getData());
				InetAddress IP = Receive_Packet.getAddress();
				
				int Port = Receive_Packet.getPort();
				System.out.println("Message incoming From: " + IP + " port.");
				System.out.println("Message: " + message);
				
				String Message =message.toUpperCase();
				
				send = Message.getBytes();
				
				DatagramPacket Send_Packet = new DatagramPacket(send, send.length, IP, Port);
				
				Server_Socket .send(Send_Packet);
			}
		}
		catch (SocketException e)
		{
			System.out.println("UDP Port Occupied");
			System.exit(0);
		}
	}

}
