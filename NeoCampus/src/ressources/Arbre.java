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

	public Arbre(NavigableSet<Capteur> ensembleCapteurConnecte) {
		ensembleCapteur = new TreeSet<>();
		root = new DefaultMutableTreeNode(new Node("Capteur"));

		ensembleCapteur.add((exterieur = new Node("Exterieur")));
		ensembleCapteur.add((interieur = new Node("Interieur")));	
		
		lectureFichier();

		for (Capteur capteur : ensembleCapteurConnecte) {
			if (capteur.isInterieur()) {
				PositionCapteurInt positionCapteurInt = (PositionCapteurInt) capteur.getPosition();
		
				TreeElement batiment = new Node(positionCapteurInt.getBatiment());
				TreeElement etage = new Node(positionCapteurInt.getEtage());
				batiment.add(etage);
				TreeElement salle = new Node(positionCapteurInt.getSalle());
				etage.add(salle);
				TreeElement capteurLeaf = new Leaf(capteur, true);
				salle.add(capteurLeaf);
				interieur.add(batiment);
			} else {
				exterieur.add(new Leaf(capteur, true));
			}
		}
		
		jTreeCapteurs = new JTree();
	    jTreeCapteurs.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
		CreatJTree();
	}

	private void lectureFichier() {
		InputStream ips;
		try {
			ips = new FileInputStream("listeCapteursEnregistres.txt");
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			try {
				while ((ligne=br.readLine())!=null){
					String[] champ = ligne.split(";");
					int nbChamps = champ.length;
					if ((nbChamps != 6 && nbChamps != 4)) {
						System.out.println("Ligne incohérente (qui sera ignoré): CapteurPresent;" + ligne);
					}
					PositionCapteur position;
					if (nbChamps == 6) {
						// Capteur Interieur
						position = new PositionCapteurInt(champ[2], champ[3], champ[4], champ[5]);
					} else {
						// Capteur Exterieur
						position = new PositionCapteurExt(Float.parseFloat(champ[2]), Float.parseFloat(champ[3]));
					}
					Capteur capteur = new Capteur(position, champ[0], new CapteurDataType(champ[1]));
					if (capteur.isInterieur()) {
						PositionCapteurInt positionCapteurInt = (PositionCapteurInt) capteur.getPosition();
				
						TreeElement batiment = new Node(positionCapteurInt.getBatiment());
						TreeElement etage = new Node(positionCapteurInt.getEtage());
						batiment.add(etage);
						TreeElement salle = new Node(positionCapteurInt.getSalle());
						etage.add(salle);
						TreeElement capteurLeaf = new Leaf(capteur, false);
						salle.add(capteurLeaf);
						interieur.add(batiment);
					} else {
						exterieur.add(new Leaf(capteur, false));
					}
				}
				br.close(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void addInt(Capteur capteur) {
		PositionCapteurInt positionCapteurInt = (PositionCapteurInt) capteur.getPosition();
		TreeElement batiment = new Node(positionCapteurInt.getBatiment());
		TreeElement etage = new Node(positionCapteurInt.getEtage());
		batiment.add(etage);
		TreeElement salle = new Node(positionCapteurInt.getSalle());
		etage.add(salle);
		TreeElement capteurLeaf = new Leaf(capteur, true);
		salle.add(capteurLeaf);
		if (interieur.add(batiment)) {
			CreatJTree();
			System.out.println("bra");
		}
	}
	
	private void addExt(Capteur capteur) {
		if (exterieur.add(new Leaf(capteur, true))) {
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
	}
	
	public void add(Capteur capteur) {
		
		if (capteur.isInterieur()) {
			addInt(capteur);
		} else {
			addExt(capteur);
		}
	}
	
	public JTree getjTreeCapteurs() {
		return jTreeCapteurs;
	}
	
	public NavigableSet<Leaf> getEnsembleCapteurSelectiones() {
		ensembleCapteurSelectiones.clear();
		TreePath[] paths = jTreeCapteurs.getSelectionPaths();
		for (TreePath treePath : paths) {
			ensembleCapteurSelectiones.addAll(((TreeElement) ((DefaultMutableTreeNode) treePath.getLastPathComponent()).getUserObject()).getLeaf());
		}
		return ensembleCapteurSelectiones;
	}
}
