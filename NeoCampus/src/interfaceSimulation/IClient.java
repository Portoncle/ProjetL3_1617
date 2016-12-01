/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceSimulation;

/**
 *
 * @author Noémie
 */
public interface IClient {
    
    public boolean connexion(String identifiant) ;
 
    public boolean deconnexion(String identifiant);
    
}
