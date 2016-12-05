/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author Noémie
 */

public abstract class Client {
    
	private Serveur serveur;
	
	public abstract boolean connexion();
	public abstract boolean deconnexion();
	

    
}
