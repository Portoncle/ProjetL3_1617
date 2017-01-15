package ressources;

import java.util.NavigableSet;
import java.util.TreeSet;


public class Salle implements Comparable<Salle> {
    
    private String nom;
    private NavigableSet<String> ensemblePositionRelative = new TreeSet<>();

    public Salle(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

	public String getFisrtPositionRelative() {
		return ensemblePositionRelative.first();
	}

    public NavigableSet<String> getEnsemblePositionRelative() {
		return ensemblePositionRelative;
	}

	public boolean add(String positionRelative) {
    	return ensemblePositionRelative.add(positionRelative);
    }
    
    
	@Override
    public String toString() {
        return nom;
    }

    @Override
    public boolean equals(Object obj) {
    	if (obj instanceof Salle) {
    		return compareTo((Salle) obj) == 0;
    	}
    	return false;
    }
	
	@Override
	public int compareTo(Salle o) {
		return nom.compareTo(o.nom);
	}
}
