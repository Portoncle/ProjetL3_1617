package client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import ressources.Adresse;
import ressources.Arbre;
import ressources.CapteurDataType;

public class InterfaceVisualisation extends Client {

	private String identifiantVisualisation;
	private NavigableSet<Capteur> capteurConnecte = new TreeSet<>();
	private Arbre arbre = null;
	private File recordFile;
	
	public InterfaceVisualisation(String identifiantVisualisation) {
		this.identifiantVisualisation = identifiantVisualisation;
	}
	
	public NavigableSet<Capteur> getCapteurConnecte() {
		return capteurConnecte;
	}
	
	@Override
	public boolean connexion(Adresse adresse) {
		// initialisation du serveur
		serveur = new Serveur(adresse.getIp(), adresse.getPort());
		// construction du message
		serveur.sendTo("ConnexionVisu;" + identifiantVisualisation);
		
		// traitment de la réponse du serveur
		String answer = serveur.waitFrom();
		if (answer == null) {
			System.out.println("Unable to recieve from server " + serveur);
		} else if (answer.equals("ConnexionKO")) {
			System.out.println("Server " + serveur + " return \"ConnexionKO\"");
		} else if (answer.equals("ConnexionOK")) {
			System.out.println("Now connected to server " + serveur);
			// Creation du thread à l'écoute du serveur
			new Thread(new SocketListeningThread(serveur, this));
			recordFile = new File("listeCapteursConnectes.txt");
			return true;
		}
		serveur.close();
		return false;
	}

	@Override
	public boolean deconnexion() {
		// construction du message
		serveur.sendTo("DeconnexionVisu;");
		return false;
	}
	
	public void inscription(String idCapteur) {
		List<String> liste = new ArrayList<String>();
		liste.add(idCapteur);
		inscription(liste);
	}
	
	public void inscription(List<String> idCapteurs) {
		assert (idCapteurs.size() != 0);
		String msg = new String("InscriptionCapteur");
		for (String id : idCapteurs) {
			msg = msg + ";" + id;
		}
		serveur.sendTo(msg);
	}
	
	public void desinscription(String idCapteur) {
		List<String> liste = new ArrayList<String>();
		liste.add(idCapteur);
		desinscription(liste);
	}
	
	public void desinscription(List<String> idCapteurs) {
		assert (idCapteurs.size() != 0);
		String msg = new String("DesinscriptionCapteur");
		for (String id : idCapteurs) {
			msg = msg + ";" + id;
		}
		serveur.sendTo(msg);
	}
	
	public boolean analyseMessage(String message) {
		String[] type = message.split(";", 2);
		switch (type[0]) {
		case "CapteurPresent":
			capteurPresent(type[1]);
			break;
		case "InscriptionCapteurOK":
			if (type.length != 1) {
				System.out.println("Message incohérent");
			} else {
				retourInscription(null, true);
			}
			break;
		case "InscriptionCapteurKO":
			retourInscription(type[1], false);
			break;
		case "ValeurCapteur":
			valeurCapteur(type[1]);
			break;
		case "DesinscriptionCapteurOK":
			if (type.length != 1) {
				System.out.println("Message incohérent");
			} else {
				retourDesinscription(null, true);
			}
			break;
		case "DesinscriptionCapteurKO":
			retourDesinscription(type[1], false);
			break;
		case "CapteurDeco":
			capteurDeco(type[1]);
			break;
		case "DeconnexionOK":
			retourDeconnexion(true);
			break;
		case "DeconnexionKO":
			retourDeconnexion(false);
			break;
		default:
			break;
		}
		return false;
	}

	private void retourDeconnexion(boolean reussie) {
		if (reussie) {
			System.out.println("Now disconnected");
			serveur.close();
		} else {
			System.out.println("Server " + serveur + " return \"DeconnexionKO\"");
		}
	}

	private void capteurPresent (String InfosCapteur) {
		String[] champ = InfosCapteur.split(";");
		int nbChamps = champ.length;
		if ((nbChamps != 6 && nbChamps != 4)) {
			System.out.println("Reception d'un message inconnu (qui sera ignoré): CapteurPresent;" + InfosCapteur);
		}
		PositionCapteur position;
		if (nbChamps == 6) {
			// Capteur Interieur
			position = new PositionCapteurInt(champ[2], champ[3], champ[4], champ[5]);
		} else {
			// Capteur Exterieur
			position = new PositionCapteurExt(Float.parseFloat(champ[2]), Float.parseFloat(champ[3]));
		}
		Capteur capteur = new Capteur(position, champ[0], new CapteurDataType(champ[1]));
		if (capteurConnecte.add(capteur)) {
			System.out.println("Capteur " + capteur.getIdentifiantCapteur() + " ajouté");
			//arbre.add(position);
//			try {
//				FileOutputStream out = new FileOutputStream(recordFile);
//				out.write(capteur.toString().getBytes());
//				out.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		} else {
			System.out.println("Capteur " + capteur.getIdentifiantCapteur() + " déjà présent");
		}
	}

	private void retourInscription(String liste, boolean reussie) {
		if (reussie) {
			System.out.println("Inscritpion aux capteurs réussie");
		} else {
			String[] Capteur = liste.split(";");
			System.out.println("Echec de l'inscritpion aux capteurs :");
			for (String c : Capteur) {
				System.out.println(" - " + c);
			}
		}
	}

	private void valeurCapteur(String infos) {
		// TODO completer
	}

	private void retourDesinscription(String liste, boolean reussie) {
		if (reussie) {
			System.out.println("Desinscritpion aux capteurs réussie");
		} else {
			String[] Capteur = liste.split(";");
			System.out.println("Echec de la desinscritpion aux capteurs :");
			for (String c : Capteur) {
				System.out.println(" - " + c);
			}
		}
	}
	
	private void capteurDeco(String identifiantCapteur) {
		if (capteurConnecte.remove(new Capteur(null, identifiantCapteur, null))) {
			System.out.println(identifiantCapteur + " supprimé");
		} else {
			System.out.println(identifiantCapteur + " n'existait pas");
		}
	}
	
	//TODO remove this main
	
	public static void main(String[] args) {
		InterfaceVisualisation interfaceVisualisation = new InterfaceVisualisation("3");
		Adresse adresse = new Adresse("127.0.0.1", 7888);
		interfaceVisualisation.connexion(adresse);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(interfaceVisualisation.capteurConnecte);
		List<String> liste = new ArrayList<>();
		for (Capteur c : interfaceVisualisation.capteurConnecte) {
			liste.add(c.getIdentifiantCapteur());
		}
		interfaceVisualisation.inscription(liste);
		interfaceVisualisation.desinscription("C2");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		interfaceVisualisation.deconnexion();
	}
}
