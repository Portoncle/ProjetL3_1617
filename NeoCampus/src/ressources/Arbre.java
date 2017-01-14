/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ressources;

import client.Batiment;
import client.Etage;
import client.InterfaceVisualisation;
import client.PositionCapteurExt;
import client.PositionCapteurInt;
import client.Salle;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Noémie
 */
public class Arbre {

	private List<Batiment> listeBatiment;
	private List<PositionCapteurExt> listeCaptExt;
	private javax.swing.JTree jTreeCapteurs;
	
    public Arbre(InterfaceVisualisation interfaceVisualisation) {
    	
    }

    
   //fonction principale pour construire des listes à partir des informations d'un fichier
    private void lectureFichier(List<Batiment> listeBatiment, List<PositionCapteurExt> listeCaptExt) {
        String fichier = "listeCapteurs.txt",
               ligne,loc,batiment,etage,salle,posRel;
        float longitude,latitude;
        		
	try{
            InputStream ips=new FileInputStream(fichier); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            while ((ligne=br.readLine())!=null){
                StringTokenizer Tok = new StringTokenizer(ligne,"/");
                while (Tok.hasMoreElements())  {
                    posRel = null;
                    loc = (String) Tok.nextElement();
                    if (loc.equals("interieur")) {
                        batiment = (String) Tok.nextElement();
                        etage = (String) Tok.nextElement();
                        salle = (String) Tok.nextElement();
                        if (Tok.hasMoreElements()) posRel = (String) Tok.nextElement();
                        ajouterListes(batiment,etage,salle,posRel,listeBatiment);
                    }
                    else {
                        latitude = Float.parseFloat((String) Tok.nextElement());
                        longitude = Float.parseFloat((String) Tok.nextElement());
                        ajouterListExt(latitude,longitude,listeCaptExt);
                    }
                }
            }
            br.close(); 
	}		
	catch (Exception e){
            System.out.println(e.toString());
	}
        Collections.sort(listeBatiment, new Comparator<Batiment>() {
            @Override
            public int compare(Batiment b1, Batiment b2) {
                return b1.getNom().compareTo(b2.getNom());
            }
        });
        Collections.sort(listeCaptExt, new Comparator<PositionCapteurExt>() {
            @Override
            public int compare(PositionCapteurExt p1, PositionCapteurExt p2) {
                if (p1.getLatitude() > p2.getLatitude()) return 1;
                else if (p1.getLatitude() < p2.getLatitude()) return -1;
                else if (p1.getLongitude() > p2.getLongitude()) return 1;
                else return -1;
            }
        });
    }
    
    
    
    //fonctions pour la lecture du fichier
    private void ajouterPosRel(List<String> listeP, String nomPos) {
        ListIterator<String> iter = listeP.listIterator();
        while (iter.hasNext()){
            if (iter.next().equals(nomPos)) return;
	}
        iter.add(nomPos);
    } 
    
    private void ajouterSalle(String nomS, List<Salle> listeS, String nomPos) {
        ListIterator<Salle> iter = listeS.listIterator();
        Salle salle = new Salle(nomS);
        Salle s_courante = new Salle();
        while (iter.hasNext()){
            s_courante = iter.next();
            if (s_courante.getNom().equals(nomS)) {
                if (nomPos != null) ajouterPosRel(s_courante.getListePosRel(),nomPos);
                return;
            }
	}
        iter.add(salle);
        s_courante = iter.previous();
        if (nomPos != null) ajouterPosRel(s_courante.getListePosRel(),nomPos);
    }
    
    private void ajouterEtage(String nomE, List<Etage> listeE, String nomS, String nomPos) {
        ListIterator<Etage> iter = listeE.listIterator();
        Etage etage = new Etage(nomE);
        Etage e_courant = new Etage();
        while (iter.hasNext()){
            e_courant = iter.next();
            if (e_courant.getNom().equals(nomE)) {
                ajouterSalle(nomS,e_courant.getListeSalle(),nomPos);
                return;
            }
	}
        iter.add(etage);
        e_courant = iter.previous();
        ajouterSalle(nomS,e_courant.getListeSalle(),nomPos);
    }
   
    private void ajouterListes(String nomB, String nomE, String nomS, String nomPos,List<Batiment> listeBatiment) {
        ListIterator<Batiment> iterBat = listeBatiment.listIterator();
        Batiment bat = new Batiment(nomB);
        Etage etage = new Etage(nomE);
        Batiment b_courant = new Batiment();
        while (iterBat.hasNext()){
            b_courant = iterBat.next();
            if (b_courant.getNom().equals(nomB)) {
                ajouterEtage(nomE,b_courant.getListeEtage(),nomS,nomPos);
                return;
            }
	}
	iterBat.add(bat);
        b_courant = iterBat.previous();
        ajouterEtage(nomE,b_courant.getListeEtage(),nomS,nomPos);
    }
    
    private void ajouterListExt(Float latitude, Float longitude, List<PositionCapteurExt> listeCaptExt) {
        ListIterator<PositionCapteurExt> iterExt = listeCaptExt.listIterator();
        PositionCapteurExt a_ajouter = new PositionCapteurExt(latitude,longitude);
        iterExt.add(a_ajouter);
    }
    
    
    
