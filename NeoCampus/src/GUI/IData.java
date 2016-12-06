package GUI;

import client.InterfaceSimulation;
import client.PositionCapteurInt;
import javax.swing.JOptionPane;

import client.PositionCapteurExt;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.DefaultListModel;

/**
 * Interface recuperants les premieres informations
 * @author PALACIOS Nicolas
 */
public class IData extends javax.swing.JFrame {

    private String ID = null;
    private String type = null;
    private PositionCapteurExt capteurExt = null;
    private PositionCapteurInt capteurInt = null;
    private int interMin,interMax;
    
    
    private void constructListBat(DefaultListModel listModele, Iterator<PositionCapteurInt> it) {
        int j=0;
        boolean contain;
        PositionCapteurInt p_courante;
        
        while(it.hasNext()) {
            p_courante = it.next();
            contain = false;
            
            for(int i=0; i<j; i++) {
                if(p_courante.getBatiment().equals(listModele.getElementAt(i))) contain = true;
            }
            
            if(!contain) {
                listModele.addElement(p_courante.getBatiment());
                j++;
            }
        }
    }
    
    private void constructListEt(DefaultListModel listModele, Iterator<PositionCapteurInt> it) {
        int j=0;
        boolean contain;
        PositionCapteurInt p_courante;
        
        while(it.hasNext()) {
            p_courante = it.next();
            contain = false;
            
            for(int i=0; i<j; i++) {
                if(p_courante.getEtage().equals(listModele.getElementAt(i))) contain = true;
            }
            
            if(!contain) {
                listModele.addElement(p_courante.getEtage());
                j++;
            }
        }
    }
    
    private void constructListSalle(DefaultListModel listModele, Iterator<PositionCapteurInt> it) {
        int j=0;
        boolean contain;
        PositionCapteurInt p_courante;
        
        while(it.hasNext()) {
            p_courante = it.next();
            contain = false;
            
            for(int i=0; i<j; i++) {
                if(p_courante.getSalle().equals(listModele.getElementAt(i))) contain = true;
            }
            
            if(!contain) {
                listModele.addElement(p_courante.getSalle());
                j++;
            }
        }
    }
    
