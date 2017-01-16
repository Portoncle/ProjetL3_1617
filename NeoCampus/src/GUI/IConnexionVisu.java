package GUI;

import client.InterfaceVisualisation;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

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
        jPanelVide1 = new javax.swing.JPanel();
        jLabelIdentifiant = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField("Interface de Visualisation");
        jLabelIP = new javax.swing.JLabel();
        jTextFieldIP = new javax.swing.JTextField("127.0.0.1");
        jLabelPort = new javax.swing.JLabel();
        jSpinnerPort = new javax.swing.JSpinner(new SpinnerNumberModel(7888, 0, 65536, 1));
        jPanelVide2 = new javax.swing.JPanel();
        jButtonConnexion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Connexion au Serveur");

        jPanelMain.setLayout(new java.awt.GridLayout(5, 2, 0, 5));

        jLabelConnexion.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelConnexion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelConnexion.setText("Connexion");
        jLabelConnexion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanelMain.add(jLabelConnexion);

        javax.swing.GroupLayout jPanelVide1Layout = new javax.swing.GroupLayout(jPanelVide1);
        jPanelVide1.setLayout(jPanelVide1Layout);
        jPanelVide1Layout.setHorizontalGroup(
            jPanelVide1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );
        jPanelVide1Layout.setVerticalGroup(
            jPanelVide1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanelMain.add(jPanelVide1);

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

        javax.swing.GroupLayout jPanelVide2Layout = new javax.swing.GroupLayout(jPanelVide2);
        jPanelVide2.setLayout(jPanelVide2Layout);
        jPanelVide2Layout.setHorizontalGroup(
            jPanelVide2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );
        jPanelVide2Layout.setVerticalGroup(
            jPanelVide2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanelMain.add(jPanelVide2);

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
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelVide1;
    private javax.swing.JPanel jPanelVide2;
    private javax.swing.JSpinner jSpinnerPort;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldIP;
    // End of variables declaration//GEN-END:variables
}
