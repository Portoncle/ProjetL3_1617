package GUI;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import client.Capteur;
import client.InterfaceVisualisation;
import ressources.Alerte;
import ressources.Leaf;
import ressources.TableRed;
import ressources.TreeElement;

public class IReel extends javax.swing.JFrame {

	private InterfaceVisualisation interfaceVisualisation;
        
        private static List<Alerte> alertes = new ArrayList<>();
        
        private String filtreType;
        private boolean filtreBat = false;
        private String bat;
        private boolean filtreEtage = false;
        private String etage;
        private boolean filtreSalle = false;
        private String salle;

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogFiltres = new javax.swing.JDialog();
        jPanelMainFiltres = new javax.swing.JPanel();
        jPanelTitreFiltre = new javax.swing.JPanel();
        jLabelTitreFiltre = new javax.swing.JLabel();
        jPanelVide1 = new javax.swing.JPanel();
        jLabelType = new javax.swing.JLabel();
        jComboBoxTypes = new javax.swing.JComboBox<>();
        jCheckBoxBat = new javax.swing.JCheckBox();
        jTextFieldBat = new javax.swing.JTextField();
        jCheckBoxEtage = new javax.swing.JCheckBox();
        jTextFieldEtage = new javax.swing.JTextField();
        jCheckBoxSalle = new javax.swing.JCheckBox();
        jTextFieldSalle = new javax.swing.JTextField();
        jPanelVide2 = new javax.swing.JPanel();
        jButtonValFiltres = new javax.swing.JButton();
        jDialogAlertes = new javax.swing.JDialog();
        jPanelAlertes = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanelHaut = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAlertes = new javax.swing.JTable();
        jPanelBas = new javax.swing.JPanel();
        jComboBoxTypesAlerte = new javax.swing.JComboBox<>();
        jSpinnerMinAlerte = new javax.swing.JSpinner();
        jSpinnerMaxAlerte = new javax.swing.JSpinner();
        jButtonAjoutAlerte = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jPanelMain = new javax.swing.JPanel();
        jButtonRetour = new javax.swing.JButton();
        jSplitPaneMain = new javax.swing.JSplitPane();
        jPanelGauche = new javax.swing.JPanel();
        jLabelSelection = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeCapteurs = new javax.swing.JTree();
        jButtonMAJ = new javax.swing.JButton();
        jButtonSelect = new javax.swing.JButton();
        jButtonFiltres = new javax.swing.JButton();
        jButtonAlertes = new javax.swing.JButton();
        jPanelDroite = new javax.swing.JPanel();
        jScrollPaneTable = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        jButtonQuitter = new javax.swing.JButton();
        jLabelTitre = new javax.swing.JLabel();

        jDialogFiltres.setTitle("Filtres");
        jDialogFiltres.setMinimumSize(new java.awt.Dimension(415, 340));

        jPanelMainFiltres.setLayout(new java.awt.GridLayout(6, 2, 5, 10));

        jLabelTitreFiltre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitreFiltre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTitreFiltre.setText("Choix des filtres :");

