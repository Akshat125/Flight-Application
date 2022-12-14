package utils.api.weather;

public class Coord {
    /**
     * This is a helper-Class to handle the API-Calls for specific Weather: main: WeatherApiUtil
     */

    private double lat;
    private double lon;

    public Coord(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Coord() {
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
