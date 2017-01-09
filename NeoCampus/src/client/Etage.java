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
    private List<String> listeSalle = new ArrayList<String>();

    public Etage(String nom) {
        this.nom = nom;
    }

    public Etage() {
    }

    public List<String> getListeSalle() {
        return listeSalle;
    }

    public String getNom() {
        return nom;
    }

    public void setListeSalle(List<String> listeSalle) {
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
