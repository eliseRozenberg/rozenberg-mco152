package rozenberg.twitter;

import org.eclipse.jetty.server.Server;

public class TwitterJettyServer {
	
	public static void main (String [] args){
		
		Server server = new Server(8080);
		//put the port number 
		server.setHandler(new TwitterHandler());
		try {
			server.start();
			server.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//server open and closes cpnnections. 
		//the handler handles the request
	}

}
