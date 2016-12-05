package GUI;

import Client.PositionCapteurInt;
import javax.swing.JOptionPane;
import ressources.PositionCapteurExt;

/**
 * Interface recuperants les premieres informations
 * @author PALACIOS Nicolas
 */
public class IData extends javax.swing.JFrame {

    private String ID = null;
    private String type = null;
    private PositionCapteurExt capteurExt = null;
    private PositionCapteurInt capteurInt = null;
    private Float interMin;
    private Float interMax;
    
    private boolean checkOK() {
        // Identificateur
        if(jTextFieldID.getText().equals("")) {
            System.err.println("Erreur : Champ identificateur vide");
            JOptionPane.showMessageDialog(this, "Champ identificateur vide", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Aucune erreur
        return true;
    }
    
    /**
     * Creates new form Connexion
     */
    public IData(/*SETCAPTEURS capteurs*/) {
        initComponents();
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
        jScrollPaneInterTree = new javax.swing.JScrollPane();
        jTreeInter = new javax.swing.JTree();
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

        jPanelInterMain.setLayout(new java.awt.GridLayout(1, 2));

        jScrollPaneInterTree.setViewportView(jTreeInter);

        jPanelInterMain.add(jScrollPaneInterTree);

        jButtonInterOK.setText("OK");
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

        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Température", "Humidité", "Luminosité", "Volume sonore", "Consommation éclairage", "Eau froide", "Eau chaude", "Vitesse vent", "Pression atmosphérique" }));
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
        // Construction tree
        
        
        jDialogInter.setLocationRelativeTo(null);
        jDialogInter.setVisible(true);
    }//GEN-LAST:event_jButtonInterActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        if(checkOK()) {
            System.out.println("Check OK : Ouverture des interfaces");
            
            this.ID = jTextFieldID.getText();
            this.type = jComboBoxType.getSelectedItem().toString();
            
            // PAR ICI NOEMIE
            //interMin = jSpinnerMin.floatValue();
            //interMax = (float) jSpinnerMax.getValue();
            
            IMain iMain = new IMain(this.ID, this.type, this.capteurInt, this.capteurExt, this.interMin, this.interMax);
            iMain.setVisible(true);
        }
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonExterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExterActionPerformed
        jDialogGPS.setLocationRelativeTo(null);
        jDialogGPS.setVisible(true);
    }//GEN-LAST:event_jButtonExterActionPerformed

    private void jButtonGPSOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGPSOKActionPerformed
        float latitude = Float.parseFloat(jTextFieldLat.getText());
        float longitude = Float.parseFloat(jTextFieldLong.getText());
        capteurExt = new PositionCapteurExt(latitude, longitude);
        jLabelLocalisation.setText(jLabelLocalisation.getText() + " (" + capteurExt.toString() + ")");
        jDialogGPS.dispose();
    }//GEN-LAST:event_jButtonGPSOKActionPerformed

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
    private javax.swing.JLabel jLabelType;
    private javax.swing.JLabel jLabelUnit1;
    private javax.swing.JLabel jLabelUnit2;
    private javax.swing.JPanel jPanelBlank;
    private javax.swing.JPanel jPanelBlank2;
    private javax.swing.JPanel jPanelButtonsLocalisation;
    private javax.swing.JPanel jPanelGPS;
    private javax.swing.JPanel jPanelInterMain;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelSpinnersIntervals;
    private javax.swing.JScrollPane jScrollPaneInterTree;
    private javax.swing.JSpinner jSpinnerMax;
    private javax.swing.JSpinner jSpinnerMin;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldLat;
    private javax.swing.JTextField jTextFieldLong;
    private javax.swing.JTree jTreeInter;
    // End of variables declaration//GEN-END:variables
}
