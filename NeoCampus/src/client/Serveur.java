package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Serveur {
	private Socket socket;
	private PrintWriter msgOut;
	
	public Serveur (String ip, int port) {
		try {
			socket = new Socket(ip, port);
			msgOut = new PrintWriter(socket.getOutputStream());
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
