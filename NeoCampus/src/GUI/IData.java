package GUI;

import java.util.HashSet;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import client.Capteur;
import client.InterfaceSimulation;
import client.PositionCapteur;
import client.PositionCapteurExt;
import client.PositionCapteurInt;
import ressources.CapteurDataType;

/**
 * Interface recuperants les premieres informations : identifiant, type de données mesurées, localisation et intervalle des valeurs possibles
 * @author PALACIOS Nicolas
 */
public class IData extends javax.swing.JFrame {
	
	InterfaceSimulation interfaceSimulation = new InterfaceSimulation();
	PositionCapteur position = null;
	
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
			
			if(p_courante.getBatiment().equals(jListBat.getSelectedValue())) {
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
	}
	
	private void constructListSalle(DefaultListModel listModele, Iterator<PositionCapteurInt> it) {
		int j=0;
		boolean contain;
		PositionCapteurInt p_courante;
		
		while(it.hasNext()) {
			p_courante = it.next();
			
			if(p_courante.getBatiment().equals(jListBat.getSelectedValue()) && p_courante.getEtage().equals(jListEtage.getSelectedValue())){
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
	}
	
	private boolean checkOK() {
		int max = (int) jSpinnerMax.getValue(), min = (int) jSpinnerMin.getValue();
		String identifiant = jTextFieldID.getText();
		CapteurDataType type = new CapteurDataType(jComboBoxType.getSelectedItem().toString());
		float precision = 0.0f;
		
		// Identificateur non null
		if(identifiant.equals("")) {
			System.err.println("Erreur : Champ identificateur vide");
			JOptionPane.showMessageDialog(this, "Champ identificateur vide", "Erreur", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		//localisation renseignée
		if (position == null) {
			System.err.println("Erreur : localisation vide");
			JOptionPane.showMessageDialog(this, "Aucune localisation n'a été renseignée", "Erreur", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		//intervalle correct
		if (max <= min) {
			System.err.println("Erreur : Max <= Min ");
			JOptionPane.showMessageDialog(this, "Le maximun indiqué est inférieur ou égal au minimum", "Erreur", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		switch (type.getType()) {
		case NULL:
			System.err.println("Erreur : Type de donnée non selectionné");
			JOptionPane.showMessageDialog(this, "Type de donnée non selectionné", "Erreur", JOptionPane.ERROR_MESSAGE);
			return false;
		case PRESSION_ATM:
			if (max > 1100 || min < 1000) {
				System.err.println("Erreur : pression atmosphérique");
				JOptionPane.showMessageDialog(this, "La pression atmosphérique doit être entre 1000 et 1100 km/h", "Erreur", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else precision = 0.1f;
			break;
		case TEMPERATURE:
			if (max > 50 || min < -10) {
				System.err.println("Erreur : température ");
				JOptionPane.showMessageDialog(this, "La température doit être entre -10 et 50 degré", "Erreur", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else precision = 0.1f;
			break;
		case HUMIDITE:
			if(max > 100 || min < 0) {
				System.err.println("Erreur : humidité ");
				JOptionPane.showMessageDialog(this, "Le pourcentage d'humidité doit être entre 0 et 100", "Erreur", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else precision = 1f;
			break;	 
		case LUMINOSITE:
			if (max > 1000 || min < 0) {
				System.err.println("Erreur : Luminosité ");
				JOptionPane.showMessageDialog(this, "La luminosité doit être entre 0 et 1000 lum", "Erreur", JOptionPane.ERROR_MESSAGE);
				return false;
			} 
			else precision = 0.1f;
			break;
		case VOLUME:
			if (max > 120 || min < 0) {
				System.err.println("Erreur : volume sonore");
				JOptionPane.showMessageDialog(this, "Le volume sonore doit être entre 0 et 120 bB", "Erreur", JOptionPane.ERROR_MESSAGE);
				return false;
			} 
			else precision = 0.1f;
			break;
		case ECLAIRAGE:
			if (max > 3000 || min < 0) {
				System.err.println("Erreur : volume sonore");
				JOptionPane.showMessageDialog(this, "La consommation éclairage doit être entre 0 et 3000 W", "Erreur", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else precision = 1f; 
			break; 
		case EAU_FROIDE:
			if (max > 100 || min < 0)  {
				System.err.println("Erreur : eau froide");
				JOptionPane.showMessageDialog(this, "L'eau froide doit être entre 0 et 100 l", "Erreur", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else precision = 0.1f; 
			break;
		case EAU_CHAUDE:
			if (max > 1000 || min < 0) {
				System.err.println("Erreur : eau chaude");
				JOptionPane.showMessageDialog(this, "L'eau chaude doit être entre 0 et 1000 l", "Erreur", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else precision = 0.1f;
			break;
		case VITESSE_VENT:
			if (max > 50 || min < 0) {
				System.err.println("Erreur : vitesse vent");
				JOptionPane.showMessageDialog(this, "La vitesse du vent doit être entre 0 et 50 km/h", "Erreur", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else precision = 0.1f;
			break;
		}
		
		Capteur capteurSimule = new Capteur(position, identifiant, type, min, max, precision);
		interfaceSimulation.setCapteurSimule(capteurSimule);
		
		// Aucune erreur
		return true;
	}
	
	
	public IData(/*SETCAPTEURS capteurs*/) {
		initComponents();
		jButtonInterSuivant.setEnabled(false);
	}

	
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogGPS = new javax.swing.JDialog();
        jPanelGPS = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelLat = new javax.swing.JLabel();
        jTextFieldLat = new javax.swing.JTextField();
        jLabelLong = new javax.swing.JLabel();
        jTextFieldLong = new javax.swing.JTextField();
        jPanelBlank2 = new javax.swing.JPanel();
        jButtonGPSOK = new javax.swing.JButton();
        jDialogInter = new javax.swing.JDialog();
        jPanelInterMain = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListBat = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListEtage = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListSalle = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonInterSuivant = new javax.swing.JButton();
        jDialogPosRel = new javax.swing.JDialog();
        jPanelPosRelMain = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPosRel2 = new javax.swing.JTextField();
        jButtonInterOK = new javax.swing.JButton();
        jPanelMain = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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
        jDialogGPS.setMinimumSize(new java.awt.Dimension(420, 300));

        jPanelGPS.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanelGPS.setLayout(new java.awt.GridLayout(4, 2, 0, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Localisation du ");
        jPanelGPS.add(jLabel11);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("capteur extérieur");
        jPanelGPS.add(jLabel13);

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
            .addGap(0, 177, Short.MAX_VALUE)
        );
        jPanelBlank2Layout.setVerticalGroup(
            jPanelBlank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
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
            .addGroup(jDialogGPSLayout.createSequentialGroup()
                .addComponent(jPanelGPS, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );
        jDialogGPSLayout.setVerticalGroup(
            jDialogGPSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogGPSLayout.createSequentialGroup()
                .addComponent(jPanelGPS, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialogInter.setTitle("Position Capteur Intérieur");
        jDialogInter.setFocusable(false);
        jDialogInter.setFocusableWindowState(false);
        jDialogInter.setMinimumSize(new java.awt.Dimension(780, 500));

        jPanelInterMain.setLayout(new java.awt.GridLayout(4, 3, 20, 20));
        jPanelInterMain.add(jLabel3);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Localisation du capteur intérieur");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        jPanelInterMain.add(jPanel3);
        jPanelInterMain.add(jLabel4);

        jLabel10.setText("Choix du batiment : ");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanelInterMain.add(jLabel10);

        jLabel1.setText("Choix de l'étage :");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanelInterMain.add(jLabel1);

        jLabel7.setText("Choix de la salle :");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanelInterMain.add(jLabel7);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        jPanelInterMain.add(jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        jPanelInterMain.add(jPanel2);

        jButtonInterSuivant.setText("Suivant");
        jButtonInterSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInterSuivantActionPerformed(evt);
            }
        });
        jPanelInterMain.add(jButtonInterSuivant);

        javax.swing.GroupLayout jDialogInterLayout = new javax.swing.GroupLayout(jDialogInter.getContentPane());
        jDialogInter.getContentPane().setLayout(jDialogInterLayout);
        jDialogInterLayout.setHorizontalGroup(
            jDialogInterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogInterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelInterMain, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDialogInterLayout.setVerticalGroup(
            jDialogInterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogInterLayout.createSequentialGroup()
                .addComponent(jPanelInterMain, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialogPosRel.setTitle("Saisie position relative");
        jDialogPosRel.setMinimumSize(new java.awt.Dimension(650, 150));
        jDialogPosRel.setSize(new java.awt.Dimension(517, 100));

        jPanelPosRelMain.setLayout(new java.awt.GridLayout(1, 3, 20, 0));

        jLabel2.setText("Position relative (Facultatif) :");
        jPanelPosRelMain.add(jLabel2);
        jPanelPosRelMain.add(jTextFieldPosRel2);

        jButtonInterOK.setText("OK");
        jButtonInterOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInterOKActionPerformed(evt);
            }
        });
        jPanelPosRelMain.add(jButtonInterOK);

        javax.swing.GroupLayout jDialogPosRelLayout = new javax.swing.GroupLayout(jDialogPosRel.getContentPane());
        jDialogPosRel.getContentPane().setLayout(jDialogPosRelLayout);
        jDialogPosRelLayout.setHorizontalGroup(
            jDialogPosRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogPosRelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPosRelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogPosRelLayout.setVerticalGroup(
            jDialogPosRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogPosRelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanelPosRelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NeoCampus Saisie des données");
        setMinimumSize(new java.awt.Dimension(700, 260));
        setResizable(false);

        jPanelMain.setLayout(new java.awt.GridLayout(7, 2, 20, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Création d'un capteur :");
        jPanelMain.add(jLabel5);
        jPanelMain.add(jLabel6);

        jLabelID.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelID.setText("Identificateur du capteur");
        jPanelMain.add(jLabelID);
        jPanelMain.add(jTextFieldID);

        jLabelType.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType.setText("Types de données mesurées");
        jPanelMain.add(jLabelType);

        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Veuillez sélectionner le type de données  ----", "Température", "Humidité", "Luminosité", "Volume sonore", "Consommation éclairage", "Eau froide", "Eau chaude", "Vitesse vent", "Pression atmosphérique" }));
        jComboBoxType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTypeActionPerformed(evt);
            }
        });
        jPanelMain.add(jComboBoxType);

        jLabelLocalisation.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelLocalisation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLocalisation.setText("Localisation du capteur");
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

        jLabelInterval.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelInterval.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInterval.setText("Intervalle des valeurs possibles");
        jPanelMain.add(jLabelInterval);

        jPanelSpinnersIntervals.setLayout(new java.awt.GridLayout(1, 4));

        jSpinnerMin.setModel(new javax.swing.SpinnerNumberModel(0, -10, 3000, 1));
        jPanelSpinnersIntervals.add(jSpinnerMin);

        jLabelUnit1.setText("   min");
        jPanelSpinnersIntervals.add(jLabelUnit1);

        jSpinnerMax.setModel(new javax.swing.SpinnerNumberModel(0, -10, 3000, 1));
        jPanelSpinnersIntervals.add(jSpinnerMax);

        jLabelUnit2.setText("   max");
        jPanelSpinnersIntervals.add(jLabelUnit2);

        jPanelMain.add(jPanelSpinnersIntervals);

        javax.swing.GroupLayout jPanelBlankLayout = new javax.swing.GroupLayout(jPanelBlank);
        jPanelBlank.setLayout(jPanelBlankLayout);
        jPanelBlankLayout.setHorizontalGroup(
            jPanelBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelBlankLayout.setVerticalGroup(
            jPanelBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelMain.add(jPanelBlank);

        jButtonNext.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jButtonNext.setText("Etape suivante");
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void jButtonInterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInterActionPerformed
		// Construction jList;
		
		Iterator<PositionCapteurInt> itBat = interfaceSimulation.getSetPositionCapteur().iterator();

		DefaultListModel listModeleBat = new DefaultListModel();
		constructListBat(listModeleBat, itBat);
		jListBat.setModel(listModeleBat);
		
		jDialogInter.setLocationRelativeTo(null);
		jDialogInter.setVisible(true);
	}//GEN-LAST:event_jButtonInterActionPerformed

	private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
		if(checkOK()) {
			System.out.println("Check OK : Ouverture des interfaces");
			
			IMain iMain = new IMain(this.interfaceSimulation);
			iMain.setVisible(true);
			iMain.setExtendedState(this.MAXIMIZED_BOTH);
			this.dispose();
		}   
		
	}//GEN-LAST:event_jButtonNextActionPerformed

	private void jButtonExterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExterActionPerformed
		jDialogGPS.setLocationRelativeTo(null);
		jDialogGPS.setVisible(true);
	}//GEN-LAST:event_jButtonExterActionPerformed

	private boolean jButtonGPSOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGPSOKActionPerformed
		if(jTextFieldLat.getText().equals("") || jTextFieldLong.getText().equals("")) {
			System.err.println("Erreur : Champ vide ");
			JOptionPane.showMessageDialog(this, "Champ vide", "Erreur", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		float latitude = Float.parseFloat(jTextFieldLat.getText());
		float longitude = Float.parseFloat(jTextFieldLong.getText());

		if (latitude < -90 || latitude > 90) {
			System.err.println("Erreur : Latitude incorrecte");
			JOptionPane.showMessageDialog(this, "La latitude doit être un chiffre compris entre -90 et 90", "Erreur", JOptionPane.ERROR_MESSAGE);   
			return false;
		}

		if(longitude < -180 || longitude > 180) {
			System.err.println("Erreur : Longitude incorrecte ");
			JOptionPane.showMessageDialog(this, "La longitude doit être un chiffre compris en -180 et 180", "Erreur", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		position = new PositionCapteurExt(latitude, longitude);
		jLabelLocalisation.setText("Localisation (" + position.toString() + ")");
		jDialogGPS.dispose();
		return true;
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
		jButtonInterSuivant.setEnabled(true);
	}//GEN-LAST:event_jListSalleMouseClicked

	private void jButtonInterSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInterSuivantActionPerformed
		jDialogPosRel.setLocationRelativeTo(null);
                jDialogPosRel.setVisible(true);
		jDialogInter.setVisible(false);
		
	}//GEN-LAST:event_jButtonInterSuivantActionPerformed

	private void jComboBoxTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTypeActionPerformed
		
		CapteurDataType type = new CapteurDataType(jComboBoxType.getSelectedItem().toString());
		System.out.println(jTextFieldLong.getText());
		switch (type.getType()) {
		case NULL:
			jLabelUnit1.setText("  min"); 
			jLabelUnit2.setText("  max "); 
			break;
		case PRESSION_ATM:
			jLabelUnit1.setText("  hPa"); 
			jLabelUnit2.setText("  hPa"); 
			break;
		case TEMPERATURE:
			jLabelUnit1.setText("  °C"); 
			jLabelUnit2.setText("  °C");
			break;
		case HUMIDITE:
			jLabelUnit1.setText("  %"); 
			jLabelUnit2.setText("  %"); 
			break;	 
		case LUMINOSITE:
			jLabelUnit1.setText("  lum"); 
			jLabelUnit2.setText("  lum"); 
			break;
		case VOLUME:
			jLabelUnit1.setText("  dB"); 
			jLabelUnit2.setText("  dB");
			break;
		case ECLAIRAGE:
			jLabelUnit1.setText("  W"); 
			jLabelUnit2.setText("  W");	
			break; 
		case EAU_FROIDE:
			jLabelUnit1.setText("  l"); 
			jLabelUnit2.setText("  l");  
			break;
		case EAU_CHAUDE:
			jLabelUnit1.setText("  l"); 
			jLabelUnit2.setText("  l");
			break;
		case VITESSE_VENT:
			jLabelUnit1.setText("  km/h");
			jLabelUnit2.setText("  km/h");
			break;
		}
	}//GEN-LAST:event_jComboBoxTypeActionPerformed

    private void jButtonInterOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInterOKActionPerformed
        position = new PositionCapteurInt(jListBat.getSelectedValue(), jListEtage.getSelectedValue(), jListSalle.getSelectedValue(), jTextFieldPosRel2.getText());
        
        jLabelLocalisation.setText("Localisation  (" + position.toString() + ")");
        
        jDialogPosRel.setVisible(false);
    }//GEN-LAST:event_jButtonInterOKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExter;
    private javax.swing.JButton jButtonGPSOK;
    private javax.swing.JButton jButtonInter;
    private javax.swing.JButton jButtonInterOK;
    private javax.swing.JButton jButtonInterSuivant;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JComboBox<String> jComboBoxType;
    private javax.swing.JDialog jDialogGPS;
    private javax.swing.JDialog jDialogInter;
    private javax.swing.JDialog jDialogPosRel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelInterval;
    private javax.swing.JLabel jLabelLat;
    private javax.swing.JLabel jLabelLocalisation;
    private javax.swing.JLabel jLabelLong;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JLabel jLabelUnit1;
    private javax.swing.JLabel jLabelUnit2;
    private javax.swing.JList<String> jListBat;
    private javax.swing.JList<String> jListEtage;
    private javax.swing.JList<String> jListSalle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelBlank;
    private javax.swing.JPanel jPanelBlank2;
    private javax.swing.JPanel jPanelButtonsLocalisation;
    private javax.swing.JPanel jPanelGPS;
    private javax.swing.JPanel jPanelInterMain;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelPosRelMain;
    private javax.swing.JPanel jPanelSpinnersIntervals;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinnerMax;
    private javax.swing.JSpinner jSpinnerMin;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldLat;
    private javax.swing.JTextField jTextFieldLong;
    private javax.swing.JTextField jTextFieldPosRel2;
    // End of variables declaration//GEN-END:variables
}
