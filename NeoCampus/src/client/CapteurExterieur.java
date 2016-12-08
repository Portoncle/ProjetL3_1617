/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import ressources.EnumCapteurDataType;

/**
 *
 * @author Noémie
 */
public class CapteurExterieur extends Capteur {
    
    private PositionCapteurExt position;
    
    public CapteurExterieur(PositionCapteurExt position, String identifiantCapteur, EnumCapteurDataType typeDuCapteur, float min, float max, float precision) {
        super(identifiantCapteur, typeDuCapteur, min, max, precision);
        this.position = position;
    }
    
    @Override
    public String toString() {
        return super.toString() + ";" + position.toString();
    }

    public PositionCapteurExt getPosition() {
        return position;
    }

    public void setPosition(PositionCapteurExt position) {
        this.position = position;
    }
        
  
}