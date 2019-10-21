// Importing all required Classes.
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server 
{

	public static void main(String[] args) throws IOException 
	{
		// Initializing the DatagramSocket Class.
		DatagramSocket Socket = new DatagramSocket(1019);
		
		// Declaring and Initializing a byte array.
        byte[] get_Byte = new byte[70800];

        // Declaring a DatagramPacket Object.
        DatagramPacket Packet = null;
        
        // Creating a while loop to display CLient's input and close when client enters 'bye'
        while (true)
        {
        		
                Packet = new DatagramPacket(get_Byte, get_Byte.length);
                
                Socket.receive(Packet);
                
                // Displaying the Client's entries in a format and calling DATA method
                System.out.println("Client:-" + DATA(get_Byte));

                // Creating a if loop for exiting the program.
                if (DATA(get_Byte).toString().equals("bye"))
                {
                        System.out.println("Client sent bye.....EXITING");
                        break;
                }

                get_Byte = new byte[70800];
        }
	}

	// Creating a StringBuilder Method that accepts array of bytes as argument.
	public static StringBuilder DATA(byte[] e) 
	{
		
        if (e == null)
        {
                return null;
        }
        
        StringBuilder string = new StringBuilder();
        int i = 0;
        while (e[i] != 0)
        {
                string.append((char) e[i]);
                i++;
        }
        return string;
	}


}


