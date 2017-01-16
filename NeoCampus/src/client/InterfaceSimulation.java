package client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

import ressources.Adresse;
import ressources.CapteurDataType;
import ressources.EnumCapteurDataType;


public class InterfaceSimulation extends Client {

	private HashSet<PositionCapteurInt> setPositionCapteur;
	private Capteur capteurSimule;
	
	public InterfaceSimulation() {
		//init du hashset
		setPositionCapteur = new HashSet<PositionCapteurInt>();
		PositionCapteurInt p_courante = null;
		String batiment, etage, salle;		  
		try{
			InputStream ips=new FileInputStream("listeLocalisationInt.txt"); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				StringTokenizer Tok = new StringTokenizer(ligne,"-");
				while (Tok.hasMoreElements())  {
					batiment = (String) Tok.nextElement();
					etage = (String) Tok.nextElement();
					salle = (String) Tok.nextElement();
					p_courante = new PositionCapteurInt(batiment,etage,salle, null);
				}
				setPositionCapteur.add(p_courante);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public HashSet<PositionCapteurInt> getSetPositionCapteur() {
		return this.setPositionCapteur;
	}
	
	
	@Override
	public boolean connexion(Adresse adresse) {
		// initialisation du serveur
		serveur = new Serveur(adresse.getIp(), adresse.getPort());
		
		// construction du message
		serveur.sendTo("ConnexionCapteur;" + capteurSimule.toString());
		
		// traitment de la réponse du serveur
		String answer = serveur.waitFrom();
		if (answer == null) {
			System.out.println("Unable to recieve from server " + serveur);
			return false;
		} else if (answer.equals("ConnexionKO")) {
			System.out.println("Server " + serveur + " return \"ConnexionKO\"");
			return false;
		} else if (answer.equals("ConnexionOK")) {
			System.out.println("Now connected to server " + serveur);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean deconnexion() {
		// construction du message
		serveur.sendTo("DeconnexionCapteur;" + capteurSimule.getIdentifiantCapteur());
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
	
	public void sendValue () {
		serveur.sendTo("ValeurCapteur;" + capteurSimule.getValeur());
	}
	
	public boolean sendValue (float value) {
		if (! capteurSimule.isValueCorrect(value)) {
			return false;
		}
		serveur.sendTo("ValeurCapteur;" + value);
		return true;
	}

	public Capteur getCapteurSimule() {
		return capteurSimule;
	}
	public void setCapteurSimule(Capteur capteurSimule) {
		this.capteurSimule = capteurSimule;
		
	}
	
	//TODO remove this main
	/*
	public static void main(String[] args) {
		InterfaceSimulation interfaceSimulation = new InterfaceSimulation();
		PositionCapteur position = new PositionCapteurInt("U3", "2", "204", "millieu");
		CapteurDataType capteurDataType = new CapteurDataType(EnumCapteurDataType.EAU_CHAUDE);
		interfaceSimulation.capteurSimule = new Capteur(position, "C1", capteurDataType, 1.0f, 45f, 0.1f);
		Adresse adresse = new Adresse("127.0.0.1", 7888);
		interfaceSimulation.connexion(adresse);

		position = new PositionCapteurInt("U3", "1", "1003", "tarace");
		capteurDataType = new CapteurDataType(EnumCapteurDataType.EAU_FROIDE);
		interfaceSimulation.capteurSimule = new Capteur(position, "CMerde", capteurDataType, 1.0f, 45f, 0.1f);
		interfaceSimulation.connexion(adresse);
		

		InterfaceSimulation interfaceSimulation2 = new InterfaceSimulation();
		PositionCapteur position2 = new PositionCapteurExt(45.12f, 72.054f);
		CapteurDataType capteurDataType2 = new CapteurDataType(EnumCapteurDataType.LUMINOSITE);
		interfaceSimulation2.capteurSimule = new Capteur(position2, "C2", capteurDataType2, 12.0f, 24f, 1f);
		interfaceSimulation2.connexion(adresse);
	}*/
	
}
