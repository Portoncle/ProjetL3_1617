/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author nicol
 */
public class PositionCapteurExt implements PositionCapteur {
    private final float latitude;
    private final float longitude;
    
    public PositionCapteurExt(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
        
    public PositionCapteurExt() {
        this.latitude = 0;
        this.longitude = 0;
    }
    
    public float getLatitude() {
        return this.latitude;
    }
    
    public float getLongitude() {
        return this.longitude;
    }
    
    @Override
    public String toString() {
        return latitude + ";" + longitude;
    }

	@Override
	public String toStringAffichable() {
        return latitude + " - " + longitude;
	}
}
