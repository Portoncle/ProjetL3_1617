/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ressources;

/**
 *
 * @author Noémie
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Localisation {
    
	public static void main(String[] args) {
	
		String fichier = "listeLocalisationInt.txt";
		
		String batiment;
		String etage;
		String salle;
		
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
                            System.out.println(ligne);
                            StringTokenizer Tok = new StringTokenizer(ligne,"-");
                            while (Tok.hasMoreElements())  {
                              batiment = (String) Tok.nextElement();
                              System.out.println(batiment);
                              etage = (String) Tok.nextElement();
                              System.out.println(etage);
                              salle = (String) Tok.nextElement();
                              System.out.println(salle);
                            }
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
}

