package client;

import ressources.Adresse;

public abstract class Client {
    
	protected Serveur serveur;
	
	public abstract boolean connexion(Adresse adresse);
	public abstract boolean deconnexion();
    
}
