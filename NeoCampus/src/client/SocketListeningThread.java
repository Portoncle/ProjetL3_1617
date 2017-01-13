package client;

import java.net.Socket;

public class ServeurThread extends Serveur implements Runnable {

	private Thread thread;
	private InterfaceVisualisation interfaceVisualisation;
	
	public ServeurThread(String ip, int port, InterfaceVisualisation interfaceVisualisation) {
		super(ip, port);
		thread = new Thread(this);
		this.interfaceVisualisation = interfaceVisualisation;
	}

	@Override
	public void run() {
		while (getSocket().isConnected()) {
			String answer = waitFrom();
			interfaceVisualisation.analyseMessage(answer);
		}
	}
}
