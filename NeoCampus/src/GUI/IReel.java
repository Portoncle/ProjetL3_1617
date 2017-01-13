/**
 * Créer timer
 * Chaque rafraichissement : 
 *      Récupérer données des capteurs de la liste
 *      Mettre à jour les informations du tableau
 */
package GUI;

import client.Batiment;
import client.Etage;
import client.PositionCapteurExt;
import client.PositionCapteurInt;
import client.Salle;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Noémie
 */
public class IReel extends javax.swing.JFrame {

    List<Batiment> listeBatiment = new ArrayList<Batiment>();
    List<PositionCapteurExt> listeCaptExt = new ArrayList<PositionCapteurExt>();
    List<PositionCapteurExt> listeCapteursExtSelectionnes = new ArrayList<PositionCapteurExt>();
    List<PositionCapteurInt> listeCapteursIntSelectionnes = new ArrayList<PositionCapteurInt>();
    
    public IReel() {
        initComponents();
        constructionTree();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jButtonRetour = new javax.swing.JButton();
        jButtonConnexion = new javax.swing.JButton();
        jSplitPaneMain = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabelSelection = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeCapteurs = new javax.swing.JTree();
        jButtonMAJ = new javax.swing.JButton();
        jButtonSelect = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelAffichage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelMain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButtonRetour.setText("Retour");
        jButtonRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetourActionPerformed(evt);
            }
        });

        jButtonConnexion.setText("Connexion");
        jButtonConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnexionActionPerformed(evt);
            }
        });

        jSplitPaneMain.setDividerSize(3);
        jSplitPaneMain.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabelSelection.setText("Selection du/des capteurs :");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Capteurs");
        jTreeCapteurs.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTreeCapteurs.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeCapteursValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTreeCapteurs);

        jButtonMAJ.setText("Rafraichir la liste");
        jButtonMAJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMAJActionPerformed(evt);
            }
        });

        jButtonSelect.setText("Selectionner le noeud");
        jButtonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSelect)
                .addGap(18, 18, 18)
                .addComponent(jButtonMAJ)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelSelection)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMAJ)
                    .addComponent(jButtonSelect))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jSplitPaneMain.setLeftComponent(jPanel1);

        jLabelAffichage.setText("Affichages des données des capteurs");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabelAffichage, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabelAffichage)
                .addContainerGap(423, Short.MAX_VALUE))
        );

        jSplitPaneMain.setRightComponent(jPanel2);

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButtonRetour)
                .addGap(18, 18, 18)
                .addComponent(jButtonConnexion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jSplitPaneMain)
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jSplitPaneMain)
                .addGap(18, 18, 18)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRetour)
                    .addComponent(jButtonConnexion))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetourActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonRetourActionPerformed

    // Construction du tableau
    private void jTreeCapteursValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeCapteursValueChanged
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTreeCapteurs.getLastSelectedPathComponent();
        if(node.isLeaf()) {
            // Ajouter à la liste pour Nathan
            // Ajouter ligne tableau juste le nom
        }
        
    }//GEN-LAST:event_jTreeCapteursValueChanged

    private void jButtonConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnexionActionPerformed

        if(!listeCapteursExtSelectionnes.isEmpty()) {
            IConnexionVisu ICV = new IConnexionVisu();
            ICV.setLocationRelativeTo(null);
            ICV.setVisible(true);
        } else {
            System.err.println("Aucun capteur sélectionné");
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner au moins un capteur", "Erreur", JOptionPane.ERROR_MESSAGE);;
        }
    }//GEN-LAST:event_jButtonConnexionActionPerformed

    
    private void jButtonMAJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMAJActionPerformed
        DefaultMutableTreeNode racine = (DefaultMutableTreeNode) jTreeCapteurs.getModel().getRoot();
        //racine.removeAllChildren();
        //constructionTree();
    }//GEN-LAST:event_jButtonMAJActionPerformed

    
    private void recupCatpeurSelectionSalle(DefaultMutableTreeNode node, String batiment, String etage, String salle) {
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
    
    private void recupCapteurSelectionEtage(String etage, DefaultMutableTreeNode node, String batiment, String salle, String positionRelative) {
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
            else {
                recupCatpeurSelectionSalle(child,batiment,etage,salle);
            }
            cpt--;   
            if (cpt != 0) child = (DefaultMutableTreeNode) child.getNextSibling();
        } 
    }
    
    private void recupCapteurSelectionExt (DefaultMutableTreeNode node, Float latitude, Float longitude) {
        StringTokenizer Tok = new StringTokenizer(node.toString(),";");
        latitude = Float.parseFloat((String) Tok.nextElement());
        longitude = Float.parseFloat((String) Tok.nextElement());
        PositionCapteurExt position_a_ajouter_ext = new PositionCapteurExt(longitude,latitude);
        listeCapteursExtSelectionnes.add(position_a_ajouter_ext);
    }
    
    private void jButtonSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectActionPerformed
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTreeCapteurs.getLastSelectedPathComponent();
        String batiment="", etage="", salle="", positionRelative="";
        listeCapteursExtSelectionnes.clear();
        listeCapteursIntSelectionnes.clear();
        if (node.isRoot()) System.err.println("Erreur : selection de la racine");
        else if (node.getLevel() == 4) {//si c'est une salle
            salle = node.toString();
            etage = node.getParent().toString();
            batiment = node.getParent().getParent().toString();
            if (node.isLeaf()) {
                PositionCapteurInt position_a_ajouter = new PositionCapteurInt(batiment, etage, salle, positionRelative);
                listeCapteursIntSelectionnes.add(position_a_ajouter);
            }
            else recupCatpeurSelectionSalle(node,batiment,etage,salle);
        }
        else if (node.getLevel() == 5){//c'est une position rel
            positionRelative = node.toString();
            salle = node.getParent().toString();
            etage = node.getParent().getParent().toString();
            batiment = node.getParent().getParent().getParent().toString();
            PositionCapteurInt position_a_ajouter = new PositionCapteurInt(batiment, etage, salle, positionRelative);
            listeCapteursIntSelectionnes.add(position_a_ajouter);
        }
        else if (node.getLevel() == 3) {//c'est un etage
            recupCapteurSelectionEtage(etage,node,batiment,salle,positionRelative);
        }
        else if ((node.getLevel() == 2) && (node.getParent().toString().equals("interieur"))) {//c'est un batiment
            batiment = node.toString();
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getFirstChild();
            int cpt = node.getChildCount();
            while (cpt != 0) {
                recupCapteurSelectionEtage(etage,child,batiment,salle,positionRelative);
                cpt--;   
                if (cpt != 0) child = (DefaultMutableTreeNode) child.getNextSibling();
            }
        }
        else if (!(node.toString().equals("interieur"))) {
            Float longitude=null,latitude=null;
            if (node.isLeaf()) {//un capteur ext
                recupCapteurSelectionExt(node,latitude,longitude);
            }
            else {//si on a select "exterieur"
                int cpt = node.getChildCount();
                node = (DefaultMutableTreeNode) node.getFirstChild();
                while (cpt != 0) {
                    recupCapteurSelectionExt(node,latitude,longitude);
                    cpt--;   
                    if (cpt != 0) node = (DefaultMutableTreeNode) node.getNextSibling();
                }
            }
        }
        System.out.println(listeCapteursIntSelectionnes);
        System.out.println(listeCapteursExtSelectionnes);
        
        
    }//GEN-LAST:event_jButtonSelectActionPerformed
 
    
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
   
   
    private void ajouterListes(String nomB, String nomE, String nomS, String nomPos) {
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
    
    
    private void ajouterListExt(Float latitude, Float longitude) {
        ListIterator<PositionCapteurExt> iterExt = listeCaptExt.listIterator();
        PositionCapteurExt a_ajouter = new PositionCapteurExt(latitude,longitude);
        iterExt.add(a_ajouter);
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
    
    
    private void lectureFichier() {
        
        String fichier = "petiteListeCapteurs.txt",
               ligne,loc,batiment,etage,salle,posRel;
        float longitude,latitude;
        		
	try{
            InputStream ips=new FileInputStream(fichier); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            while ((ligne=br.readLine())!=null){
                //System.out.println(ligne);
                StringTokenizer Tok = new StringTokenizer(ligne,"/");
                while (Tok.hasMoreElements())  {
                    posRel = null;
                    loc = (String) Tok.nextElement();
                    if (loc.equals("interieur")) {
                        batiment = (String) Tok.nextElement();
                        etage = (String) Tok.nextElement();
                        salle = (String) Tok.nextElement();
                        if (Tok.hasMoreElements()) posRel = (String) Tok.nextElement();
                        ajouterListes(batiment,etage,salle,posRel);
                    }
                    else {
                        latitude = Float.parseFloat((String) Tok.nextElement());
                        longitude = Float.parseFloat((String) Tok.nextElement());
                        ajouterListExt(latitude,longitude);
                    }
                }
            }
            br.close(); 
	}		
	catch (Exception e){
            System.out.println(e.toString());
	}
    }
    
    private void constructionTree() {
        DefaultMutableTreeNode racine = (DefaultMutableTreeNode) jTreeCapteurs.getModel().getRoot();
	DefaultMutableTreeNode localisation = new DefaultMutableTreeNode("interieur");
        
        lectureFichier();
        
        racine.add(localisation);
        DefaultMutableTreeNode batiment,etage,salle,posRel;
        ListIterator<Batiment> iterBatiment = listeBatiment.listIterator();
        while (iterBatiment.hasNext()){
            Batiment bat = iterBatiment.next();
            batiment = new DefaultMutableTreeNode(bat.getNom());
            localisation.add(batiment);
            ListIterator<Etage> iterEtage = bat.getListeEtage().listIterator();
            while (iterEtage.hasNext()) {
                Etage et = iterEtage.next();
                etage = new DefaultMutableTreeNode(et.getNom());
                batiment.add(etage);
                ListIterator<Salle> iterSalle = et.getListeSalle().listIterator();
                while (iterSalle.hasNext()) {
                    Salle s = iterSalle.next();
                    salle = new DefaultMutableTreeNode(s.getNom());
                    etage.add(salle);
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
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConnexion;
    private javax.swing.JButton jButtonMAJ;
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JButton jButtonSelect;
    private javax.swing.JLabel jLabelAffichage;
    private javax.swing.JLabel jLabelSelection;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPaneMain;
    private javax.swing.JTree jTreeCapteurs;
    // End of variables declaration//GEN-END:variables
}
