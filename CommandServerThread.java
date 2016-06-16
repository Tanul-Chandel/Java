

public class CommandServerThread extends Thread {

	//private Socket s = null;
	Command cmd;

	public CommandServerThread(Command anyCommand){
		//Socket anySocket,
		//s = anySocket;
		cmd=anyCommand;

	}

	public void run(){
		try{
			synchronized(cmd){
				//while(true){
					cmd.execute();
					cmd.notifyAll();
				//}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}


