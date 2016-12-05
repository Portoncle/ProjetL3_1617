/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author NoÃ©mie
 */
public class Capteur {
    
    private String identifiantCapteur;
    private EnumCapteurDataType typeDuCapteur;

    public Capteur(String identifiantCapteur, EnumCapteurDataType typeDuCapteur) {
        this.identifiantCapteur = identifiantCapteur;
        this.typeDuCapteur = typeDuCapteur;
    }
    
    
}
