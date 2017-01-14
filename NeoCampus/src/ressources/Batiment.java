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
public class Batiment implements Comparable<Batiment>{
    
    private String nom;
    private NavigableSet<Etage> ensembleEtage = new TreeSet<>();

    public Batiment(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

	public NavigableSet<Etage> getEnsembleEtage() {
		return ensembleEtage;
	}

	public boolean add(Etage etage) {
		if (!ensembleEtage.add(etage)) {
			for (Etage e : ensembleEtage) {
				if (e.equals(etage)) {
					return e.add(etage.getFisrtSalle());
				}
			}
		} else {
			System.out.println(ensembleEtage);
		}
		return true;
    }
    
    @Override
    public String toString() {
        return nom;
    }

    @Override
    public boolean equals(Object obj) {
    	if (obj instanceof Batiment) {
    		return compareTo((Batiment) obj) == 0;
    	}
    	return false;
    }
    
	@Override
	public int compareTo(Batiment o) {
		return nom.compareTo(o.nom);
	}
    
    
}
