package utils.api.airport;

public class Coordinates {
    /**
     * This is a helper-Class to handle the API-Calls for specific Airport information: main: AirportApiUtil
     */

    private double lon;
    private double lat;

    public Coordinates(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public Coordinates() {
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
