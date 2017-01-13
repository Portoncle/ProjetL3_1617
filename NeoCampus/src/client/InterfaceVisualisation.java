package client;

import java.util.ArrayList;
import java.util.List;

import ressources.Adresse;
import ressources.CapteurDataType;

public class InterfaceVisualisation extends Client {

	private String identifiantVisualisation;
	private List<Capteur> capteurs = new ArrayList<>();
	
	public InterfaceVisualisation(String identifiantVisualisation) {
		this.identifiantVisualisation = identifiantVisualisation;
	}
	
	@Override
	public boolean connexion(Adresse adresse) {
		// initialisation du serveur
		serveur = new ServeurThread(adresse.getIp(), adresse.getPort(), this);
		// construction du message
		serveur.sendTo("ConnexionVisu;" + identifiantVisualisation);
		
		// traitment de la réponse du serveur
//		String answer = serveur.waitFrom();
//		if (answer == null) {
//			System.out.println("Unable to recieve from server " + serveur);
//			return false;
//		} else if (answer.equals("ConnexionKO")) {
//			System.out.println("Server " + serveur + " return \"ConnexionKO\"");
//			return false;
//		} else if (answer.equals("ConnexionOK")) {
//			System.out.println("Now connected to server " + serveur);
//			while ((answer = serveur.recieveFrom()) != null) {
//				System.out.println("capteur : " + answer);
//				addCapteur(answer);
//			}
//			return true;
//		}
		return false;
	}

	@Override
	public boolean deconnexion() {
		// construction du message
		serveur.sendTo("DeconnexionVisu;");
		// traitment de la réponse du serveur
		String answer = serveur.waitFrom();
		if (answer == null) {
			System.out.println("Unable to recieve from server " + serveur);
			return false;
		} else if (answer.equals("DeconnexionKO")) {
			System.out.println("Server " + serveur + " return \"DeconnexionKO\"");
			return false;
		} else if (answer.equals("DeconnexionOK")) {
			System.out.println("Now disconnected");
			serveur.close();
			return true;
		}
		return false;
	}
	
	public boolean inscription(List<String> idCapteurs) {
		String msg = new String("InscriptionCapteur");
		for (String id : idCapteurs) {
			msg = msg + ";" + id;
		}
		serveur.sendTo(msg);
		
//		String[] answer = serveur.waitFrom().split(";");
//		int answerLength = answer.length;
//		if (answerLength == 0) {
//			System.out.println("Unable to recieve from server " + serveur);
//			return false;
//		} else if (answerLength == 1) {
//			if (answer[0].equals("DeconnexionKO")) {
//				System.out.println("Server " + serveur + " return \"DeconnexionKO\"");
//				return false;
//			} else if (answer[0].equals("DeconnexionOK")) {
//				System.out.println("Now disconnected");
//				serveur.close();
//				return true;
//			}
//		}
		return false;
	}
	
	public void analyseMessage(String message) {
		String[] type = message.split(";", 2);
		switch (type[0]) {
		case "InscriptionOK":
			
			break;

		default:
			break;
		}
	}
	
	private void addCapteur (String message) {
		String[] champ = message.split(";");
		int msgLenth = champ.length;
		if ((msgLenth != 7 && msgLenth != 5) || !champ[0].equals("CapteurPresent")) {
			System.out.println("Reception d'un message inconnu (qui sera ignoré): " + message);
		}
		PositionCapteur position;
		if (msgLenth == 7) {
			// Capteur Interieur
			position = new PositionCapteurInt(champ[3], champ[4], champ[5], champ[6]);
		} else {
			// Capteur Exterieur
			position = new PositionCapteurExt(Float.parseFloat(champ[3]), Float.parseFloat(champ[4]));
		}
		capteurs.add(new Capteur(position, champ[1], new CapteurDataType(champ[2])));
	}
	
	//TODO remove this main
	
	public static void main(String[] args) {
		InterfaceVisualisation interfaceVisualisation = new InterfaceVisualisation("2");
		Adresse adresse = new Adresse("127.0.0.1", 7888);
		interfaceVisualisation.connexion(adresse);
		System.out.println(interfaceVisualisation.capteurs);
		interfaceVisualisation.deconnexion();
	}
	
}
