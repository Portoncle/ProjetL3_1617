/**
 * Créer timer
 * Chaque rafraichissement : 
 *      Récupérer données des capteurs de la liste
 *      Mettre à jour les informations du tableau
 */
package GUI;

import client.Batiment;
import client.PositionCapteurExt;
import client.PositionCapteurInt;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import ressources.Arbre;

/**
 *
 * @author Noémie
 */
public class IReel extends javax.swing.JFrame {

    List<Batiment> listeCaptInt = new ArrayList<Batiment>();
    List<PositionCapteurExt> listeCaptExt = new ArrayList<PositionCapteurExt>();
    List<PositionCapteurExt> listeCapteursExtSelectionnes = new ArrayList<PositionCapteurExt>();
    List<PositionCapteurInt> listeCapteursIntSelectionnes = new ArrayList<PositionCapteurInt>();
    Arbre arbre = new Arbre();
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jButtonRetour = new javax.swing.JButton();
        jButtonConnexion = new javax.swing.JButton();
        jSplitPaneMain = new javax.swing.JSplitPane();
        jPanelGauche = new javax.swing.JPanel();
        jLabelSelection = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeCapteurs = new javax.swing.JTree();
        jButtonMAJ = new javax.swing.JButton();
        jButtonSelect = new javax.swing.JButton();
        jPanelDroite = new javax.swing.JPanel();
        jLabelAffichage = new javax.swing.JLabel();
        jButtonQuitter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visualisation en temps réelle des capteurs");

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

        jPanelGauche.setPreferredSize(new java.awt.Dimension(200, 452));

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

