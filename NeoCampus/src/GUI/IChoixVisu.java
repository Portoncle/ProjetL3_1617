package GUI;


public class IChoixVisu extends javax.swing.JFrame {

    public IChoixVisu() {
        initComponents();
        buttonGroupReelPeriode.add(jRadioButtonPeriode);
        buttonGroupReelPeriode.add(jRadioButtonReel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupReelPeriode = new javax.swing.ButtonGroup();
        jPanelMain = new javax.swing.JPanel();
        jLabelTexte1 = new javax.swing.JLabel();
        jLabelTexte2 = new javax.swing.JLabel();
        jRadioButtonReel = new javax.swing.JRadioButton();
        jRadioButtonPeriode = new javax.swing.JRadioButton();
        jButtonOK = new javax.swing.JButton();
        jButtonRetour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Selection visualisation");
        setMinimumSize(new java.awt.Dimension(408, 300));
        setPreferredSize(new java.awt.Dimension(408, 300));

        jLabelTexte1.setText("Vous avez choisi de lancer l'interface de visualisation.");

        jLabelTexte2.setText("Vous souhaitez visualiser les données :");

        jRadioButtonReel.setText("des capteurs connectés au réseau en temps réel");

        jRadioButtonPeriode.setText("d'un capteur déjà enregistré");

        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButtonRetour.setText("retour");
        jButtonRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jButtonRetour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonOK)
                        .addGap(60, 60, 60))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonPeriode)
                            .addComponent(jRadioButtonReel)
                            .addComponent(jLabelTexte2)
                            .addComponent(jLabelTexte1))
                        .addContainerGap(100, Short.MAX_VALUE))))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabelTexte1)
                .addGap(18, 18, 18)
                .addComponent(jLabelTexte2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonReel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonPeriode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOK)
                    .addComponent(jButtonRetour))
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
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        if(jRadioButtonPeriode.isSelected() || jRadioButtonReel.isSelected()) {
            if(jRadioButtonPeriode.isSelected()) {
                IPeriode iPeriode = new IPeriode(null);
                iPeriode.setLocationRelativeTo(null);
                iPeriode.setVisible(true);
            }
            else {
                IConnexionVisu ICV  = new IConnexionVisu();
                ICV.setLocationRelativeTo(null);
                ICV.setVisible(true);
            }
            this.dispose();
        }
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jButtonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetourActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonRetourActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupReelPeriode;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JLabel jLabelTexte1;
    private javax.swing.JLabel jLabelTexte2;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JRadioButton jRadioButtonPeriode;
    private javax.swing.JRadioButton jRadioButtonReel;
    // End of variables declaration//GEN-END:variables
}
