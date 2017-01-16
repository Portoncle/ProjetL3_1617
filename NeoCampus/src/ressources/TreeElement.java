package ressources;

import java.util.NavigableSet;

import javax.swing.tree.DefaultMutableTreeNode;

public abstract class TreeElement implements Comparable<TreeElement>{
    
    private String nom;
    
    public TreeElement(String nom) {
        this.nom = nom;
    }
    
    public abstract boolean isLeaf();
    
    @Override
    public String toString() {
        return nom;
    }

    @Override
    public boolean equals(Object obj) {
    	if (obj instanceof TreeElement) {
    		return compareTo((TreeElement) obj) == 0;
    	}
    	return false;
    }
    
	@Override
	public int compareTo(TreeElement o) {
		return nom.compareTo(o.nom);
	}

	public abstract TreeElement getFisrtChild();

	public abstract boolean add(TreeElement element);
	
	public abstract NavigableSet<TreeElement> getChild();
	
	public abstract void creatTree(DefaultMutableTreeNode root);

	public abstract boolean isConnected();

	public abstract boolean isEnregistre();
	
	public abstract NavigableSet<Leaf> getLeaf();
	
	public abstract boolean remove(TreeElement element);
	
}
