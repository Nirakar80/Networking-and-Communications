// Importing all required Classes.
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client 
{

	public static void main(String[] args) throws IOException 
	{
		// Initializing the Scanner Class.
		Scanner in = new Scanner(System.in);

        // Initializing the DatagramSocket Class. 
        DatagramSocket Socket = new DatagramSocket();
        
        // Initializing the InetAddress Class.
        InetAddress IA = InetAddress.getLocalHost();
        byte bytes[] = null;

        // Creating a while loop to close the program when the client enters 'bye' 
        while (true)
        {
                String UserInput = in.nextLine();

                bytes = UserInput.getBytes();

                //  Initializing the DatagramPacket Class. 
                DatagramPacket Packet = new DatagramPacket(bytes, bytes.length, IA, 2019);

                // Sending the Packet object to the DatagramSocket Class.
                Socket.send(Packet);
                
                if (in.equals("bye"))
                        break;
        }

	}

}
