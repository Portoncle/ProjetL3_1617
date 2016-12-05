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
public class CapteurExterieur extends Capteur {
    
    private PositionCapteurExt position;

    public CapteurExterieur(int latitude, int longitude, String identifiantCapteur, EnumCapteurDataType typeDuCapteur, float min, float max) {
        super(identifiantCapteur, typeDuCapteur, min, max);
        position = new PositionCapteurExt(latitude, longitude);
    }
    
    @Override
    public String toString() {
    	return super.toString() + ";" + position.toString();
    }
    
}
