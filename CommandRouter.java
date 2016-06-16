
/* A TCP/IP Client class called CommandRouter 
* The CommandRouter that has the following method:
* public Command route(Command anyCommand)
* This method will send any Command to the ThreadedCommandServer 
* and receive the Command back from the server.
*/

import java.io.*;
import java.net.*;

public class CommandRouter{
	
	private Command cmd;
	
	CommandRouter() {
		cmd = null;
	   }

	public Command route(Command anyCommand) throws Exception {
		
		cmd=anyCommand;
		
		 Socket socketConnection = new Socket("127.0.0.1", 7000);
         System.out.println("Client IP Address: "+ socketConnection.getInetAddress() );
         System.out.println("Client Port #: "+ socketConnection.getLocalPort() );
         
         ObjectOutputStream clientOutputStream = new
            ObjectOutputStream(socketConnection.getOutputStream());
         ObjectInputStream clientInputStream = new 
            ObjectInputStream(socketConnection.getInputStream());

         clientOutputStream.writeObject(cmd);

         cmd= (Command)clientInputStream.readObject();
        
         socketConnection.close();
         
         return cmd;
	}
}

