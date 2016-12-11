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
import java.util.StringTokenizer;

import ressources.Adresse;

/**
 *
 * @author Noémie
 */
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
				//System.out.println("ligne = " + ligne);
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

	public Capteur getCapteurSimule() {
		return capteurSimule;
	}
	public void setCapteurSimule(Capteur capteurSimule) {
		this.capteurSimule = capteurSimule;
		
	}
	
}
