package utils.api.airportNameIcao;

import java.util.ArrayList;

public class Response {

    private String icao_code;
    private String country_code;
    private String iata_code;
    private double lng;
    private String name;
    private double lat;

    public Response(String icao_code, String country_code, String iata_code, double lng, String name, double lat) {
        this.icao_code = icao_code;
        this.country_code = country_code;
        this.iata_code = iata_code;
        this.lng = lng;
        this.name = name;
        this.lat = lat;
    }

    public Response() {
    }

    public String getIcao_code() {
        return icao_code;
    }

    public void setIcao_code(String icao_code) {
        this.icao_code = icao_code;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getIata_code() {
        return iata_code;
    }

    public void setIata_code(String iata_code) {
        this.iata_code = iata_code;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
