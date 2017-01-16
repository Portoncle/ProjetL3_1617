package GUI;

import java.util.HashSet;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

import client.Capteur;
import client.InterfaceSimulation;
import client.PositionCapteur;
import client.PositionCapteurExt;
import client.PositionCapteurInt;
import ressources.CapteurDataType;

/**
 * Interface recuperants les premieres informations : identifiant, type de données mesurées, localisation et intervalle des valeurs possibles
 */
public class IData extends javax.swing.JFrame {
    
	private InterfaceSimulation interfaceSimulation = new InterfaceSimulation();
	private PositionCapteur position = null;
	
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
		float precision = 0.0f, marge = 0.0f;
		
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
			else {
                            precision = 0.1f;
                            marge = 0.2f;
                        }
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
			else {
                            precision = 0.1f;
                            marge = 0.01f;
                        }
			break;
		case VOLUME:
			if (max > 120 || min < 0) {
				System.err.println("Erreur : volume sonore");
				JOptionPane.showMessageDialog(this, "Le volume sonore doit être entre 0 et 120 bB", "Erreur", JOptionPane.ERROR_MESSAGE);
				return false;
			} 
			else {
                            precision = 0.1f;
                            marge = 0.1f;
                        }
			break;
		case ECLAIRAGE:
			if (max > 3000 || min < 0) {
				System.err.println("Erreur : volume sonore");
				JOptionPane.showMessageDialog(this, "La consommation éclairage doit être entre 0 et 3000 W", "Erreur", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else {
                            precision = 1f;
                            marge = 1f;
                        } 
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
			else {
                            precision = 0.1f;
                            marge = 0.3f;
                        }
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
        jLabelTitre1 = new javax.swing.JLabel();
        jLabelTitre2 = new javax.swing.JLabel();
        jLabelLat = new javax.swing.JLabel();
        jTextFieldLat = new javax.swing.JTextField();
        jLabelLong = new javax.swing.JLabel();
        jTextFieldLong = new javax.swing.JTextField();
        jPanelBlank2 = new javax.swing.JPanel();
        jButtonGPSOK = new javax.swing.JButton();
        jDialogInter = new javax.swing.JDialog();
        jPanelInterMain = new javax.swing.JPanel();
        jPanelVide1 = new javax.swing.JPanel();
        jPanelTitre = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanelVide2 = new javax.swing.JPanel();
        jLabelChoixBat = new javax.swing.JLabel();
        jLabelChoixEtage = new javax.swing.JLabel();
        jLabelChoixSalle = new javax.swing.JLabel();
        jScrollPaneBatiment = new javax.swing.JScrollPane();
        jListBat = new javax.swing.JList<>();
        jScrollPaneEtage = new javax.swing.JScrollPane();
        jListEtage = new javax.swing.JList<>();
        jScrollPaneSalle = new javax.swing.JScrollPane();
        jListSalle = new javax.swing.JList<>();
        jPanelVide3 = new javax.swing.JPanel();
        jPanelVide4 = new javax.swing.JPanel();
        jButtonInterSuivant = new javax.swing.JButton();
        jDialogPosRel = new javax.swing.JDialog();
        jPanelPosRelMain = new javax.swing.JPanel();
        jLabelPosRel = new javax.swing.JLabel();
        jTextFieldPosRel2 = new javax.swing.JTextField();
        jButtonInterOK = new javax.swing.JButton();
        jPanelMain = new javax.swing.JPanel();
        jLabelTitre = new javax.swing.JLabel();
        jPanelVide5 = new javax.swing.JPanel();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField("Capteur 1");
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
        jPanelBoutons = new javax.swing.JPanel();
        jButtonSuiv = new javax.swing.JButton();
        jButtonPrec = new javax.swing.JButton();

        jDialogGPS.setTitle("Coordonnées GPS");
        jDialogGPS.setMinimumSize(new java.awt.Dimension(420, 300));

        jPanelGPS.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanelGPS.setLayout(new java.awt.GridLayout(4, 2, 0, 20));

        jLabelTitre1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitre1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTitre1.setText("Localisation du ");
        jPanelGPS.add(jLabelTitre1);

        jLabelTitre2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitre2.setText("capteur extérieur");
        jPanelGPS.add(jLabelTitre2);

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

        javax.swing.GroupLayout jPanelVide1Layout = new javax.swing.GroupLayout(jPanelVide1);
        jPanelVide1.setLayout(jPanelVide1Layout);
        jPanelVide1Layout.setHorizontalGroup(
            jPanelVide1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        jPanelVide1Layout.setVerticalGroup(
            jPanelVide1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        jPanelInterMain.add(jPanelVide1);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Localisation du capteur intérieur");

        javax.swing.GroupLayout jPanelTitreLayout = new javax.swing.GroupLayout(jPanelTitre);
        jPanelTitre.setLayout(jPanelTitreLayout);
        jPanelTitreLayout.setHorizontalGroup(
            jPanelTitreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitreLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelTitreLayout.setVerticalGroup(
            jPanelTitreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitreLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        jPanelInterMain.add(jPanelTitre);

        javax.swing.GroupLayout jPanelVide2Layout = new javax.swing.GroupLayout(jPanelVide2);
        jPanelVide2.setLayout(jPanelVide2Layout);
        jPanelVide2Layout.setHorizontalGroup(
            jPanelVide2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        jPanelVide2Layout.setVerticalGroup(
            jPanelVide2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        jPanelInterMain.add(jPanelVide2);

        jLabelChoixBat.setText("Choix du batiment : ");
        jLabelChoixBat.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanelInterMain.add(jLabelChoixBat);

        jLabelChoixEtage.setText("Choix de l'étage :");
        jLabelChoixEtage.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanelInterMain.add(jLabelChoixEtage);

        jLabelChoixSalle.setText("Choix de la salle :");
        jLabelChoixSalle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanelInterMain.add(jLabelChoixSalle);

        jListBat.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListBat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListBatMouseClicked(evt);
            }
        });
        jScrollPaneBatiment.setViewportView(jListBat);

        jPanelInterMain.add(jScrollPaneBatiment);

        jListEtage.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListEtage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListEtageMouseClicked(evt);
            }
        });
        jScrollPaneEtage.setViewportView(jListEtage);

        jPanelInterMain.add(jScrollPaneEtage);

        jListSalle.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListSalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListSalleMouseClicked(evt);
            }
        });
        jScrollPaneSalle.setViewportView(jListSalle);

        jPanelInterMain.add(jScrollPaneSalle);

        javax.swing.GroupLayout jPanelVide3Layout = new javax.swing.GroupLayout(jPanelVide3);
        jPanelVide3.setLayout(jPanelVide3Layout);
        jPanelVide3Layout.setHorizontalGroup(
            jPanelVide3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        jPanelVide3Layout.setVerticalGroup(
            jPanelVide3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        jPanelInterMain.add(jPanelVide3);

        javax.swing.GroupLayout jPanelVide4Layout = new javax.swing.GroupLayout(jPanelVide4);
        jPanelVide4.setLayout(jPanelVide4Layout);
        jPanelVide4Layout.setHorizontalGroup(
            jPanelVide4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        jPanelVide4Layout.setVerticalGroup(
            jPanelVide4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        jPanelInterMain.add(jPanelVide4);

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
                .addComponent(jPanelInterMain, javax.swing.GroupLayout.PREFERRED_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialogPosRel.setTitle("Saisie position relative");
        jDialogPosRel.setMinimumSize(new java.awt.Dimension(650, 150));
        jDialogPosRel.setSize(new java.awt.Dimension(517, 100));

        jPanelPosRelMain.setLayout(new java.awt.GridLayout(1, 3, 20, 0));

        jLabelPosRel.setText("Position relative (Facultatif) :");
        jPanelPosRelMain.add(jLabelPosRel);
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

        jLabelTitre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTitre.setForeground(new java.awt.Color(255, 51, 51));
        jLabelTitre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTitre.setText("Création d'un capteur :");
        jPanelMain.add(jLabelTitre);

        javax.swing.GroupLayout jPanelVide5Layout = new javax.swing.GroupLayout(jPanelVide5);
        jPanelVide5.setLayout(jPanelVide5Layout);
        jPanelVide5Layout.setHorizontalGroup(
            jPanelVide5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );
        jPanelVide5Layout.setVerticalGroup(
            jPanelVide5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        jPanelMain.add(jPanelVide5);

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
            .addGap(0, 302, Short.MAX_VALUE)
        );
        jPanelBlankLayout.setVerticalGroup(
            jPanelBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        jPanelMain.add(jPanelBlank);

        jButtonSuiv.setText("Suivant");
        jButtonSuiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuivActionPerformed(evt);
            }
        });

        jButtonPrec.setText("Précédent");
        jButtonPrec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBoutonsLayout = new javax.swing.GroupLayout(jPanelBoutons);
        jPanelBoutons.setLayout(jPanelBoutonsLayout);
        jPanelBoutonsLayout.setHorizontalGroup(
            jPanelBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBoutonsLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButtonPrec, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSuiv, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanelBoutonsLayout.setVerticalGroup(
            jPanelBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBoutonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSuiv, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPrec, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanelMain.add(jPanelBoutons);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
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
		Float min = new Float(0), max = new Float(100), precision = new Float(1);
		switch (type.getType()) {
		case NULL:
			jLabelUnit1.setText("  min"); 
			jLabelUnit2.setText("  max "); 
			break;
		case PRESSION_ATM:
			jLabelUnit1.setText("  hPa"); 
			jLabelUnit2.setText("  hPa");
			min = new Float(1000);
			max = new Float(1100);
			precision = new Float(0.1);
			break;
		case TEMPERATURE:
			jLabelUnit1.setText("  °C"); 
			jLabelUnit2.setText("  °C");
			min = new Float(-10);
			max = new Float(50);
			precision = new Float(0.1);
			break;
		case HUMIDITE:
			jLabelUnit1.setText("  %"); 
			jLabelUnit2.setText("  %"); 
			min = new Float(0);
			max = new Float(100);
			precision = new Float(1);
			break;	 
		case LUMINOSITE:
			jLabelUnit1.setText("  lum"); 
			jLabelUnit2.setText("  lum"); 
			min = new Float(0);
			max = new Float(100);
			precision = new Float(0.01);
			break;
		case VOLUME:
			jLabelUnit1.setText("  dB"); 
			jLabelUnit2.setText("  dB");
			min = new Float(0);
			max = new Float(120);
			precision = new Float(0.1);
			break;
		case ECLAIRAGE:
			jLabelUnit1.setText("  W"); 
			jLabelUnit2.setText("  W");	
			min = new Float(0);
			max = new Float(3000);
			precision = new Float(1);
			break; 
		case EAU_FROIDE:
			jLabelUnit1.setText("  l"); 
			jLabelUnit2.setText("  l");  
			min = new Float(0);
			max = new Float(100);
			precision = new Float(0.1);
			break;
		case EAU_CHAUDE:
			jLabelUnit1.setText("  l"); 
			jLabelUnit2.setText("  l");
			min = new Float(0);
			max = new Float(1000);
			precision = new Float(0.1);
			break;
		case VITESSE_VENT:
			jLabelUnit1.setText("  km/h");
			jLabelUnit2.setText("  km/h");
			min = new Float(0);
			max = new Float(30);
			precision = new Float(0.1);
			break;
		}
		jSpinnerMin.setModel(new SpinnerNumberModel(min, min, max, precision));
		jSpinnerMax.setModel(new SpinnerNumberModel(max, min, max, precision));
	}//GEN-LAST:event_jComboBoxTypeActionPerformed

        
    private void jButtonInterOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInterOKActionPerformed
        position = new PositionCapteurInt(jListBat.getSelectedValue(), jListEtage.getSelectedValue(), jListSalle.getSelectedValue(), jTextFieldPosRel2.getText());
        jLabelLocalisation.setText("Localisation  (" + position.toString() + ")");
        jDialogPosRel.setVisible(false);
    }//GEN-LAST:event_jButtonInterOKActionPerformed

    
    private void jButtonSuivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuivActionPerformed
        if(checkOK()) {
            System.out.println("Check OK : Ouverture des interfaces");
		
            IMain iMain = new IMain(this.interfaceSimulation);
            iMain.setVisible(true);
            this.dispose();
	}   
    }//GEN-LAST:event_jButtonSuivActionPerformed

    
    private void jButtonPrecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrecActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonPrecActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExter;
    private javax.swing.JButton jButtonGPSOK;
    private javax.swing.JButton jButtonInter;
    private javax.swing.JButton jButtonInterOK;
    private javax.swing.JButton jButtonInterSuivant;
    private javax.swing.JButton jButtonPrec;
    private javax.swing.JButton jButtonSuiv;
    private javax.swing.JComboBox<String> jComboBoxType;
    private javax.swing.JDialog jDialogGPS;
    private javax.swing.JDialog jDialogInter;
    private javax.swing.JDialog jDialogPosRel;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelChoixBat;
    private javax.swing.JLabel jLabelChoixEtage;
    private javax.swing.JLabel jLabelChoixSalle;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelInterval;
    private javax.swing.JLabel jLabelLat;
    private javax.swing.JLabel jLabelLocalisation;
    private javax.swing.JLabel jLabelLong;
    private javax.swing.JLabel jLabelPosRel;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JLabel jLabelTitre1;
    private javax.swing.JLabel jLabelTitre2;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JLabel jLabelUnit1;
    private javax.swing.JLabel jLabelUnit2;
    private javax.swing.JList<String> jListBat;
    private javax.swing.JList<String> jListEtage;
    private javax.swing.JList<String> jListSalle;
    private javax.swing.JPanel jPanelBlank;
    private javax.swing.JPanel jPanelBlank2;
    private javax.swing.JPanel jPanelBoutons;
    private javax.swing.JPanel jPanelButtonsLocalisation;
    private javax.swing.JPanel jPanelGPS;
    private javax.swing.JPanel jPanelInterMain;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelPosRelMain;
    private javax.swing.JPanel jPanelSpinnersIntervals;
    private javax.swing.JPanel jPanelTitre;
    private javax.swing.JPanel jPanelVide1;
    private javax.swing.JPanel jPanelVide2;
    private javax.swing.JPanel jPanelVide3;
    private javax.swing.JPanel jPanelVide4;
    private javax.swing.JPanel jPanelVide5;
    private javax.swing.JScrollPane jScrollPaneBatiment;
    private javax.swing.JScrollPane jScrollPaneEtage;
    private javax.swing.JScrollPane jScrollPaneSalle;
    private javax.swing.JSpinner jSpinnerMax;
    private javax.swing.JSpinner jSpinnerMin;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldLat;
    private javax.swing.JTextField jTextFieldLong;
    private javax.swing.JTextField jTextFieldPosRel2;
    // End of variables declaration//GEN-END:variables
}
