/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Noémie
 */
public class Batiment {
    
    private String nom;
    private List<Etage> listeEtage = new ArrayList<Etage>();

    public Batiment(String nom) {
        this.nom = nom;
    }
    
    public Batiment() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setListeEtage(List<Etage> listeEtage) {
        this.listeEtage = listeEtage;
    }

    public List<Etage> getListeEtage() {
        return listeEtage;
    }

    @Override
    public String toString() {
        return nom;
    }
    
    
}
