/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Random;

import ressources.EnumCapteurDataType;

/**
 *
 * @author NoÃ©mie
 */
public class Capteur {
    
    private String identifiantCapteur;
    private EnumCapteurDataType typeDuCapteur;
    private float min, max;
    private Random valeur;

    public Capteur(String identifiantCapteur, EnumCapteurDataType typeDuCapteur, float min, float max) {
	this.identifiantCapteur = identifiantCapteur;
	this.typeDuCapteur = typeDuCapteur;
	valeur = new Random();
    }
    
    public String toString() {
    	return identifiantCapteur + ";" + typeDuCapteur;
    }

    public String getIdentifiantCapteur() {
	return identifiantCapteur;
    }

    public float getValeur() {
	return min + valeur.nextFloat() * (max - min);
    }
	
    public boolean isValueCorrect (float value) {
	return (min <= value) && (value <= max);
    }
}
