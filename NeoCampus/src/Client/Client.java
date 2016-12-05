/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author Noémie
 */
public abstract class Client {
    
    private final String identifiant;

    public Client(String identifiant) {
        this.identifiant = identifiant;
    }
    
    public abstract boolean connexion(String identifiant) ;
 
    public abstract boolean deconnexion(String identifiant);
    
}
