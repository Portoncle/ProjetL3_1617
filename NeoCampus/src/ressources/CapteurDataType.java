package ressources;

import main.Main;

public class CapteurDataType {
	private EnumCapteurDataType type;
	
	public CapteurDataType (String type) {	
		if ((type).equals("Température")) this.type = EnumCapteurDataType.TEMPERATURE;
		else if ((type).equals("Humidité")) this.type = EnumCapteurDataType.HUMIDITE;
		else if ((type).equals("Consommation éclairage")) this.type = EnumCapteurDataType.ECLAIRAGE;
		else if ((type).equals("Volume sonore")) this.type = EnumCapteurDataType.VOLUME;
		else if ((type).equals("Luminosité")) this.type = EnumCapteurDataType.LUMINOSITE;
		else if ((type).equals("Eau froide")) this.type = EnumCapteurDataType.EAU_FROIDE;
		else if ((type).equals("Eau chaude")) this.type = EnumCapteurDataType.EAU_CHAUDE;
		else if ((type).equals("Vitesse vent")) this.type = EnumCapteurDataType.VITESSE_VENT;
		else if ((type).equals("Pression atmosphérique")) this.type = EnumCapteurDataType.PRESSION_ATM;
		else this.type = EnumCapteurDataType.NULL;
	}
	
	public String toSring() { 
		switch (type) {
		case TEMPERATURE:
			return "Température";
		case HUMIDITE:
			return "Humidité";
		case ECLAIRAGE:
			return "Consommation éclairage";
		case VOLUME:
			return "Volume sonore";
		case LUMINOSITE:
			return "Luminosité";
		case EAU_FROIDE:
			return "Eau froide";
		case EAU_CHAUDE:
			return "Eau chaude";
		case VITESSE_VENT:
			return "Vitesse vent";
		case PRESSION_ATM:
			return "Pression atmosphérique";
		}
		return "---- Veuillez sélectionner le type de données  ----";
	}
	
	public EnumCapteurDataType getType() {
		return type;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CapteurDataType) {
			return type.equals(((CapteurDataType) obj).type);
		}
		return false;
	}
}
