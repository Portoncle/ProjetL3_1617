package GUI;

import java.util.TimerTask;
import java.util.Timer;

import javax.swing.JOptionPane;

import client.Capteur;
import client.InterfaceSimulation;
import ressources.Adresse;

public class IMain extends javax.swing.JFrame {

	//private float valeurChoisie;
	private final InterfaceSimulation interfaceSimulation;
	private Timer timer = new Timer();
	
	
	public IMain(InterfaceSimulation interfaceSimulation) {
		Capteur capteurSimule = interfaceSimulation.getCapteurSimule();
		
		this.interfaceSimulation = interfaceSimulation;
		
		initComponents();
                jButtonDisconnect.setEnabled(false);
		jLabeIDValue.setText(capteurSimule.getIdentifiantCapteur());
		jLabelTypeValue.setText(interfaceSimulation.getCapteurSimule().getTypeDuCapteur().toSring());
//		if (interfaceSimulation.getCapteurInt() == null) jLabelLocationValue.setText(String.valueOf(iS.getCapteurExt().getLatitude())+ " ; " + String.valueOf(iS.getCapteurExt().getLongitude()) );
//		else jLabelLocationValue.setText(iS.getCapteurInt().getBatiment() + " - " + iS.getCapteurInt().getEtage() + " - " + iS.getCapteurInt().getSalle() + " - " + iS.getCapteurInt().getPositionRelative());
		jLabelLocationValue.setText(capteurSimule.getPosition().toStringAffichable());
		jLabelIntervalValue.setText(capteurSimule.getMin() + " - " + capteurSimule.getMax());

		buttonGroupAlOrNot.add(jRadioButtonAl);
		buttonGroupAlOrNot.add(jRadioButtonNotAl);
	}
	
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupAlOrNot = new javax.swing.ButtonGroup();
        jDialogValeursManuelles = new javax.swing.JDialog();
        jPanelValManMain = new javax.swing.JPanel();
        jLabelNouvelleValeur = new javax.swing.JLabel();
        jSpinnerValeurEnvoi = new javax.swing.JSpinner();
        jButtonEnvoyer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButtonTerminer = new javax.swing.JButton();
        jPanelMain = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jLabeIDValue = new javax.swing.JLabel();
        jLabelType = new javax.swing.JLabel();
        jLabelTypeValue = new javax.swing.JLabel();
        jLabelLocation = new javax.swing.JLabel();
        jLabelLocationValue = new javax.swing.JLabel();
        jLabelInterval = new javax.swing.JLabel();
        jLabelIntervalValue = new javax.swing.JLabel();
        jLabelAlOrNot = new javax.swing.JLabel();
        jPanelAlOrNot = new javax.swing.JPanel();
        jRadioButtonAl = new javax.swing.JRadioButton();
        jRadioButtonNotAl = new javax.swing.JRadioButton();
        jLabelFrequ = new javax.swing.JLabel();
        jSpinnerFreqValue = new javax.swing.JSpinner();
        jLabelIP = new javax.swing.JLabel();
        jTextFieldIP = new javax.swing.JTextField();
        jLabelPort = new javax.swing.JLabel();
        jTextFieldPort = new javax.swing.JTextField();
        jButtonDisconnect = new javax.swing.JButton();
        jButtonConnect = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButtonPrec = new javax.swing.JButton();

        jDialogValeursManuelles.setTitle("Saisie valeur");
        jDialogValeursManuelles.setAlwaysOnTop(true);
        jDialogValeursManuelles.setAutoRequestFocus(false);
        jDialogValeursManuelles.setMinimumSize(new java.awt.Dimension(460, 200));

        jPanelValManMain.setLayout(new java.awt.GridLayout(2, 3, 20, 15));

        jLabelNouvelleValeur.setText("   Nouvelle valeur : ");
        jPanelValManMain.add(jLabelNouvelleValeur);
        jPanelValManMain.add(jSpinnerValeurEnvoi);

