package ressources;


public class Alerte {
    private final String type;
    private final int borneMin;
    private final int borneMax;
    
    public String getType() {
        return type;
    }
    
    public float getBorneMin() {
        return borneMin;
    }
    
    public float getBorneMax() {
        return borneMax;
    }
    
    public Alerte(String type, int min, int max) {
        this.type = type;
        this.borneMin = min;
        this.borneMax = max;
    }
}
