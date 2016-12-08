/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ressources;

/**
 *
 * @author NoÃ©mie
 */
public enum EnumCapteurDataType {
    
    TEMPERATURE("Température"),
    HUMIDITE("Humidité"),
    ECLAIRAGE("Consommation éclairage"),
    VOLUME("Volume sonore"),
    LUMINOSITE("Luminosité"),
    EAU_FROIDE("Eau froide"),
    EAU_CHAUDE("Eau chaude"),
    VITESSE_VENT("Vitesse vent"),
    PRESSION_ATM("Pression atmosphérique");
    
  
    
    private final String name;

    private EnumCapteurDataType(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }
}