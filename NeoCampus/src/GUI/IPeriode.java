package GUI;

import client.Capteur;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class IPeriode extends javax.swing.JFrame {

    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    private List<Capteur> listeCapteur = new ArrayList<Capteur>();
    private JFreeChart chart;
    
    
    public IPeriode() {
        initComponents();
        lectureFichHistNomCapteurs();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jLabelAffichage = new javax.swing.JLabel();
        jButtonRetour = new javax.swing.JButton();
        jLabelSelection = new javax.swing.JLabel();
        jComboBoxCapteurSelect = new javax.swing.JComboBox<>();
        jLabelNomCapteur = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDonnees = new javax.swing.JTextArea();
        jButtonGraphique = new javax.swing.JButton();
        jButtonQuitter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visualisation d'un capteur du fichier historique");

        jLabelAffichage.setText("Affichage des données du capteur : ");

        jButtonRetour.setText("retour");
        jButtonRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetourActionPerformed(evt);
            }
        });

        jLabelSelection.setText("Séléction du capteur :");

        jComboBoxCapteurSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Veuillez selectionner un capteur ---" }));
        jComboBoxCapteurSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCapteurSelectActionPerformed(evt);
            }
        });

        jTextAreaDonnees.setEditable(false);
        jTextAreaDonnees.setBackground(new java.awt.Color(240, 240, 240));
        jTextAreaDonnees.setColumns(20);
        jTextAreaDonnees.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDonnees);

        jButtonGraphique.setText("Graphique");
        jButtonGraphique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGraphiqueActionPerformed(evt);
            }
        });

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
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jLabelSelection)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxCapteurSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addComponent(jLabelNomCapteur))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAffichage))
                        .addGap(45, 77, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonQuitter)
                        .addGap(24, 24, 24))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButtonRetour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonGraphique)
                .addGap(43, 43, 43))
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonQuitter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSelection, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNomCapteur, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jComboBoxCapteurSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAffichage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGraphique)
                    .addComponent(jButtonRetour))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetourActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonRetourActionPerformed

    
    private void jComboBoxCapteurSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCapteurSelectActionPerformed
        String nomCapteur = (String)jComboBoxCapteurSelect.getSelectedItem();
        if (!(nomCapteur.equals("--- Veuillez selectionner un capteur ---"))) {
            jLabelNomCapteur.setText(nomCapteur);
            lectureFichHistDonneesCapteurs(nomCapteur);
        }
    }//GEN-LAST:event_jComboBoxCapteurSelectActionPerformed

    
    private void jButtonGraphiqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGraphiqueActionPerformed
        String nomCapteur = (String)jComboBoxCapteurSelect.getSelectedItem();
        if (nomCapteur.equals("--- Veuillez selectionner un capteur ---")) {
            JOptionPane.showMessageDialog(this, "Vous n'avez sélectionné aucun capteur.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else {
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.BLUE);
            ChartFrame frame = new ChartFrame("Graphique données",chart);
            frame.setSize(550,550);
            frame.setVisible(true);
        }
    }//GEN-LAST:event_jButtonGraphiqueActionPerformed

    
    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonQuitterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGraphique;
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JComboBox<String> jComboBoxCapteurSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAffichage;
    private javax.swing.JLabel jLabelNomCapteur;
    private javax.swing.JLabel jLabelSelection;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDonnees;
    // End of variables declaration//GEN-END:variables


    public void lectureFichHistNomCapteurs() {
	String fichier = "hist.conf";
	try{
            InputStream ips=new FileInputStream(fichier); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;
            while ((ligne=br.readLine())!=null){
                jComboBoxCapteurSelect.addItem(ligne);
                while(!(ligne.equals("$"))) ligne=br.readLine();
            }
            br.close(); 
	}		
	catch (Exception e){
            System.out.println(e.toString());
	}
    }
    
    public void lectureFichHistDonneesCapteurs(String nomCapteur) {
	String fichier = "hist.conf",date,val,typeDonnees="";
        
        dataset.clear();
	try{
            InputStream ips=new FileInputStream(fichier); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;
            jTextAreaDonnees.setText("");
            while ((ligne=br.readLine())!=null){
                while (!(ligne.equals(nomCapteur))) ligne=br.readLine();
                ligne=br.readLine();
                if (ligne.equals("e")) jTextAreaDonnees.append("Capteur exterieur.\n");
                else jTextAreaDonnees.append("Capteur intérieur.\n");
                ligne=br.readLine();
                jTextAreaDonnees.append("Localisation : " + ligne + "\n");
                ligne=br.readLine();
                typeDonnees = ligne;
                jTextAreaDonnees.append("Type de données mesurées : " + typeDonnees + "\n");
                ligne=br.readLine();
                while(!(ligne.equals("$"))) {
                    StringTokenizer Tok = new StringTokenizer(ligne,";");
                    date = (String) Tok.nextElement();
                    jTextAreaDonnees.append("Date : " + date + "\n");
                    while (Tok.hasMoreElements())  {
                       val = (String) Tok.nextElement();
                       jTextAreaDonnees.append(val + "\n");
                       int valeur = Integer.parseInt(val);
                       dataset.setValue(valeur,nomCapteur,date);
                    }
                    ligne=br.readLine();        
                }
                break;
            }
            br.close(); 
	}		
	catch (Exception e){
            System.out.println(e.toString());
	}
        chart = ChartFactory.createLineChart("Données du capteur "+nomCapteur, "Temps (en jour)", typeDonnees+" mesuré(e)", dataset, PlotOrientation.VERTICAL, true, true, true);
    }
    
  
}
