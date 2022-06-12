package controller.search;

public class AirportResponse {

    private String airportName;
    private String nameCity;
    private String nameCountry;
    private String iata;

    public AirportResponse(String airportName, String nameCity, String nameCountry, String iata) {
        this.airportName = airportName;
        this.nameCity = nameCity;
        this.nameCountry = nameCountry;
        this.iata = iata;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }
}
