/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ressources;

/**
 *
 * @author nicol
 */
public class Alerte {
    private String type;
    private float borneMin;
    private float borneMax;
    
    public String getType() {
        return type;
    }
    
    public float getBorneMin() {
        return borneMin;
    }
    
    public float getBorneMax() {
        return borneMax;
    }
    
    public Alerte(String type, float min, float max) {
        this.type = type;
        this.borneMin = min;
        this.borneMax = max;
    }
}
