/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Objects;

/**
 *
 * @author Noémie
 */
public class PositionCapteurInt implements PositionCapteur {
	
	private String batiment;
	private String etage;
	private String salle;
	private String positionRelative;
	
	public PositionCapteurInt(String batiment, String etage, String salle) {
		this.batiment = batiment;
		this.etage = etage;
		this.salle = salle;
	}
		
	public PositionCapteurInt() {
		this.batiment = null;
		this.etage = null;
		this.salle = null;
	}
	
	public String getBatiment() {
		return batiment;
	}
	
	public String getEtage() {
		return etage;
	}
	
	public String getSalle() {
		return salle;
	}
	
	public String getPositionRelative() {
		return positionRelative;
	}
	
	public void setBatiment(String batiment) {
		this.batiment = batiment;
	}
	
	public void setEtage(String etage) {
		this.etage = etage;
	}
	
	public void setSalle(String salle) {
		this.salle = salle;
	}
	
	public void setPositionRelative(String positionRelative) {
		this.positionRelative = positionRelative;
	}
	
	@Override
	public String toString() {
		return batiment + ";" + etage + ";" + salle + ";" + positionRelative;
	}
	
	public String toStringAffichable() {
		return batiment + " - " + etage + " - " + salle + " - " + positionRelative;
	}
		
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 53 * hash + Objects.hashCode(this.batiment);
		/*hash = 53 * hash + Objects.hashCode(this.etage);
		hash = 53 * hash + Objects.hashCode(this.salle);*/
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final PositionCapteurInt other = (PositionCapteurInt) obj;
		if (!Objects.equals(this.batiment, other.batiment))  return false;
		if (!Objects.equals(this.etage, other.etage)) return false;
		if (!Objects.equals(this.salle, other.salle)) return false;
		return true;
	}
}
