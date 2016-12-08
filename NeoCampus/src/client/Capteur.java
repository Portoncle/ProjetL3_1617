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
 * @author Noémie
 */
public class Capteur {
    
    private String identifiantCapteur;
    private EnumCapteurDataType typeDuCapteur;
    private float min, max, precision;
    private Random valeur;
    
    public Capteur() {
        this.identifiantCapteur = null;
        this.typeDuCapteur = null;
        this.min = 0;
        this.max = 0;
        this.precision = 0;
        valeur = new Random();
    }
    
    public Capteur(String identifiantCapteur, EnumCapteurDataType typeDuCapteur, float min, float max, float precision) {
        this.identifiantCapteur = identifiantCapteur;
        this.typeDuCapteur = typeDuCapteur;
        this.min = min;
        this.max = max;
        this.precision = precision;
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
    
    public float getMin() {
        return min;
    }
    
    public float getMax() {
        return max;
    }
    
    public float getPrecision() {
        return precision;
    }
    
    public EnumCapteurDataType getTypeDuCapteur() {
        return this.typeDuCapteur;
    }
    
    public boolean isValueCorrect (float value) {
        return (min <= value) && (value <= max);
    }

    public void setIdentifiantCapteur(String identifiantCapteur) {
        this.identifiantCapteur = identifiantCapteur;
    }

    public void setTypeDuCapteur(String typeDuCapteur) {
        if ((typeDuCapteur).equals("Température")) this.typeDuCapteur = EnumCapteurDataType.TEMPERATURE;
        if ((typeDuCapteur).equals("Humidité")) this.typeDuCapteur = EnumCapteurDataType.HUMIDITE;
        if ((typeDuCapteur).equals("Consommation éclairage")) this.typeDuCapteur = EnumCapteurDataType.ECLAIRAGE;
        if ((typeDuCapteur).equals("Volume sonore")) this.typeDuCapteur = EnumCapteurDataType.VOLUME;
        if ((typeDuCapteur).equals("Luminosité")) this.typeDuCapteur = EnumCapteurDataType.LUMINOSITE;
        if ((typeDuCapteur).equals("Eau froide")) this.typeDuCapteur = EnumCapteurDataType.EAU_FROIDE;
        if ((typeDuCapteur).equals("Eau chaude")) this.typeDuCapteur = EnumCapteurDataType.EAU_CHAUDE;
        if ((typeDuCapteur).equals("Vitesse vent")) this.typeDuCapteur = EnumCapteurDataType.VITESSE_VENT;
        if ((typeDuCapteur).equals("Pression atmosphérique")) this.typeDuCapteur = EnumCapteurDataType.PRESSION_ATM;
    }
    
    public void setMin(float min) {
        this.min = min;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public void setValeur(Random valeur) {
        this.valeur = valeur;
    }
    
    public void setPrecision(float precision) {
        this.precision = precision;
    }

    
}