    private boolean checkOK() {
        // Identificateur non null
        if(jTextFieldID.getText().equals("")) {
            System.err.println("Erreur : Champ identificateur vide");
            JOptionPane.showMessageDialog(this, "Champ identificateur vide", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Type de données sélectionné
        if(jComboBoxType.getSelectedItem().equals("-- Veuillez sélectionner le type de données --")) {
            System.err.println("Erreur : Type de donnée non selectionné");
            JOptionPane.showMessageDialog(this, "Type de donnée non selectionné", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Aucune erreur
        return true;
    }
    
    
    public IData(/*SETCAPTEURS capteurs*/) {
        initComponents();
        jButtonInterOK.setEnabled(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogGPS = new javax.swing.JDialog();
        jPanelGPS = new javax.swing.JPanel();
        jLabelLat = new javax.swing.JLabel();
        jTextFieldLat = new javax.swing.JTextField();
        jLabelLong = new javax.swing.JLabel();
        jTextFieldLong = new javax.swing.JTextField();
        jPanelBlank2 = new javax.swing.JPanel();
        jButtonGPSOK = new javax.swing.JButton();
        jDialogInter = new javax.swing.JDialog();
        jPanelInterMain = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListBat = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListEtage = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListSalle = new javax.swing.JList<>();
        jLabelPosRel = new javax.swing.JLabel();
        jTextFieldPosRel = new javax.swing.JTextField();
        jButtonInterOK = new javax.swing.JButton();
        jPanelMain = new javax.swing.JPanel();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabelType = new javax.swing.JLabel();
        jComboBoxType = new javax.swing.JComboBox<>();
        jLabelLocalisation = new javax.swing.JLabel();
        jPanelButtonsLocalisation = new javax.swing.JPanel();
        jButtonInter = new javax.swing.JButton();
        jButtonExter = new javax.swing.JButton();
        jLabelInterval = new javax.swing.JLabel();
        jPanelSpinnersIntervals = new javax.swing.JPanel();
        jSpinnerMin = new javax.swing.JSpinner();
        jLabelUnit1 = new javax.swing.JLabel();
        jSpinnerMax = new javax.swing.JSpinner();
        jLabelUnit2 = new javax.swing.JLabel();
        jPanelBlank = new javax.swing.JPanel();
        jButtonNext = new javax.swing.JButton();

        jDialogGPS.setTitle("Coordonnées GPS");
        jDialogGPS.setAlwaysOnTop(true);
        jDialogGPS.setMinimumSize(new java.awt.Dimension(230, 150));

        jPanelGPS.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanelGPS.setLayout(new java.awt.GridLayout(3, 2));

        jLabelLat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLat.setText("Latitude");
        jPanelGPS.add(jLabelLat);
        jPanelGPS.add(jTextFieldLat);

        jLabelLong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLong.setText("Longitude");
        jPanelGPS.add(jLabelLong);
        jPanelGPS.add(jTextFieldLong);

        javax.swing.GroupLayout jPanelBlank2Layout = new javax.swing.GroupLayout(jPanelBlank2);
        jPanelBlank2.setLayout(jPanelBlank2Layout);
        jPanelBlank2Layout.setHorizontalGroup(
            jPanelBlank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );
        jPanelBlank2Layout.setVerticalGroup(
            jPanelBlank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanelGPS.add(jPanelBlank2);

        jButtonGPSOK.setText("OK");
        jButtonGPSOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGPSOKActionPerformed(evt);
            }
        });
        jPanelGPS.add(jButtonGPSOK);

        javax.swing.GroupLayout jDialogGPSLayout = new javax.swing.GroupLayout(jDialogGPS.getContentPane());
        jDialogGPS.getContentPane().setLayout(jDialogGPSLayout);
        jDialogGPSLayout.setHorizontalGroup(
            jDialogGPSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGPS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogGPSLayout.setVerticalGroup(
            jDialogGPSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGPS, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        jDialogInter.setTitle("Position Capteur Intérieur");
        jDialogInter.setMinimumSize(new java.awt.Dimension(500, 300));

        jPanelInterMain.setLayout(new java.awt.GridLayout(2, 3));

        jListBat.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListBat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListBatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListBat);

        jPanelInterMain.add(jScrollPane1);

        jListEtage.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListEtage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListEtageMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListEtage);

        jPanelInterMain.add(jScrollPane2);

        jListSalle.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListSalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListSalleMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListSalle);

        jPanelInterMain.add(jScrollPane3);

        jLabelPosRel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPosRel.setText("Position relative :");
        jPanelInterMain.add(jLabelPosRel);
        jPanelInterMain.add(jTextFieldPosRel);

        jButtonInterOK.setText("OK");
        jButtonInterOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInterOKActionPerformed(evt);
            }
        });
        jPanelInterMain.add(jButtonInterOK);

