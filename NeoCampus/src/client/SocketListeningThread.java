package client;

public class SocketListeningThread implements Runnable {

	private InterfaceVisualisation interfaceVisualisation;
	private Serveur serveur;
	
	public SocketListeningThread(Serveur serveur, InterfaceVisualisation interfaceVisualisation) {
		this.serveur = serveur;
		this.interfaceVisualisation = interfaceVisualisation;
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		while (!serveur.getSocket().isClosed()) {
			String answer = serveur.waitFrom();
			interfaceVisualisation.analyseMessage(answer);
		}
	}
}
