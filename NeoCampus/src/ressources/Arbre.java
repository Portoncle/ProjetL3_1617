package ressources;

import client.Capteur;
import client.PositionCapteur;
import client.PositionCapteurExt;
import client.PositionCapteurInt;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NavigableSet;
import java.util.TreeSet;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;


public class Arbre {

	private NavigableSet<TreeElement> ensembleCapteur = new TreeSet<>();
	private NavigableSet<Leaf> ensembleCapteurSelectiones = new TreeSet<>();
	private TreeElement interieur;
	private TreeElement exterieur;
	private DefaultMutableTreeNode root;
	private JTree jTreeCapteurs;

	public Arbre(NavigableSet<Capteur> ensembleCapteurConnecte, NavigableSet<Capteur> ensembleCapteurHorsLigne) {
		ensembleCapteur = new TreeSet<>();
		root = new DefaultMutableTreeNode(new Node("Capteur"));

		ensembleCapteur.add((exterieur = new Node("Exterieur")));
		ensembleCapteur.add((interieur = new Node("Interieur")));	
		
		for (Capteur capteur : ensembleCapteurHorsLigne) {
			if (capteur.isInterieur()) {
				PositionCapteurInt positionCapteurInt = (PositionCapteurInt) capteur.getPosition();
		
				TreeElement batiment = new Node(positionCapteurInt.getBatiment());
				TreeElement etage = new Node(positionCapteurInt.getEtage());
				batiment.add(etage);
				TreeElement salle = new Node(positionCapteurInt.getSalle());
				etage.add(salle);
				TreeElement capteurLeaf = new Leaf(capteur, false, true);
				salle.add(capteurLeaf);
				interieur.add(batiment);
			} else {
				exterieur.add(new Leaf(capteur, false, true));
			}
		}

		for (Capteur capteur : ensembleCapteurConnecte) {
			if (capteur.isInterieur()) {
				PositionCapteurInt positionCapteurInt = (PositionCapteurInt) capteur.getPosition();
		
				TreeElement batiment = new Node(positionCapteurInt.getBatiment());
				TreeElement etage = new Node(positionCapteurInt.getEtage());
				batiment.add(etage);
				TreeElement salle = new Node(positionCapteurInt.getSalle());
				etage.add(salle);
				TreeElement capteurLeaf = new Leaf(capteur, true, false);
				salle.add(capteurLeaf);
				interieur.add(batiment);
			} else {
				exterieur.add(new Leaf(capteur, true, false));
			}
		}
		
		jTreeCapteurs = new JTree();
	    jTreeCapteurs.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
		CreatJTree();
	}
	
	private void addInt(Capteur capteur) {
		PositionCapteurInt positionCapteurInt = (PositionCapteurInt) capteur.getPosition();
		TreeElement batiment = new Node(positionCapteurInt.getBatiment());
		TreeElement etage = new Node(positionCapteurInt.getEtage());
		batiment.add(etage);
		TreeElement salle = new Node(positionCapteurInt.getSalle());
		etage.add(salle);
		TreeElement capteurLeaf = new Leaf(capteur, true, false);
		salle.add(capteurLeaf);
		if (interieur.add(batiment)) {
			CreatJTree();
		}
	}
	
	private void addExt(Capteur capteur) {
		if (exterieur.add(new Leaf(capteur, true, false))) {
			CreatJTree();
		}
	}
	
	private void CreatJTree() {
		root.removeAllChildren();
		for (TreeElement c : ensembleCapteur) {
			DefaultMutableTreeNode branch = new DefaultMutableTreeNode(c);
			c.creatTree(branch);
			root.add(branch);
		}
		jTreeCapteurs.setModel(new DefaultTreeModel(root));
		for (int i = 0; i < jTreeCapteurs.getRowCount(); i++) {
		    jTreeCapteurs.expandRow(i);
		}
	}
	
	public void add(Capteur capteur) {
		if (capteur.isInterieur()) {
			addInt(capteur);
		} else {
			addExt(capteur);
		}
	}
	
	public void remove(Capteur capteur) {
		Leaf l = new Leaf (capteur, true, false);
		interieur.remove(l);
		exterieur.remove(l);
		CreatJTree();
	}
	
	public JTree getjTreeCapteurs() {
		return jTreeCapteurs;
	}
	
	public NavigableSet<Leaf> getEnsembleCapteurSelectiones() {
		ensembleCapteurSelectiones.clear();
		TreePath[] paths = jTreeCapteurs.getSelectionPaths();
		if (paths != null) {
			for (TreePath treePath : paths) {
				ensembleCapteurSelectiones.addAll(((TreeElement) ((DefaultMutableTreeNode) treePath.getLastPathComponent()).getUserObject()).getLeaf());
			}
		}
		return ensembleCapteurSelectiones;
	}
}