        javax.swing.GroupLayout jDialogInterLayout = new javax.swing.GroupLayout(jDialogInter.getContentPane());
        jDialogInter.getContentPane().setLayout(jDialogInterLayout);
        jDialogInterLayout.setHorizontalGroup(
            jDialogInterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelInterMain, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );
        jDialogInterLayout.setVerticalGroup(
            jDialogInterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelInterMain, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Connexion");
        setMinimumSize(new java.awt.Dimension(700, 260));

        jPanelMain.setLayout(new java.awt.GridLayout(5, 2));

        jLabelID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelID.setText("Identificateur");
        jPanelMain.add(jLabelID);
        jPanelMain.add(jTextFieldID);

        jLabelType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType.setText("Types de données");
        jPanelMain.add(jLabelType);

        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Veuillez sélectionner le type de données --", "Température", "Humidité", "Luminosité", "Volume sonore", "Consommation éclairage", "Eau froide", "Eau chaude", "Vitesse vent", "Pression atmosphérique" }));
        jPanelMain.add(jComboBoxType);

        jLabelLocalisation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLocalisation.setText("Localisation");
        jPanelMain.add(jLabelLocalisation);

        jPanelButtonsLocalisation.setLayout(new java.awt.GridLayout(2, 1));

        jButtonInter.setText("Capteur intérieur");
        jButtonInter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInterActionPerformed(evt);
            }
        });
        jPanelButtonsLocalisation.add(jButtonInter);

        jButtonExter.setText("Capteur extérieur");
        jButtonExter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExterActionPerformed(evt);
            }
        });
        jPanelButtonsLocalisation.add(jButtonExter);

        jPanelMain.add(jPanelButtonsLocalisation);

        jLabelInterval.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInterval.setText("Intervalle des valeurs possibles");
        jPanelMain.add(jLabelInterval);

        jPanelSpinnersIntervals.setLayout(new java.awt.GridLayout(1, 4));
        jPanelSpinnersIntervals.add(jSpinnerMin);

        jLabelUnit1.setText("jLabel5");
        jPanelSpinnersIntervals.add(jLabelUnit1);
        jPanelSpinnersIntervals.add(jSpinnerMax);

        jLabelUnit2.setText("jLabel6");
        jPanelSpinnersIntervals.add(jLabelUnit2);

        jPanelMain.add(jPanelSpinnersIntervals);

        javax.swing.GroupLayout jPanelBlankLayout = new javax.swing.GroupLayout(jPanelBlank);
        jPanelBlank.setLayout(jPanelBlankLayout);
        jPanelBlankLayout.setHorizontalGroup(
            jPanelBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );
        jPanelBlankLayout.setVerticalGroup(
            jPanelBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanelMain.add(jPanelBlank);

        jButtonNext.setText("Suivant");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });
        jPanelMain.add(jButtonNext);

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

    private void jButtonInterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInterActionPerformed
        // Construction jList
        InterfaceSimulation capteurs = new InterfaceSimulation();
        HashSet<PositionCapteurInt> setCapteurs = capteurs.getSetPositionCapteur();
        
        Iterator<PositionCapteurInt> itBat = setCapteurs.iterator();

        DefaultListModel listModeleBat = new DefaultListModel();
        constructListBat(listModeleBat, itBat);
        jListBat.setModel(listModeleBat);
        
        jDialogInter.setLocationRelativeTo(null);
        jDialogInter.setVisible(true);
    }//GEN-LAST:event_jButtonInterActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        if(checkOK()) {
            System.out.println("Check OK : Ouverture des interfaces");
            
            this.ID = jTextFieldID.getText();
            this.type = jComboBoxType.getSelectedItem().toString();
            
            interMin = (int) jSpinnerMin.getValue();
            interMax = (int) jSpinnerMax.getValue();
            boolean intervalle_ok = false;
            if (interMax <= interMin) {
                System.err.println("Erreur : Max <= Min ");
                JOptionPane.showMessageDialog(this, "Le maximun indiqué est inférieur ou égal au minimum", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            else intervalle_ok = true;
            
            //pourquoi pas ne pas faire IMain avec des int puisque que de toute façon l'utilisateur peut entrer que ça ?
            if (intervalle_ok) {
                IMain iMain = new IMain(this.ID, this.type, this.capteurInt, this.capteurExt, (float) this.interMin, (float) this.interMax);
                iMain.setVisible(true);
                iMain.setExtendedState(this.MAXIMIZED_BOTH);
            }
        }
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonExterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExterActionPerformed
        jDialogGPS.setLocationRelativeTo(null);
        jDialogGPS.setVisible(true);
    }//GEN-LAST:event_jButtonExterActionPerformed

    private void jButtonGPSOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGPSOKActionPerformed
        
        if(jTextFieldLat.getText().equals("")) {
            System.err.println("Erreur : Champ latitude vide ");
            JOptionPane.showMessageDialog(this, "Champ latitude vide", "Erreur", JOptionPane.ERROR_MESSAGE);   
        }
        
        if(jTextFieldLong.getText().equals("")) {
            System.err.println("Erreur : Champ longitude vide ");
            JOptionPane.showMessageDialog(this, "Champ longitude vide", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        
        float latitude = Float.parseFloat(jTextFieldLat.getText());
        float longitude = Float.parseFloat(jTextFieldLong.getText());
        boolean lat_correcte = false, long_correcte = false;
        
        if(latitude < -90 || latitude > 90) {
            System.err.println("Erreur : Latitude incorrecte");
            JOptionPane.showMessageDialog(this, "La latitude doit être un chiffre compris entre -90 et 90", "Erreur", JOptionPane.ERROR_MESSAGE);   
        }
        else lat_correcte = true;
        
        if(longitude < -180 || longitude > 180) {
            System.err.println("Erreur : Longitude incorrecte ");
            JOptionPane.showMessageDialog(this, "La longitude doit être un chiffre compris en -180 et 180", "Erreur", JOptionPane.ERROR_MESSAGE);   
        }
        else long_correcte = true;
        
        if (long_correcte && lat_correcte) {
            capteurExt = new PositionCapteurExt(latitude, longitude);
            jLabelLocalisation.setText("Localisation (" + capteurExt.toString() + ")");
            jDialogGPS.dispose();
        }
    }//GEN-LAST:event_jButtonGPSOKActionPerformed

    private void jListBatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListBatMouseClicked
        InterfaceSimulation capteurs = new InterfaceSimulation();
        HashSet<PositionCapteurInt> setCapteurs = capteurs.getSetPositionCapteur();
        Iterator<PositionCapteurInt> itEt = setCapteurs.iterator();
        DefaultListModel listModeleEt = new DefaultListModel();
        
        constructListEt(listModeleEt, itEt);
        jListEtage.setModel(listModeleEt);
    }//GEN-LAST:event_jListBatMouseClicked

    private void jListEtageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListEtageMouseClicked
        InterfaceSimulation capteurs = new InterfaceSimulation();
        HashSet<PositionCapteurInt> setCapteurs = capteurs.getSetPositionCapteur();
        Iterator<PositionCapteurInt> itSalles = setCapteurs.iterator();
        DefaultListModel listModeleSalle = new DefaultListModel();
        constructListSalle(listModeleSalle, itSalles);
        jListSalle.setModel(listModeleSalle);
    }//GEN-LAST:event_jListEtageMouseClicked

    private void jListSalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListSalleMouseClicked
        jButtonInterOK.setEnabled(true);
    }//GEN-LAST:event_jListSalleMouseClicked

    private void jButtonInterOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInterOKActionPerformed
        capteurInt = new PositionCapteurInt(jListBat.getSelectedValue(), jListEtage.getSelectedValue(), jListSalle.getSelectedValue());
        capteurInt.setPositionRelative(jTextFieldPosRel.getText());
        
        jLabelLocalisation.setText("Localisation  (" + capteurInt.getBatiment() + " " + capteurInt.getEtage() + " " + capteurInt.getSalle() + " " + capteurInt.getPositionRelative() + ")");
        
        jDialogInter.setVisible(false);
    }//GEN-LAST:event_jButtonInterOKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExter;
    private javax.swing.JButton jButtonGPSOK;
    private javax.swing.JButton jButtonInter;
    private javax.swing.JButton jButtonInterOK;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JComboBox<String> jComboBoxType;
    private javax.swing.JDialog jDialogGPS;
    private javax.swing.JDialog jDialogInter;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelInterval;
    private javax.swing.JLabel jLabelLat;
    private javax.swing.JLabel jLabelLocalisation;
    private javax.swing.JLabel jLabelLong;
    private javax.swing.JLabel jLabelPosRel;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JLabel jLabelUnit1;
    private javax.swing.JLabel jLabelUnit2;
    private javax.swing.JList<String> jListBat;
    private javax.swing.JList<String> jListEtage;
    private javax.swing.JList<String> jListSalle;
    private javax.swing.JPanel jPanelBlank;
    private javax.swing.JPanel jPanelBlank2;
    private javax.swing.JPanel jPanelButtonsLocalisation;
    private javax.swing.JPanel jPanelGPS;
    private javax.swing.JPanel jPanelInterMain;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelSpinnersIntervals;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinnerMax;
    private javax.swing.JSpinner jSpinnerMin;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldLat;
    private javax.swing.JTextField jTextFieldLong;
    private javax.swing.JTextField jTextFieldPosRel;
    // End of variables declaration//GEN-END:variables
}
