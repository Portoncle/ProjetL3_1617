package GUI;

import client.Capteur;
import client.InterfaceVisualisation;
import client.PositionCapteurExt;
import client.PositionCapteurInt;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

import ressources.Alerte;
import ressources.Arbre;
import ressources.Leaf;
import ressources.TableRed;
import ressources.TreeElement;

public class IReel extends javax.swing.JFrame {

	//private List<Batiment> listeCaptInt = new ArrayList<>();
	//private List<PositionCapteurExt> listeCaptExt = new ArrayList<>();
//	private List<PositionCapteurExt> listeCapteursExtSelectionnes = new ArrayList<>();
//	private List<PositionCapteurInt> listeCapteursIntSelectionnes = new ArrayList<>();
	private InterfaceVisualisation interfaceVisualisation;
//	private Arbre arbre;
        
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxTypes = new javax.swing.JComboBox<>();
        jCheckBoxBat = new javax.swing.JCheckBox();
        jTextFieldBat = new javax.swing.JTextField();
        jCheckBoxEtage = new javax.swing.JCheckBox();
        jTextFieldEtage = new javax.swing.JTextField();
        jCheckBoxSalle = new javax.swing.JCheckBox();
        jTextFieldSalle = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButtonValFiltres = new javax.swing.JButton();
        jDialogAlertes = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAlertes = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
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
        jTreeCapteurs = new JTree();
        jButtonVisu = new javax.swing.JButton();
        jButtonSelect = new javax.swing.JButton();
        jButtonFiltres = new javax.swing.JButton();
        jButtonAlertes = new javax.swing.JButton();
        jPanelDroite = new javax.swing.JPanel();
        jScrollPaneTable = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        jButtonQuitter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jDialogFiltres.setTitle("Filtres");
        jDialogFiltres.setMinimumSize(new java.awt.Dimension(415, 340));

        jPanel1.setLayout(new java.awt.GridLayout(5, 2));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Type : ");
        jPanel1.add(jLabel2);

        jComboBoxTypes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NULL", "TEMPERATURE", "HUMIDITE", "ECLAIRAGE", "VOLUME", "LUMINOSITE", "EAU_FROIDE", "EAU_CHAUDE", "VITESSE_VENT", "PRESSION_ATM" }));
        jPanel1.add(jComboBoxTypes);

        jCheckBoxBat.setText("Batiment");
        jPanel1.add(jCheckBoxBat);
        jPanel1.add(jTextFieldBat);

        jCheckBoxEtage.setText("Etage");
        jPanel1.add(jCheckBoxEtage);
        jPanel1.add(jTextFieldEtage);

        jCheckBoxSalle.setText("Salle");
        jPanel1.add(jCheckBoxSalle);
        jPanel1.add(jTextFieldSalle);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);

        jButtonValFiltres.setText("Valider");
        jButtonValFiltres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValFiltresActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonValFiltres);

        javax.swing.GroupLayout jDialogFiltresLayout = new javax.swing.GroupLayout(jDialogFiltres.getContentPane());
        jDialogFiltres.getContentPane().setLayout(jDialogFiltresLayout);
        jDialogFiltresLayout.setHorizontalGroup(
            jDialogFiltresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );
        jDialogFiltresLayout.setVerticalGroup(
            jDialogFiltresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialogAlertes.setMinimumSize(new java.awt.Dimension(600, 480));

        jPanel3.setLayout(new java.awt.GridLayout(1, 1));

        jSplitPane1.setDividerLocation(400);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel4.setLayout(new java.awt.GridLayout(1, 1));

        jTableAlertes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Borne Min", "Borne Max"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class
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

        jPanel4.add(jScrollPane2);

        jSplitPane1.setTopComponent(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 5));

        jComboBoxTypesAlerte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TEMPERATURE", "HUMIDITE", "ECLAIRAGE", "VOLUME", "LUMINOSITE", "EAU_FROIDE", "EAU_CHAUDE", "VITESSE_VENT", "PRESSION_ATM" }));
        jPanel5.add(jComboBoxTypesAlerte);
        jPanel5.add(jSpinnerMinAlerte);
        jPanel5.add(jSpinnerMaxAlerte);

        jButtonAjoutAlerte.setText("Ajouter");
        jButtonAjoutAlerte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjoutAlerteActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonAjoutAlerte);

        jButtonClear.setText("Clear Alertes");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonClear);

        jSplitPane1.setRightComponent(jPanel5);

        jPanel3.add(jSplitPane1);

        javax.swing.GroupLayout jDialogAlertesLayout = new javax.swing.GroupLayout(jDialogAlertes.getContentPane());
        jDialogAlertes.getContentPane().setLayout(jDialogAlertesLayout);
        jDialogAlertesLayout.setHorizontalGroup(
            jDialogAlertesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogAlertesLayout.setVerticalGroup(
            jDialogAlertesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
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

        jScrollPane1.setViewportView(jTreeCapteurs);

        jButtonVisu.setText("Visualiser Capteur");
        jButtonVisu.addActionListener(new java.awt.event.ActionListener() {
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
                                .addComponent(jButtonVisu)
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
                    .addComponent(jButtonVisu))
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Visualisation des données");

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
                        .addComponent(jLabel1))
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
                .addComponent(jLabel1)
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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		arbre = interfaceVisualisation.getArbre();//new Arbre(interfaceVisualisation.getCapteurConnecte());
		//jTreeCapteurs = arbre.getjTreeCapteurs();
		initComponents();
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
        
        
        /**
         * TABLEAU
         */
        
        private void addValue(String ID, String type, String localisation, String value) {
            DefaultTableModel table = (DefaultTableModel) jTableData.getModel();
            String[] values = new String[4];
            values[0] = ID;
            values[1] = type;
            values[2] = localisation;
            values[3] = value;
            table.addRow(values);
        }
        
        private void editValue(String ID, String value) {
            DefaultTableModel table = (DefaultTableModel) jTableData.getModel();
            
            int i=0;
            int borne = table.getRowCount();
            String IDTab;
            boolean found = false;
            
            while(!found && i<borne) {
                IDTab = (String) table.getValueAt(i, 0);
                if(ID.equals(IDTab)) found = true;
                else i++;
            }
            
            if(found) table.setValueAt(value, i, 3);
            else System.err.println("Suppression : ID non trouve");
        }
        
        private void deleteValue(String ID) {
            DefaultTableModel table = (DefaultTableModel) jTableData.getModel();
            
            int i=0;
            int borne = table.getRowCount();
            String IDTab;
            boolean found = false;
            
            while(!found && i<borne) {
                IDTab = (String) table.getValueAt(i, 0);
                if(ID.equals(IDTab)) found = true;
                else i++;
            }
            
            if(found) table.removeRow(i);
            else System.err.println("Suppression : ID non trouve");
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
			}
		}
		interfaceVisualisation.inscription(idList);
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
        if((float) jSpinnerMaxAlerte.getValue() < (float) jSpinnerMinAlerte.getValue()) {
            System.err.println("Erreur : max < min");
        } else {
            DefaultTableModel table = (DefaultTableModel) jTableAlertes.getModel();
            Object[] values = new Object[3];
            
            String temp = (String) jComboBoxTypesAlerte.getSelectedItem();
            values[0] = temp;
            float tempB = (Float) jSpinnerMinAlerte.getValue();
            values[1] = tempB;
            float tempC = (Float) jSpinnerMaxAlerte.getValue();
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
    private javax.swing.JButton jButtonVisu;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelSelection;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelDroite;
    private javax.swing.JPanel jPanelGauche;
    private javax.swing.JPanel jPanelMain;
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
