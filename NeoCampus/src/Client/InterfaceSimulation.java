/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 *
 * @author Noémie
 */
public class InterfaceSimulation {
    
    private String identifiantSimulation;
    //private NavigableSet<Capteur> setCapteur = new TreeSet<Capteur>();
    private HashSet<CapteurExterieur> setCapteurExterieur = new HashSet<CapteurExterieur>();
    private HashSet<CapteurInterieur> setCapteurInterieur = new HashSet<CapteurInterieur>(); 
    
    public HashSet<PositionCapteurInt> lectureFichierLocalisation() {
	String batiment, etage, salle;
        
        HashSet<PositionCapteurInt> setPositionCapteur = new HashSet<PositionCapteurInt>();
        PositionCapteurInt p_courante = new PositionCapteurInt();
        
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
	}		
	catch (Exception e){
            System.out.println(e.toString());
	}
        
        return setPositionCapteur;
    }
    
    
    public void parcoursSetPosition(HashSet<PositionCapteurInt> setPositionCapteur) {
        Iterator<PositionCapteurInt> it = setPositionCapteur.iterator();
        PositionCapteurInt p_courante = new PositionCapteurInt();
        while (it.hasNext()) {
            p_courante = it.next();
            System.out.println(p_courante.getBatiment() + "-" + p_courante.getEtage() + "-" + p_courante.getSalle());
        }
    }
    
    public static void main(String[] args) {
        InterfaceSimulation test = new InterfaceSimulation();
        HashSet<PositionCapteurInt> setCapteurIntTest = new HashSet<PositionCapteurInt>();
        setCapteurIntTest = test.lectureFichierLocalisation();
        test.parcoursSetPosition(setCapteurIntTest);
    }
	
}
