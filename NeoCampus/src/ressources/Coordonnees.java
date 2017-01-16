package ressources;

import client.PositionCapteurExt;

public class Coordonnees extends PositionCapteurExt {

	private String identifiant;
	
	public Coordonnees(float latitude, float longitude, String identifiant) {
		super(latitude, longitude);
		this.identifiant = identifiant;
	}
	
	public Coordonnees(PositionCapteurExt positionCapteurExt, String identifiant) {
		super(positionCapteurExt.getLatitude(), positionCapteurExt.getLongitude());
		this.identifiant = identifiant;
	}
	
}
