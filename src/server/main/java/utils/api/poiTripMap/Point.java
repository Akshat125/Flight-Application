package utils.api.poiTripMap;

public class Point {
    /**
     * This is a helper-Class to handle the API-Calls for Point-Of-Interests: main: PoiTripMapUtil
     */

    private double lon;
    private double lat;

    public Point(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public Point() {
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
