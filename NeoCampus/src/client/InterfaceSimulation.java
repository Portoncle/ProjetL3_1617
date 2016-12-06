/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

import ressources.Adresse;

/**
 *
 * @author NoÃ©mie
 */
public class InterfaceSimulation extends Client {

//private NavigableSet<Capteur> setCapteur = new TreeSet<Capteur>();
//private HashSet<CapteurExterieur> setCapteurExterieur = new HashSet<CapteurExterieur>();
//private HashSet<CapteurInterieur> setCapteurInterieur = new HashSet<CapteurInterieur>();
	private HashSet<PositionCapteurInt> setPositionCapteur;
	private Capteur capteurSimule;
	
	
	public InterfaceSimulation() {
		String batiment, etage, salle;
			
		setPositionCapteur = new HashSet<PositionCapteurInt>();
		PositionCapteurInt p_courante = null;
			
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream("listeLocalisationInt.txt"); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				//System.out.println("ligne = " + ligne);
				StringTokenizer Tok = new StringTokenizer(ligne,"-");
				while (Tok.hasMoreElements())  {
					batiment = (String) Tok.nextElement();
					etage = (String) Tok.nextElement();
					salle = (String) Tok.nextElement();
					p_courante = new PositionCapteurInt(batiment,etage,salle);
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
	
	public void parcoursSetPosition() {
		Iterator<PositionCapteurInt> it = setPositionCapteur.iterator();
		PositionCapteurInt p_courante;
		while (it.hasNext()) {
			p_courante = it.next();
			System.out.println(p_courante.getBatiment() + "-" + p_courante.getEtage() + "-" + p_courante.getSalle());
		}
	}
	
	@Override
	public boolean connexion(Adresse adresse) {
		// initialisation du serveur
		serveur = new Serveur(adresse.getIp(), adresse.getPort());
		
		// construction du message
		serveur.sendTo("ConnexionCapteur;" + capteurSimule.toString());
		
		// traitment de la réponse du serveur
		String answer = serveur.recieveFrom();
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
		String answer = serveur.recieveFrom();
		if (answer == null) {
			System.out.println("Unable to recieve from server " + serveur);
			return false;
		} else if (answer.equals("DeconnexionKO")) {
			System.out.println("Server " + serveur + " return \"DeconnexionKO\"");
			return false;
		} else if (answer.equals("DeonnexionOK")) {
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
		
	//public static void main(String[] args) {
	//InterfaceSimulation test = new InterfaceSimulation("1");
	//HashSet<PositionCapteurInt> setCapteurIntTest = new HashSet<PositionCapteurInt>();
	//setCapteurIntTest = test.lectureFichierLocalisation();
	//test.parcoursSetPosition(setCapteurIntTest);
	//}
	
}
