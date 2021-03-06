package ressources;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Adresse {
		
	private String ip;
	private int port;
	
	public Adresse(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	public String getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}
	
	
	//fonction qui convertit un String en tableau de int	
	public int[] convertAdresse() {
		int adresseTab[] = new int[4];
	int i = 0;
	StringTokenizer Tok = new StringTokenizer(ip,".");
	while (Tok.hasMoreElements())  {
			adresseTab[i] = Integer.parseInt((String) Tok.nextElement());
			i++;
	}
	return adresseTab;
	}
	

	//fonction qui renvoie true si l'adresse en parametre est déjà dans le fichier
	//false sinon
	public boolean estDansLeFichier(String nomfichier) {
	try{
			InputStream ips = new FileInputStream(nomfichier); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine())!= null){
		if (ligne.equals(ip)) return true;
			}
			br.close(); 
		}		
	catch (Exception e){
			return false;
	}
	return false;
	}
	
	//fonction pour écrire l'adresse IP dans un fichier
	//prend en entrée l'adresse à rajouter dans le fichier et le nom du fichier
	//renvoie rien
	public void ecrireFichier(String nomfichier) {
	try{
			if (estDansLeFichier(nomfichier)) return;
			FileWriter fichier = new FileWriter(nomfichier,true);
			fichier.write(ip + "\n");
			fichier.close();
	}		
	catch (Exception e){
			//si on n'a pas pu ouvrir le fichier on le crée
			try{
				File f = new File(nomfichier);
		f.createNewFile();
		FileWriter fw = new FileWriter(f);
		fw.write(ip + "\n");
		fw.close();
			} catch (Exception e2) {
		System.out.println("Impossible de creer le fichier");
			}
	}
	}
	
	
	//fonction pour lire les adresses d'un fichier
	//retourne une liste avec les adresses IP
	public List<String> lireFichier(String nomfichier) {
		String fichier = nomfichier;
		List<String> listeAdresse = new ArrayList<String>();
	try{
			InputStream ips = new FileInputStream(fichier); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine())!= null){
		listeAdresse.add(ligne);
			}
			br.close(); 
	}		
		catch (Exception e){
			System.out.println(e.toString());
	}
	return listeAdresse;
	}
	

}
