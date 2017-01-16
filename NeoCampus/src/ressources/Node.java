package ressources;

import java.util.NavigableSet;
import java.util.TreeSet;

import javax.swing.tree.DefaultMutableTreeNode;

public class Node extends TreeElement{

    private NavigableSet<TreeElement> child;
	
	public Node(String nom) {
		super(nom);
		child =  new TreeSet<>();
	}

	public NavigableSet<TreeElement> getChild() {
		return child;
	}

	public boolean add(TreeElement node) {
		if (!child.add(node)) {
			for (TreeElement n : child) {
				if (n.equals(node)) {
					return n.add(node.getFisrtChild());
				}
			}
		}
		return true;
    }
    
	public TreeElement getFisrtChild() {
		return child.first();
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public void creatTree(DefaultMutableTreeNode root) {
		for (TreeElement c : child) {
			DefaultMutableTreeNode branch = new DefaultMutableTreeNode(c);
			c.creatTree(branch);
			root.add(branch);
		}
	}

	@Override
	public boolean isConnected() {
		for (TreeElement c : child) {
			if (c.isConnected()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean isEnregistre() {
		for (TreeElement c : child) {
			if (c.isEnregistre()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public NavigableSet<Leaf> getLeaf() {
		NavigableSet<Leaf> leaf = new TreeSet<>();
		for (TreeElement treeElement : child) {
			leaf.addAll(treeElement.getLeaf());
		}
		return leaf;
	}

	@Override
	public boolean remove(TreeElement element) {
		for (TreeElement treeElement : child) {
			if (treeElement.remove(element)) {
				System.out.println(treeElement + " removed");
				child.remove(treeElement);
				return child.isEmpty();
			}
			System.out.println(treeElement + " not removed");
		}
		return false;
	}
}