        jButtonEnvoyer.setText("Envoyer");
        jButtonEnvoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnvoyerActionPerformed(evt);
            }
        });
        jPanelValManMain.add(jButtonEnvoyer);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanelValManMain.add(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanelValManMain.add(jPanel1);

        jButtonTerminer.setText("Terminer");
        jButtonTerminer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTerminerActionPerformed(evt);
            }
        });
        jPanelValManMain.add(jButtonTerminer);

        javax.swing.GroupLayout jDialogValeursManuellesLayout = new javax.swing.GroupLayout(jDialogValeursManuelles.getContentPane());
        jDialogValeursManuelles.getContentPane().setLayout(jDialogValeursManuellesLayout);
        jDialogValeursManuellesLayout.setHorizontalGroup(
            jDialogValeursManuellesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogValeursManuellesLayout.createSequentialGroup()
                .addComponent(jPanelValManMain, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );
        jDialogValeursManuellesLayout.setVerticalGroup(
            jDialogValeursManuellesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogValeursManuellesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelValManMain, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NéoCampus Interface de simulation");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setResizable(false);

        jPanelMain.setLayout(new java.awt.GridLayout(11, 2, 5, 10));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("    Caractéristiques du ");
        jPanelMain.add(jLabel4);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("capteur : ");
        jPanelMain.add(jLabel3);

        jLabelID.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelID.setText("Identificateur : ");
        jPanelMain.add(jLabelID);

        jLabeIDValue.setText("jLabel3");
        jPanelMain.add(jLabeIDValue);

        jLabelType.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType.setText("Type : ");
        jPanelMain.add(jLabelType);

        jLabelTypeValue.setText("jLabel9");
        jPanelMain.add(jLabelTypeValue);

        jLabelLocation.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelLocation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLocation.setText("Localisation :");
        jPanelMain.add(jLabelLocation);

        jLabelLocationValue.setText("jLabel7");
        jPanelMain.add(jLabelLocationValue);

        jLabelInterval.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelInterval.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInterval.setText("Intervalle : ");
        jPanelMain.add(jLabelInterval);

        jLabelIntervalValue.setText("jLabel5");
        jPanelMain.add(jLabelIntervalValue);

        jLabelAlOrNot.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelAlOrNot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAlOrNot.setText("Valeurs :");
        jPanelMain.add(jLabelAlOrNot);

        jPanelAlOrNot.setLayout(new java.awt.GridLayout(2, 1));

        jRadioButtonAl.setText("Aléatoires");
        jPanelAlOrNot.add(jRadioButtonAl);

        jRadioButtonNotAl.setText("Sélectionnées");
        jPanelAlOrNot.add(jRadioButtonNotAl);

        jPanelMain.add(jPanelAlOrNot);

        jLabelFrequ.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelFrequ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrequ.setText("      Fréquence d'envoi (secondes) :  ");
        jLabelFrequ.setToolTipText("");
        jPanelMain.add(jLabelFrequ);
        jPanelMain.add(jSpinnerFreqValue);

        jLabelIP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelIP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIP.setText("IP du serveur :");
        jPanelMain.add(jLabelIP);
        jPanelMain.add(jTextFieldIP);

        jLabelPort.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelPort.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPort.setText("Port :");
        jPanelMain.add(jLabelPort);
        jPanelMain.add(jTextFieldPort);

        jButtonDisconnect.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jButtonDisconnect.setText("Deconnexion");
        jButtonDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisconnectActionPerformed(evt);
            }
        });
        jPanelMain.add(jButtonDisconnect);

        jButtonConnect.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jButtonConnect.setText("Connexion");
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });
        jPanelMain.add(jButtonConnect);

        jButtonPrec.setText("Retour en page d'acceuil");
        jButtonPrec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jButtonPrec)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonPrec)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelMain.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
	private boolean jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectActionPerformed
		if(jRadioButtonNotAl.isSelected()) {
			jDialogValeursManuelles.setVisible(true);
		}
		String ip;
		int port;
		if ((ip = jTextFieldIP.getText()).equals("")) {
			System.err.println("Erreur : Champ ip vide");
			JOptionPane.showMessageDialog(this, "Champ ip vide", "Erreur", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		try {
			port = Integer.parseInt(jTextFieldPort.getText());
		} catch (Exception e) {
			System.err.println("Erreur : Champ port vide");
			JOptionPane.showMessageDialog(this, "Champ port non valide", "Erreur", JOptionPane.ERROR_MESSAGE);
			return false;
		}
                
                if(port < 0 || port > 65536) {
			System.err.println("Erreur : Champ port non valide");
			JOptionPane.showMessageDialog(this, "Le numéro de port doit être compris entre 0 et 65536", "Erreur", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		
		try {
			if (interfaceSimulation.connexion(new Adresse(ip, port))) {
				if (jSpinnerValeurEnvoi.getValue() == null) {
				    timer.schedule (
				    	new TimerTask() {
					        public void run()
					        {
					            interfaceSimulation.sendValue();
					        }
					    }, 
				    	0, (int)jSpinnerFreqValue.getValue() * 1000);
					interfaceSimulation.sendValue();
				}
				jButtonConnect.setEnabled(false);
	            jButtonDisconnect.setEnabled(true);
				return true;
			}
		}  catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erreur de connexion", "Erreur", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return false;
	}//GEN-LAST:event_jButtonConnectActionPerformed

        
    private void jButtonDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisconnectActionPerformed
        // deconnexion
    	if (!interfaceSimulation.deconnexion())
			JOptionPane.showMessageDialog(this, "Le serveur n'a pas confirmé la déconnexion", "Erreur", JOptionPane.ERROR_MESSAGE);;
        timer.cancel();
		jButtonConnect.setEnabled(true);
        jButtonDisconnect.setEnabled(false);
    }//GEN-LAST:event_jButtonDisconnectActionPerformed

    
    private void jButtonEnvoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnvoyerActionPerformed
        int value = (int) jSpinnerValeurEnvoi.getValue();
    	interfaceSimulation.sendValue(value);
                JOptionPane.showMessageDialog(this, "Valeur envoyée : " + value, "Nouvelle valeur", JOptionPane.INFORMATION_MESSAGE);;
		System.out.println((int)jSpinnerValeurEnvoi.getValue());
    	System.out.println("ValeurCapteur;" + value);
    }//GEN-LAST:event_jButtonEnvoyerActionPerformed

    
    private void jButtonTerminerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTerminerActionPerformed
        jDialogValeursManuelles.dispose();
    }//GEN-LAST:event_jButtonTerminerActionPerformed

    
    private void jButtonPrecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrecActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_jButtonPrecActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupAlOrNot;
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JButton jButtonDisconnect;
    private javax.swing.JButton jButtonEnvoyer;
    private javax.swing.JButton jButtonPrec;
    private javax.swing.JButton jButtonTerminer;
    private javax.swing.JDialog jDialogValeursManuelles;
    private javax.swing.JLabel jLabeIDValue;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelAlOrNot;
    private javax.swing.JLabel jLabelFrequ;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelIP;
    private javax.swing.JLabel jLabelInterval;
    private javax.swing.JLabel jLabelIntervalValue;
    private javax.swing.JLabel jLabelLocation;
    private javax.swing.JLabel jLabelLocationValue;
    private javax.swing.JLabel jLabelNouvelleValeur;
    private javax.swing.JLabel jLabelPort;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JLabel jLabelTypeValue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelAlOrNot;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelValManMain;
    private javax.swing.JRadioButton jRadioButtonAl;
    private javax.swing.JRadioButton jRadioButtonNotAl;
    private javax.swing.JSpinner jSpinnerFreqValue;
    private javax.swing.JSpinner jSpinnerValeurEnvoi;
    private javax.swing.JTextField jTextFieldIP;
    private javax.swing.JTextField jTextFieldPort;
    // End of variables declaration//GEN-END:variables
}
