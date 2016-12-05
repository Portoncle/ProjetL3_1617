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
public class CapteurInterieur extends Capteur {
    
    private PositionCapteurInt position;

    public CapteurInterieur(PositionCapteurInt position, String identifiantCapteur, EnumCapteurDataType typeDuCapteur) {
        super(identifiantCapteur, typeDuCapteur);
        this.position = position;
    }

    

    
}
