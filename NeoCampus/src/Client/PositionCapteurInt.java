/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author Noémie
 */
public class PositionCapteurInt {
    
    private String batiment;
    private String etage;
    private String salle;
    private String positionRelative;

    public PositionCapteurInt(String batiment, String etage, String salle) {
        this.batiment = batiment;
        this.etage = etage;
        this.salle = salle;
    }

    public PositionCapteurInt() {
    }
    

    public String getBatiment() {
        return batiment;
    }

    public String getEtage() {
        return etage;
    }

    public String getSalle() {
        return salle;
    }

    public String getPositionRelative() {
        return positionRelative;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public void setPositionRelative(String positionRelative) {
        this.positionRelative = positionRelative;
    }
    
    
    
}