    //fonction principale pour construire l'arbre à partir des listes
    public void constructionTree(List<Batiment> listeBatiment, List<PositionCapteurExt> listeCaptExt, javax.swing.JTree jTreeCapteurs) {
        DefaultMutableTreeNode racine = (DefaultMutableTreeNode) jTreeCapteurs.getModel().getRoot();
        DefaultMutableTreeNode localisation = new DefaultMutableTreeNode("interieur");
        
        lectureFichier(listeBatiment,listeCaptExt);
        
        racine.add(localisation);
        DefaultMutableTreeNode batiment,etage,salle,posRel;
        ListIterator<Batiment> iterBatiment = listeBatiment.listIterator();
        while (iterBatiment.hasNext()){
            Batiment bat = iterBatiment.next();
            batiment = new DefaultMutableTreeNode(bat.getNom());
            localisation.add(batiment);
            Collections.sort(bat.getListeEtage(), new Comparator<Etage>() {
                @Override
                public int compare(Etage e1, Etage e2) {
                    return e1.getNom().compareTo(e2.getNom());
                }
            });
            ListIterator<Etage> iterEtage = bat.getListeEtage().listIterator();
            while (iterEtage.hasNext()) {
                Etage et = iterEtage.next();
                etage = new DefaultMutableTreeNode(et.getNom());
                batiment.add(etage);
                Collections.sort(et.getListeSalle(), new Comparator<Salle>() {
                    @Override
                    public int compare(Salle s1, Salle s2) {
                        return s1.getNom().compareTo(s2.getNom());
                    }
                });
                ListIterator<Salle> iterSalle = et.getListeSalle().listIterator();
                while (iterSalle.hasNext()) {
                    Salle s = iterSalle.next();
                    salle = new DefaultMutableTreeNode(s.getNom());
                    etage.add(salle);
                    Collections.sort(s.getListePosRel(), new Comparator<String>() {
                        @Override
                        public int compare(String s1, String s2) {
                            return s1.compareTo(s2);
                        }
                    });
                    ListIterator<String> iterPosRel = s.getListePosRel().listIterator();
                    while (iterPosRel.hasNext()) {
                        String positionRel = iterPosRel.next();
                        posRel = new DefaultMutableTreeNode(positionRel);
                        salle.add(posRel);
                    }
                }
            }
	}
        
        localisation = new DefaultMutableTreeNode("exterieur");
        racine.add(localisation);
        ListIterator<PositionCapteurExt> iterExt = listeCaptExt.listIterator();
        DefaultMutableTreeNode capteurExt;
        while (iterExt.hasNext()) {
            capteurExt = new DefaultMutableTreeNode(iterExt.next());
            localisation.add(capteurExt);
        }
    
    }
    
    
    
    //fonctions utilisees pour recuperer les capteurs selectionnes dans l'arbre et les stocker dans des listes
    public void recupCatpeurSelectionSalle(DefaultMutableTreeNode node, String batiment, String etage, String salle,List<PositionCapteurInt> listeCapteursIntSelectionnes) {
        DefaultMutableTreeNode pos = (DefaultMutableTreeNode) node.getFirstChild();
        String positionRelative;
        int cpt2 = node.getChildCount();
        while (cpt2 != 0) {
            positionRelative = pos.toString();
            PositionCapteurInt position_a_ajouter = new PositionCapteurInt(batiment, etage, salle, positionRelative);
            listeCapteursIntSelectionnes.add(position_a_ajouter);
            cpt2--;   
            if (cpt2 != 0) pos = (DefaultMutableTreeNode) pos.getNextSibling();
            positionRelative = "";
        }
    }
    
    public void recupCapteurSelectionEtage(String etage, DefaultMutableTreeNode node, String batiment, String salle, String positionRelative, List<PositionCapteurInt> listeCapteursIntSelectionnes) {
        etage = node.toString();
        batiment = node.getParent().toString();
        DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getFirstChild();
        int cpt = node.getChildCount();
        while (cpt != 0) {
            salle = child.toString();
            if (child.isLeaf()) {
                PositionCapteurInt position_a_ajouter = new PositionCapteurInt(batiment, etage, salle, positionRelative);
                listeCapteursIntSelectionnes.add(position_a_ajouter);
            }
            else recupCatpeurSelectionSalle(child,batiment,etage,salle,listeCapteursIntSelectionnes);
            cpt--;   
            if (cpt != 0) child = (DefaultMutableTreeNode) child.getNextSibling();
        } 
    }
    
    
    public void recupCapteurSelectionBatiment(DefaultMutableTreeNode node, String batiment,String etage, String salle, String positionRelative, List<PositionCapteurInt> listeCapteursIntSelectionnes) {
        batiment = node.toString();
        DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getFirstChild();
        int cpt = node.getChildCount();
        while (cpt != 0) {
            recupCapteurSelectionEtage(etage,child,batiment,salle,positionRelative,listeCapteursIntSelectionnes);
            cpt--;   
            if (cpt != 0) child = (DefaultMutableTreeNode) child.getNextSibling();
        }
    }
    
    public void recupCapteurSelectionExt(DefaultMutableTreeNode node, Float latitude, Float longitude,List<PositionCapteurExt> listeCapteursExtSelectionnes) {
        StringTokenizer Tok = new StringTokenizer(node.toString(),";");
        latitude = Float.parseFloat((String) Tok.nextElement());
        longitude = Float.parseFloat((String) Tok.nextElement());
        PositionCapteurExt position_a_ajouter_ext = new PositionCapteurExt(latitude,longitude);
        listeCapteursExtSelectionnes.add(position_a_ajouter_ext);
    }
}
