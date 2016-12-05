/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import ressources.EnumCapteurDataType;

/**
 *
 * @author NoÃ©mie
 */
public class CapteurInterieur extends Capteur {
    
    private PositionCapteurInt position;

    public CapteurInterieur(PositionCapteurInt position, String identifiantCapteur, EnumCapteurDataType typeDuCapteur, float min, float max) {
        super(identifiantCapteur, typeDuCapteur, min, max);
        this.position = position;
    }

    @Override
    public String toString() {
    	return super.toString() + ";" + position.toString();
    }

    
}
