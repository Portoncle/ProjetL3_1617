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
public class Salle {
    
    private String nom;
    private List<String> listePosRel = new ArrayList<String>();

    public Salle(String nom) {
        this.nom = nom;
    }

    public Salle() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setListePosRel(List<String> listePosRel) {
        this.listePosRel = listePosRel;
    }

    public List<String> getListePosRel() {
        return listePosRel;
    }

    @Override
    public String toString() {
        return nom;
    }
    
    
}
