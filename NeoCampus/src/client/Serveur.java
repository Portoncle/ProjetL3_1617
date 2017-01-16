package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Serveur {
	private Socket socket;
	private PrintWriter msgOut;
	private BufferedReader answer;
	
	public Serveur (String ip, int port) {
		try {
			socket = new Socket(ip, port);
			msgOut = new PrintWriter(socket.getOutputStream());
			answer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}


	public void sendTo(String message) {
		System.out.println("[Client->Serveur] " + message);
		msgOut.println(message);
		msgOut.flush();
	}
	
	public String waitFrom() {
		String answerStr = null;
		try {
			answerStr = answer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("[Serveur->Client] " + answerStr);
		return answerStr;
	}
	
	public String recieveFrom() {
		String answerStr = null;
		try {
			if (answer.ready())
				answerStr = answer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("[Serveur->Client] " + answerStr);
		return answerStr;
	}
	
	public void close() {
		try {
			socket.close();
			msgOut.close();
			answer.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "[ip=" + socket.getInetAddress().toString().substring(1) + ", port=" + socket.getPort() + "]";
	}
	
	public Socket getSocket() {
		return socket;
	}


	public boolean isConnected() {
		if (socket != null) {
			return socket.isConnected();
		}
		return false;
	}
}
