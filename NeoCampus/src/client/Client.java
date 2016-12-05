/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import ressources.Adresse;

/**
 *
 * @author Noémie
 */

public abstract class Client {
    
    protected Serveur serveur;
	
    public abstract boolean connexion(Adresse adresse);
    public abstract boolean deconnexion();
    
}
