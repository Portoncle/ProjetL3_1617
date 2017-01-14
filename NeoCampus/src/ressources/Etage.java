/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ressources;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 *
 * @author Noémie
 */
public class Etage implements Comparable<Etage>{
    
    private String nom;
    private NavigableSet<Salle> ensembleSalle = new TreeSet<>();

    public Etage(String nom) {
        this.nom = nom;
    }
    
    public String getNom() {
        return nom;
    }
    
    public NavigableSet<Salle> getEnsembleSalle() {
		return ensembleSalle;
	}
    
    public Salle getFisrtSalle() {
    	return ensembleSalle.first();
    }

    public boolean add(Salle salle) {
		if (!ensembleSalle.add(salle)) {
			for (Salle s : ensembleSalle) {
				if (s.equals(salle)) {
					return s.add(salle.getFisrtPositionRelative());
				}
			}
		}
		return true;
    }

	@Override
    public String toString() {
        return nom;
    }

    @Override
    public boolean equals(Object obj) {
    	if (obj instanceof Etage) {
    		return compareTo((Etage) obj) == 0;
    	}
    	return false;
    }
	
	@Override
	public int compareTo(Etage o) {
		return nom.compareTo(o.nom);
	}
    
    
    
}
