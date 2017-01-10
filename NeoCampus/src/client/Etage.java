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
public class Etage {
    
    private String nom;
    private List<Salle> listeSalle = new ArrayList<Salle>();

    public Etage(String nom) {
        this.nom = nom;
    }

    public Etage() {
    }

    public List<Salle> getListeSalle() {
        return listeSalle;
    }

    public String getNom() {
        return nom;
    }

    public void setListeSalle(List<Salle> listeSalle) {
        this.listeSalle = listeSalle;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }
    
    
    
}
