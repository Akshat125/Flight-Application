package utils.api.maps;

public class CoordinatesMapApiUtil {
    /**
     * This is a helper Class to have Objects to store Coordinates (latitude,longitude)
     */

    private double latitude;
    private double longitude;

    public CoordinatesMapApiUtil(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
