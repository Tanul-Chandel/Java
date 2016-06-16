/*A ThreadedCommandServer Class that will receive any command,
 * hand it off to CommandServerThread and call execute on this.
 *  When done the server will return the command object back to the router (caller).
 */

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CommandServer {

	public static void main(String[] args) throws Exception{

		Command cmd ;
		ServerSocket ss = new ServerSocket(7000);
		System.out.println("Server Waiting");

		while(true){
			Socket s =ss.accept();
			System.out.println("Server IP Address: "+ s.getLocalSocketAddress() );
			System.out.println("Server Port #: "+ s.getLocalPort() );

			ObjectInputStream serverInputStream = new ObjectInputStream(s.getInputStream());
			ObjectOutputStream serverOutputStream = new ObjectOutputStream(s.getOutputStream());


			cmd = (Command )serverInputStream.readObject();
			CommandServerThread st = new CommandServerThread(cmd);
			st.start();

			synchronized(cmd){
				cmd.wait();
				serverOutputStream.writeObject(cmd);
			}
          
		}
		
	}


}

