package client;

public interface PositionCapteur {
	@Override
	public String toString();
	
	public String toStringAffichable ();
	
	public boolean isInterieur();
	
	public boolean isExterieur();
}
