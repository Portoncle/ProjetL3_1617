/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceSimulation;

/**
 *
 * @author Noémie
 */
public class CapteurExterieur extends Capteur {
    
    private int coordonneesGPS_lat;
    private int coordonnesGRS_long;

    public CapteurExterieur(int coordonneesGPS_lat, int coordonnesGRS_long, String identifiantCapteur, EnumCapteurDataType typeDuCapteur) {
        super(identifiantCapteur, typeDuCapteur);
        this.coordonneesGPS_lat = coordonneesGPS_lat;
        this.coordonnesGRS_long = coordonnesGRS_long;
    }
    
    
}
