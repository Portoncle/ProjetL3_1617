package client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.corba.se.impl.orbutil.concurrent.Mutex;

import ressources.Adresse;
import ressources.Arbre;
import ressources.CapteurDataType;

public class InterfaceVisualisation extends Client {

	private String identifiantVisualisation;
	private NavigableSet<Capteur> capteurConnecte = new TreeSet<>();
	private NavigableSet<Capteur> capteurInscrits = new TreeSet<>();
	private List<Capteur> enInscription = new ArrayList<>();
	private List<Capteur> enDesinscription = new ArrayList<>();
	private Mutex accesListe = new Mutex();
	private Arbre arbre;
	private File recordFile;
	private DefaultTableModel table;
	
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
			arbre = new Arbre(capteurConnecte);
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
	
	public void MAJInscription(List<Capteur> capteurList){
		List<Capteur> aDesinscrire = new ArrayList<>();
		aDesinscrire.addAll(capteurInscrits);
		aDesinscrire.removeAll(capteurList);
		desinscription(aDesinscrire);
		List<Capteur> aInscrire = new ArrayList<>();
		aInscrire.addAll(capteurList);
		aInscrire.removeAll(capteurInscrits);
		inscription(aInscrire);
	}
	
	private void inscription(List<Capteur> capteurList) {
		if (capteurList.size() != 0) {
			try {
				accesListe.acquire();
				enInscription.clear();
				String msg = new String("InscriptionCapteur");
				for (Capteur capteur : capteurList) {
					assert (capteurInscrits.contains(capteur));
						msg = msg + ";" + capteur.getIdentifiantCapteur();
						enInscription.add(capteur);
				}
				serveur.sendTo(msg);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void desinscription(List<Capteur> capteurList) {
		if (capteurList.size() != 0) {
			try {
				accesListe.acquire();
				enDesinscription.clear();
				String msg = new String("DesinscriptionCapteur");
				for (Capteur capteur : capteurList) {
					assert (capteurInscrits.contains(capteur));
					msg = msg + ";" + capteur.getIdentifiantCapteur();
					enDesinscription.add(capteur);
				}
				serveur.sendTo(msg);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean analyseMessage(String message) {
		String[] type = message.split(";", 2);
		switch (type[0]) {
		case "CapteurPresent":
			capteurPresent(type[1]);
			break;
		case "InscriptionCapteurOK":
			retourInscription(type, true);
			break;
		case "InscriptionCapteurKO":
			retourInscription(type, false);
			break;
		case "ValeurCapteur":
			valeurCapteur(type[1]);
			break;
		case "DesinscriptionCapteurOK":
			if (type.length != 1) {
				System.out.println("Message incohérent");
			} else {
				retourDesinscription(type, true);
			}
			break;
		case "DesinscriptionCapteurKO":
			retourDesinscription(type, false);
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
			arbre.add(capteur);
		} else {
			System.out.println("Capteur " + capteur.getIdentifiantCapteur() + " déjà présent");
		}
	}

	private void retourInscription(String[] liste, boolean reussie) {
		
		if (liste.length - 1 == 0 && reussie) {
			
			System.out.println("Inscritpion aux capteurs réussie");
			capteurInscrits.addAll(enInscription);
		} else if (liste.length - 1 == 1 && !reussie) {
			String[] capteurId = liste[1].split(";");
			if (capteurId.length == enInscription.size()) {
				
				System.out.println("Inscritpion aux capteurs échouée");
			} else if (capteurId.length < enInscription.size()) {
				
				System.out.println("Echec de l'inscritpion aux capteurs :");
				for (String c : capteurId) {
					System.out.println(" - " + c);
					enInscription.remove(new Capteur(null, c, null));
				}
				capteurInscrits.addAll(enInscription);
			} else {
				System.out.println("Message incohérent");
			}
		} else {
			System.out.println("Message incohérent");
		}
		for (Capteur c : enInscription) {
			addValue(c);
		}
		accesListe.release();
	}

	private void valeurCapteur(String infos) {
		String[] champ = infos.split(";");
		for (Capteur capteur : capteurConnecte) {
			if (capteur.getIdentifiantCapteur().equals(champ[0])) {
				capteur.setValeur(Float.parseFloat(champ[1]));
				editValue(capteur);
			}
		}
	}

	private void retourDesinscription(String[] liste, boolean reussie) {
		
		if (liste.length - 1 == 0 && reussie) {
			
			System.out.println("Desinscritpion aux capteurs réussie");
			capteurInscrits.removeAll(enDesinscription);
		} else if (liste.length - 1 == 1 && !reussie) {
			String[] capteurId = liste[1].split(";");
			if (capteurId.length == enInscription.size()) {
				
				System.out.println("Desinscritpion aux capteurs échouée");
			} else if (capteurId.length < enInscription.size()) {
				
				System.out.println("Echec de la desinscritpion aux capteurs :");
				for (String c : capteurId) {
					System.out.println(" - " + c);
					enDesinscription.remove(new Capteur(null, c, null));
				}
				capteurInscrits.removeAll(enDesinscription);
			} else {
				System.out.println("Message incohérent");
			}
		} else {
			System.out.println("Message incohérent");
		}
		for (Capteur c : enDesinscription) {
			deleteValue(c);
		}
		accesListe.release();
	}
	
	private void capteurDeco(String identifiantCapteur) {
		Capteur capteur = new Capteur(null, identifiantCapteur, null);
		if (capteurConnecte.remove(capteur)) {
			System.out.println(identifiantCapteur + " supprimé");
			if (capteurInscrits.remove(capteur)) {
				deleteValue(capteur);
			}
		} else {
			System.out.println(identifiantCapteur + " n'existait pas");
		}
	}
	
	public Arbre getArbre() {
		return arbre;
	}
	
    public void addValue(Capteur capteur) {//String ID, String type, String localisation, String value) {
        String[] values = new String[4];
        values[0] = capteur.getIdentifiantCapteur();
        values[1] = capteur.getTypeDuCapteur().toSring();
        values[2] = capteur.getPosition().toString();
        values[3] = "0";
        table.addRow(values);
    }
    
    public void editValue(Capteur capteur) {
        
        int i=0;
        int borne = table.getRowCount();
        String IDTab;
        boolean found = false;
        
        while(!found && i<borne) {
            IDTab = (String) table.getValueAt(i, 0);
            if(capteur.getIdentifiantCapteur().equals(IDTab)) found = true;
            else i++;
        }
        
        if(found) table.setValueAt(capteur.getValeur(), i, 3);
        else System.err.println("Suppression : ID non trouve");
    }
    
    public void deleteValue(Capteur capteur) {
        
        int i=0;
        int borne = table.getRowCount();
        String IDTab;
        boolean found = false;
        
        while(!found && i<borne) {
            IDTab = (String) table.getValueAt(i, 0);
            if(capteur.getIdentifiantCapteur().equals(IDTab)) found = true;
            else i++;
        }
        
        if(found) table.removeRow(i);
        else System.err.println("Suppression : ID non trouve");
    }

	public DefaultTableModel getTable() {
		return table;
	}

	public void setTable(DefaultTableModel table) {
		this.table = table;
	}
}