        javax.swing.GroupLayout jPanelGaucheLayout = new javax.swing.GroupLayout(jPanelGauche);
        jPanelGauche.setLayout(jPanelGaucheLayout);
        jPanelGaucheLayout.setHorizontalGroup(
            jPanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGaucheLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelGaucheLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelGaucheLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButtonMAJ))
                            .addComponent(jButtonSelect))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGaucheLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelGaucheLayout.setVerticalGroup(
            jPanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGaucheLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelSelection)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSelect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonMAJ)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jSplitPaneMain.setLeftComponent(jPanelGauche);

        jLabelAffichage.setText("Affichages des données des capteurs :");

        javax.swing.GroupLayout jPanelDroiteLayout = new javax.swing.GroupLayout(jPanelDroite);
        jPanelDroite.setLayout(jPanelDroiteLayout);
        jPanelDroiteLayout.setHorizontalGroup(
            jPanelDroiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDroiteLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabelAffichage, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanelDroiteLayout.setVerticalGroup(
            jPanelDroiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDroiteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelAffichage)
                .addContainerGap(418, Short.MAX_VALUE))
        );

        jSplitPaneMain.setRightComponent(jPanelDroite);

        jButtonQuitter.setText("Quitter");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Visualisation des données");

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonQuitter))
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jLabel1))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSplitPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addComponent(jButtonRetour)
                                .addGap(39, 39, 39)
                                .addComponent(jButtonConnexion)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addComponent(jButtonQuitter)
                .addGap(3, 3, 3)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSplitPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRetour)
                    .addComponent(jButtonConnexion))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public IReel() {
        initComponents();
        arbre.constructionTree(listeCaptInt, listeCaptExt,jTreeCapteurs);
    }
    
    private void jButtonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetourActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonRetourActionPerformed

    // Construction du tableau
    private void jTreeCapteursValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeCapteursValueChanged
        /*DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTreeCapteurs.getLastSelectedPathComponent();
        if(node.isLeaf()) {
            // Ajouter à la liste pour Nathan
            // Ajouter ligne tableau juste le nom
        }*/
        
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
        /*DefaultMutableTreeNode racine = (DefaultMutableTreeNode) jTreeCapteurs.getModel().getRoot();
        jTreeCapteurs.clearSelection();
        racine.removeAllChildren();
        arbre.constructionTree(listeCaptInt, listeCaptExt, jTreeCapteurs);*/
        
    }//GEN-LAST:event_jButtonMAJActionPerformed

    
    private void jButtonSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectActionPerformed
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTreeCapteurs.getLastSelectedPathComponent();
        String batiment="", etage="", salle="", positionRelative="";
        listeCapteursExtSelectionnes.clear();
        listeCapteursIntSelectionnes.clear();
        if (node.isRoot()) JOptionPane.showMessageDialog(this, "Vous n'avez sélectionné aucun capteur.", "Erreur", JOptionPane.ERROR_MESSAGE);
        //si c'est une salle
        else if (node.getLevel() == 4) {
            salle = node.toString();
            etage = node.getParent().toString();
            batiment = node.getParent().getParent().toString();
            if (node.isLeaf()) {
                PositionCapteurInt position_a_ajouter = new PositionCapteurInt(batiment, etage, salle, positionRelative);
                listeCapteursIntSelectionnes.add(position_a_ajouter);
            }
            else arbre.recupCatpeurSelectionSalle(node,batiment,etage,salle,listeCapteursIntSelectionnes);
        }
        //si c'est une position rel
        else if (node.getLevel() == 5){
            positionRelative = node.toString();
            salle = node.getParent().toString();
            etage = node.getParent().getParent().toString();
            batiment = node.getParent().getParent().getParent().toString();
            PositionCapteurInt position_a_ajouter = new PositionCapteurInt(batiment, etage, salle, positionRelative);
            listeCapteursIntSelectionnes.add(position_a_ajouter);
        }
        //si c'est un etage
        else if (node.getLevel() == 3) {
            arbre.recupCapteurSelectionEtage(etage,node,batiment,salle,positionRelative,listeCapteursIntSelectionnes);
        }
        //si c'est un batiment
        else if ((node.getLevel() == 2) && (node.getParent().toString().equals("interieur"))) {
            arbre.recupCapteurSelectionBatiment(node,batiment,etage,salle,positionRelative,listeCapteursIntSelectionnes);
        }
        //si c'est un ou plusieurs capteurs exterieur
        else if (!(node.toString().equals("interieur"))) {
            Float longitude = null,latitude = null;
            if (node.isLeaf()) {//un capteur ext
                arbre.recupCapteurSelectionExt(node,latitude,longitude,listeCapteursExtSelectionnes);
            }
            else {//si on a select "exterieur"
                int cpt = node.getChildCount();
                node = (DefaultMutableTreeNode) node.getFirstChild();
                while (cpt != 0) {
                    arbre.recupCapteurSelectionExt(node,latitude,longitude,listeCapteursExtSelectionnes);
                    cpt--;   
                    if (cpt != 0) node = (DefaultMutableTreeNode) node.getNextSibling();
                }
            }
        }
        //si c'est tout les capteurs interieurs 
        else {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getFirstChild();
            int cpt = node.getChildCount();
            while (cpt != 0) {
                arbre.recupCapteurSelectionBatiment(child,batiment,etage,salle,positionRelative,listeCapteursIntSelectionnes);
                cpt--;   
                if (cpt != 0) child = (DefaultMutableTreeNode) child.getNextSibling();
            }
        }
        //System.out.println(listeCapteursIntSelectionnes);
        //System.out.println(listeCapteursExtSelectionnes);  
    }//GEN-LAST:event_jButtonSelectActionPerformed

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonQuitterActionPerformed
 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConnexion;
    private javax.swing.JButton jButtonMAJ;
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JButton jButtonSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAffichage;
    private javax.swing.JLabel jLabelSelection;
    private javax.swing.JPanel jPanelDroite;
    private javax.swing.JPanel jPanelGauche;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPaneMain;
    private javax.swing.JTree jTreeCapteurs;
    // End of variables declaration//GEN-END:variables
}