        javax.swing.GroupLayout jPanelTitreFiltreLayout = new javax.swing.GroupLayout(jPanelTitreFiltre);
        jPanelTitreFiltre.setLayout(jPanelTitreFiltreLayout);
        jPanelTitreFiltreLayout.setHorizontalGroup(
            jPanelTitreFiltreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitreFiltreLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabelTitreFiltre, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelTitreFiltreLayout.setVerticalGroup(
            jPanelTitreFiltreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitreFiltreLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabelTitreFiltre)
                .addContainerGap())
        );

        jPanelMainFiltres.add(jPanelTitreFiltre);

        javax.swing.GroupLayout jPanelVide1Layout = new javax.swing.GroupLayout(jPanelVide1);
        jPanelVide1.setLayout(jPanelVide1Layout);
        jPanelVide1Layout.setHorizontalGroup(
            jPanelVide1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );
        jPanelVide1Layout.setVerticalGroup(
            jPanelVide1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jPanelMainFiltres.add(jPanelVide1);

        jLabelType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelType.setText("Type : ");
        jPanelMainFiltres.add(jLabelType);

        jComboBoxTypes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NULL", "TEMPERATURE", "HUMIDITE", "ECLAIRAGE", "VOLUME", "LUMINOSITE", "EAU_FROIDE", "EAU_CHAUDE", "VITESSE_VENT", "PRESSION_ATM" }));
        jPanelMainFiltres.add(jComboBoxTypes);

        jCheckBoxBat.setText("Batiment");
        jPanelMainFiltres.add(jCheckBoxBat);
        jPanelMainFiltres.add(jTextFieldBat);

        jCheckBoxEtage.setText("Etage");
        jPanelMainFiltres.add(jCheckBoxEtage);
        jPanelMainFiltres.add(jTextFieldEtage);

        jCheckBoxSalle.setText("Salle");
        jPanelMainFiltres.add(jCheckBoxSalle);
        jPanelMainFiltres.add(jTextFieldSalle);

        javax.swing.GroupLayout jPanelVide2Layout = new javax.swing.GroupLayout(jPanelVide2);
        jPanelVide2.setLayout(jPanelVide2Layout);
        jPanelVide2Layout.setHorizontalGroup(
            jPanelVide2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );
        jPanelVide2Layout.setVerticalGroup(
            jPanelVide2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jPanelMainFiltres.add(jPanelVide2);

        jButtonValFiltres.setText("Valider");
        jButtonValFiltres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValFiltresActionPerformed(evt);
            }
        });
        jPanelMainFiltres.add(jButtonValFiltres);

        javax.swing.GroupLayout jDialogFiltresLayout = new javax.swing.GroupLayout(jDialogFiltres.getContentPane());
        jDialogFiltres.getContentPane().setLayout(jDialogFiltresLayout);
        jDialogFiltresLayout.setHorizontalGroup(
            jDialogFiltresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogFiltresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMainFiltres, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jDialogFiltresLayout.setVerticalGroup(
            jDialogFiltresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogFiltresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMainFiltres, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jDialogAlertes.setMinimumSize(new java.awt.Dimension(600, 480));

        jPanelAlertes.setLayout(new java.awt.GridLayout(1, 1, 5, 5));

        jSplitPane1.setDividerLocation(400);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanelHaut.setLayout(new java.awt.GridLayout(1, 1, 5, 5));

        jTableAlertes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Borne Min", "Borne Max"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableAlertes);

        jPanelHaut.add(jScrollPane2);

        jSplitPane1.setTopComponent(jPanelHaut);

        jPanelBas.setLayout(new java.awt.GridLayout(1, 5, 10, 0));

        jComboBoxTypesAlerte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TEMPERATURE", "HUMIDITE", "ECLAIRAGE", "VOLUME", "LUMINOSITE", "EAU_FROIDE", "EAU_CHAUDE", "VITESSE_VENT", "PRESSION_ATM" }));
        jPanelBas.add(jComboBoxTypesAlerte);
        jPanelBas.add(jSpinnerMinAlerte);
        jPanelBas.add(jSpinnerMaxAlerte);

        jButtonAjoutAlerte.setText("Ajouter");
        jButtonAjoutAlerte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjoutAlerteActionPerformed(evt);
            }
        });
        jPanelBas.add(jButtonAjoutAlerte);

        jButtonClear.setText("Clear Alertes");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });
        jPanelBas.add(jButtonClear);

        jSplitPane1.setRightComponent(jPanelBas);

        jPanelAlertes.add(jSplitPane1);

        javax.swing.GroupLayout jDialogAlertesLayout = new javax.swing.GroupLayout(jDialogAlertes.getContentPane());
        jDialogAlertes.getContentPane().setLayout(jDialogAlertesLayout);
        jDialogAlertesLayout.setHorizontalGroup(
            jDialogAlertesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAlertes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogAlertesLayout.setVerticalGroup(
            jDialogAlertesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAlertes, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visualisation en temps réelle des capteurs");

        jPanelMain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButtonRetour.setText("Retour");
        jButtonRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetourActionPerformed(evt);
            }
        });

        jSplitPaneMain.setDividerSize(3);
        jSplitPaneMain.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jPanelGauche.setPreferredSize(new java.awt.Dimension(200, 452));

        jLabelSelection.setText("Selection du/des capteurs :");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Capteurs");
        jTreeCapteurs.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jTreeCapteurs);

        jButtonMAJ.setText("Rafraichir liste");
        jButtonMAJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMAJActionPerformed(evt);
            }
        });

        jButtonSelect.setText("Selectionner noeud");
        jButtonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectActionPerformed(evt);
            }
        });

        jButtonFiltres.setText("Filtres");
        jButtonFiltres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltresActionPerformed(evt);
            }
        });

        jButtonAlertes.setText("Alertes");
        jButtonAlertes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlertesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGaucheLayout = new javax.swing.GroupLayout(jPanelGauche);
        jPanelGauche.setLayout(jPanelGaucheLayout);
        jPanelGaucheLayout.setHorizontalGroup(
            jPanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGaucheLayout.createSequentialGroup()
                .addGroup(jPanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGaucheLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabelSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelGaucheLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGaucheLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGaucheLayout.createSequentialGroup()
                                .addComponent(jButtonMAJ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSelect)))))
                .addContainerGap())
            .addGroup(jPanelGaucheLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButtonFiltres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAlertes)
                .addGap(38, 38, 38))
        );
        jPanelGaucheLayout.setVerticalGroup(
            jPanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGaucheLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelSelection)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSelect)
                    .addComponent(jButtonMAJ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFiltres)
                    .addComponent(jButtonAlertes))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jSplitPaneMain.setLeftComponent(jPanelGauche);

        jPanelDroite.setLayout(new java.awt.GridLayout(1, 1));

        jTableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Type de Mesures", "Localisation", "Valeur Mesurée"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneTable.setViewportView(jTableData);

        jPanelDroite.add(jScrollPaneTable);

        jSplitPaneMain.setRightComponent(jPanelDroite);

        jButtonQuitter.setText("Quitter");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        jLabelTitre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTitre.setForeground(new java.awt.Color(255, 0, 51));
        jLabelTitre.setText("Visualisation des données");

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonQuitter))
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jLabelTitre))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSplitPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRetour))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addComponent(jButtonQuitter)
                .addGap(3, 3, 3)
                .addComponent(jLabelTitre)
                .addGap(18, 18, 18)
                .addComponent(jSplitPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonRetour)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	public IReel(InterfaceVisualisation interfaceVisualisation) {
		this.interfaceVisualisation = interfaceVisualisation;
		initComponents();
		interfaceVisualisation.setTable((DefaultTableModel) jTableData.getModel());
		jTreeCapteurs = interfaceVisualisation.getArbre().getjTreeCapteurs();
		jScrollPane1.setViewportView(jTreeCapteurs);
		jTreeCapteurs.setCellRenderer(new DefaultTreeCellRenderer() {
			  public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
				    // Defer to superclass to create initial version of JLabel and then modify (below).
				  	super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

				    TreeElement capteur = (TreeElement) ((DefaultMutableTreeNode) value).getUserObject();

				    // Inspect user object and change rendering based on this.
				    if (!capteur.toString().equals("Capteur")) {
					    if (capteur.isConnected()) {
							setForeground(new Color(13, 115, 57));
					    } else {
							setForeground(new Color(115, 13, 57));
					    }
				    }

				    // Could also inspect whether node is a leaf node, etc.
				    return this;
				  }
				});
        jTableData.setDefaultRenderer(Object.class, new TableRed());
		//arbre.constructionTree(listeCaptInt, listeCaptExt,jTreeCapteurs);
	}
	
        
    public static List<Alerte> getAlertes() {
        return IReel.alertes;
    }
       
        
        
	private void jButtonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetourActionPerformed
		dispose();
	}//GEN-LAST:event_jButtonRetourActionPerformed

   
	
	private void jButtonMAJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMAJActionPerformed
		/*DefaultMutableTreeNode racine = (DefaultMutableTreeNode) jTreeCapteurs.getModel().getRoot();
		jTreeCapteurs.clearSelection();
		racine.removeAllChildren();
		arbre.constructionTree(listeCaptInt, listeCaptExt, jTreeCapteurs);*/
		
	}//GEN-LAST:event_jButtonMAJActionPerformed

	
	private void jButtonSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectActionPerformed
		NavigableSet<Leaf> CapteurSelectionne = interfaceVisualisation.getArbre().getEnsembleCapteurSelectiones();
		List<String> idList = new ArrayList<>();
		for (Leaf c : CapteurSelectionne) {
			Capteur capteur = c.getCapteur();
			if (c.isConnected()) {
				idList.add(c.getCapteur().getIdentifiantCapteur());
				interfaceVisualisation.addValue(capteur);
			}
		}
		if (idList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Aucun capteur connecté selectionné. \nVeuillez Selectionner au moins un capteur connecté (vert)", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		else {
			interfaceVisualisation.inscription(idList);
		}
	}//GEN-LAST:event_jButtonSelectActionPerformed

        
	private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
		System.exit(0);
	}//GEN-LAST:event_jButtonQuitterActionPerformed

    private void jButtonAlertesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlertesActionPerformed
        jDialogAlertes.setLocationRelativeTo(null);
        jDialogAlertes.setVisible(true);
    }//GEN-LAST:event_jButtonAlertesActionPerformed

    private void jButtonFiltresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltresActionPerformed
        jDialogFiltres.setLocationRelativeTo(null);
        jDialogFiltres.setVisible(true);
    }//GEN-LAST:event_jButtonFiltresActionPerformed

    private void jButtonValFiltresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValFiltresActionPerformed
        filtreType = (String) jComboBoxTypes.getSelectedItem();
        
        if(filtreBat = jCheckBoxBat.isSelected()) bat = jTextFieldBat.getText();
        if(filtreEtage = jCheckBoxEtage.isSelected()) etage = jTextFieldEtage.getText();
        if(filtreSalle = jCheckBoxSalle.isSelected()) salle = jTextFieldSalle.getText();
        
        jDialogFiltres.setVisible(false);
    }//GEN-LAST:event_jButtonValFiltresActionPerformed

    private void jButtonAjoutAlerteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjoutAlerteActionPerformed
        if((int) jSpinnerMaxAlerte.getValue() < (int) jSpinnerMinAlerte.getValue()) {
            System.err.println("Erreur : max < min");
        } else {
            DefaultTableModel table = (DefaultTableModel) jTableAlertes.getModel();
            Object[] values = new Object[3];
            
            String temp = (String) jComboBoxTypesAlerte.getSelectedItem();
            values[0] = temp;
            int tempB = (int) jSpinnerMinAlerte.getValue();
            values[1] = tempB;
            int tempC = (int) jSpinnerMaxAlerte.getValue();
            values[2] = tempC;
            table.addRow(values);
            
            Alerte alerte = new Alerte(temp, tempB, tempC);
            
            this.alertes.add(alerte);
        }
    }//GEN-LAST:event_jButtonAjoutAlerteActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        DefaultTableModel table = (DefaultTableModel) jTableAlertes.getModel();
        table.setRowCount(0);
        alertes.clear();
    }//GEN-LAST:event_jButtonClearActionPerformed
 
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjoutAlerte;
    private javax.swing.JButton jButtonAlertes;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonFiltres;
    private javax.swing.JButton jButtonMAJ;
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JButton jButtonSelect;
    private javax.swing.JButton jButtonValFiltres;
    private javax.swing.JCheckBox jCheckBoxBat;
    private javax.swing.JCheckBox jCheckBoxEtage;
    private javax.swing.JCheckBox jCheckBoxSalle;
    private javax.swing.JComboBox<String> jComboBoxTypes;
    private javax.swing.JComboBox<String> jComboBoxTypesAlerte;
    private javax.swing.JDialog jDialogAlertes;
    private javax.swing.JDialog jDialogFiltres;
    private javax.swing.JLabel jLabelSelection;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JLabel jLabelTitreFiltre;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JPanel jPanelAlertes;
    private javax.swing.JPanel jPanelBas;
    private javax.swing.JPanel jPanelDroite;
    private javax.swing.JPanel jPanelGauche;
    private javax.swing.JPanel jPanelHaut;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelMainFiltres;
    private javax.swing.JPanel jPanelTitreFiltre;
    private javax.swing.JPanel jPanelVide1;
    private javax.swing.JPanel jPanelVide2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneTable;
    private javax.swing.JSpinner jSpinnerMaxAlerte;
    private javax.swing.JSpinner jSpinnerMinAlerte;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPaneMain;
    private javax.swing.JTable jTableAlertes;
    private javax.swing.JTable jTableData;
    private javax.swing.JTextField jTextFieldBat;
    private javax.swing.JTextField jTextFieldEtage;
    private javax.swing.JTextField jTextFieldSalle;
    private javax.swing.JTree jTreeCapteurs;
    // End of variables declaration//GEN-END:variables
}