package client;


public class PositionCapteurExt implements PositionCapteur, Comparable<PositionCapteurExt> {
	private final float latitude;
	private final float longitude;
	
	public PositionCapteurExt(float latitude, float longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
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

	@Override
	public boolean isInterieur() {
		return !isExterieur();
	}

	@Override
	public boolean isExterieur() {
		return true;
	}

	@Override
	public int compareTo(PositionCapteurExt o) {
		if (latitude < o.latitude) {
			return 1;
		} else if (latitude == o.latitude) {
			if (longitude < o.longitude) {
				return 1;
			} else if (longitude == o.longitude) {
				return 0;
			}
			return -1;
		}
		return -1;
	}
}
