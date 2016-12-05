package GUI;

import javax.swing.JOptionPane;

/**
 * Interface recuperants les premieres informations
 * @author PALACIOS Nicolas
 */
public class IData extends javax.swing.JFrame {

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Connexion");

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
            .addGap(0, 190, Short.MAX_VALUE)
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

    }//GEN-LAST:event_jButtonInterActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        if(checkOK()) {
            System.out.println("Check OK : Ouverture des interfaces");
        }
    }//GEN-LAST:event_jButtonNextActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExter;
    private javax.swing.JButton jButtonInter;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JComboBox<String> jComboBoxType;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelInterval;
    private javax.swing.JLabel jLabelLocalisation;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JLabel jLabelUnit1;
    private javax.swing.JLabel jLabelUnit2;
    private javax.swing.JPanel jPanelBlank;
    private javax.swing.JPanel jPanelButtonsLocalisation;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelSpinnersIntervals;
    private javax.swing.JSpinner jSpinnerMax;
    private javax.swing.JSpinner jSpinnerMin;
    private javax.swing.JTextField jTextFieldID;
    // End of variables declaration//GEN-END:variables
}
