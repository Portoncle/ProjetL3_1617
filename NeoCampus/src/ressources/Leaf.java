package ressources;

import java.util.NavigableSet;
import java.util.TreeSet;

import javax.swing.tree.DefaultMutableTreeNode;

import client.Capteur;

public class Leaf extends TreeElement {

	private Capteur capteur;
	private boolean connected;

	public Leaf(Capteur capteur, boolean connected) {
		super(capteur.getIdentifiantCapteur());
		this.capteur = capteur;
		this.connected = connected;
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
			if (((Leaf) element).connected != connected) {
				connected = !connected;
				return true;
			}
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
}
