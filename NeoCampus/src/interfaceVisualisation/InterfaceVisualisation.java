/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceVisualisation;

import interfaceSimulation.IClient;

/**
 *
 * @author Noémie
 */
public class InterfaceVisualisation implements IClient {
	
    private String identifiantVisualisation;

    public InterfaceVisualisation(String identifiantVisualisation) {
	super();
	this.identifiantVisualisation = identifiantVisualisation;
    }
	
    public boolean inscription(Capteur capteur) {
    }
	
    public boolean desinscription(Capteur capteur) {
	
    }
	

}