/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Random;

import ressources.CapteurDataType;
import ressources.EnumCapteurDataType;

/**
 *
 * @author Noémie
 */
public class Capteur {
	
	private String identifiantCapteur;
	private CapteurDataType typeDuCapteur;
	private float min, max, precision;
	private Random valeur;
    private PositionCapteur position;
	
    public Capteur(PositionCapteur position, String identifiantCapteur, CapteurDataType typeDuCapteur, float min, float max, float precision) {
		this.identifiantCapteur = identifiantCapteur;
		this.typeDuCapteur = typeDuCapteur;
		this.min = min;
		this.max = max;
		this.precision = precision;
		valeur = new Random();
    	this.position = position;
    }
    
    public Capteur(PositionCapteur position, String identifiantCapteur, CapteurDataType typeDuCapteur) {
		this.identifiantCapteur = identifiantCapteur;
		this.typeDuCapteur = typeDuCapteur;
		this.min = 0;
		this.max = 0;
		this.precision = 0;
    	this.position = position;
    }
    
	public String toString() {
		return identifiantCapteur + ";" + typeDuCapteur.toSring() + ";" + position.toString();
	}
	

    public PositionCapteur getPosition() {
        return position;
    }

    public void setPosition(PositionCapteurExt position) {
        this.position = position;
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
	
	public float getMin() {
		return min;
	}
	
	public float getMax() {
		return max;
	}
	
	public CapteurDataType getTypeDuCapteur() {
		return this.typeDuCapteur;
	}
}