package ressources;

import java.util.NavigableSet;
import java.util.TreeSet;

import javax.swing.tree.DefaultMutableTreeNode;

import client.Capteur;

public class Leaf extends TreeElement {

	private Capteur capteur;
	private boolean connected;
	private boolean enregistre;

	public Leaf(Capteur capteur, boolean connected, boolean enregistre) {
		super(capteur.getIdentifiantCapteur());
		this.capteur = capteur;
		this.connected = connected;
		this.enregistre = enregistre;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	@Override
	public TreeElement getFisrtChild() {
		return this;
	}

	@Override
	public boolean add(TreeElement element) {
		if (element.isLeaf()) {
			connected |= ((Leaf) element).connected;
			enregistre |= ((Leaf) element).enregistre;
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		if (capteur.isExterieur()) {
			return capteur.getPosition().toString();
		}
		return super.toString();
	}

	public boolean isConnected() {
		return connected;
	}

	public NavigableSet<TreeElement> getChild() {
		return null;
	}

	@Override
	public void creatTree(DefaultMutableTreeNode root) {
		return;
		//root.add(new DefaultMutableTreeNode(this));
	}
	
	public Capteur getCapteur() {
		return capteur;
	}

	@Override
	public NavigableSet<Leaf> getLeaf() {
		NavigableSet<Leaf> leaf = new TreeSet<>();
		leaf.add(this);
		return leaf;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Leaf) {
			return capteur.equals(((Leaf) obj).capteur);
		}
		return false;
	}
	
	@Override
	public boolean remove(TreeElement element) {
		if (this.equals(element)) {
			connected &= !((Leaf) element).connected;
			enregistre &= !((Leaf) element).enregistre;
			return !(connected | enregistre);
		}
		return false;
	}

	@Override
	public boolean isEnregistre() {
		return enregistre;
	}
}
