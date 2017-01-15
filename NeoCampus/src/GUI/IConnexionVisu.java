package GUI;

import client.InterfaceVisualisation;
import javax.swing.JOptionPane;
import ressources.Adresse;


public class IConnexionVisu extends javax.swing.JFrame {

    public IConnexionVisu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jLabelConnexion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelIdentifiant = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabelIP = new javax.swing.JLabel();
        jTextFieldIP = new javax.swing.JTextField();
        jLabelPort = new javax.swing.JLabel();
        jSpinnerPort = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jButtonConnexion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Connexion au Serveur");

        jPanelMain.setLayout(new java.awt.GridLayout(5, 2, 0, 5));

        jLabelConnexion.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelConnexion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelConnexion.setText("Connexion");
        jLabelConnexion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanelMain.add(jLabelConnexion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanelMain.add(jPanel1);

        jLabelIdentifiant.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdentifiant.setText("Identifiant :");
        jPanelMain.add(jLabelIdentifiant);
        jPanelMain.add(jTextFieldID);

        jLabelIP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIP.setText("Adresse IP :");
        jPanelMain.add(jLabelIP);
        jPanelMain.add(jTextFieldIP);

        jLabelPort.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPort.setText("Port :");
        jPanelMain.add(jLabelPort);
        jPanelMain.add(jSpinnerPort);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanelMain.add(jPanel2);

        jButtonConnexion.setText("Se connecter");
        jButtonConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnexionActionPerformed(evt);
            }
        });
        jPanelMain.add(jButtonConnexion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
	private void jButtonConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnexionActionPerformed
    	InterfaceVisualisation interfaceVisualisation = new InterfaceVisualisation(jTextFieldID.getText());
    	boolean checkOK = true;
                
        if (jTextFieldID.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Le champ Identifiant est vide", "Erreur", JOptionPane.ERROR_MESSAGE);
            checkOK = false;
        }
        
        if (jTextFieldIP.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Le champ IP est vide", "Erreur", JOptionPane.ERROR_MESSAGE);
            checkOK = false;
        }
        
        int port = (int) jSpinnerPort.getValue();
        if ((port < 0) || (port > 65536)) {
            JOptionPane.showMessageDialog(this, "Le numéro de port est incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);
            checkOK = false;
	}
        
        if ((interfaceVisualisation.connexion(new Adresse("127.0.0.1", 7888))) && checkOK) {//jTextFieldIP.getText(), (int)jSpinnerPort.getValue()))) {
    		IReel iReel = new IReel(interfaceVisualisation);
	        iReel.setLocationRelativeTo(null);
	        iReel.setVisible(true);
    	}
    }//GEN-LAST:event_jButtonConnexionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConnexion;
    private javax.swing.JLabel jLabelConnexion;
    private javax.swing.JLabel jLabelIP;
    private javax.swing.JLabel jLabelIdentifiant;
    private javax.swing.JLabel jLabelPort;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JSpinner jSpinnerPort;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldIP;
    // End of variables declaration//GEN-END:variables
}
