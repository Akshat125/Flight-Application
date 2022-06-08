package utils;

public class Aircraft{
    public String registration;
    public String iata;
    public String icao;
    public String icao24;

    public Aircraft(String registration, String iata, String icao, String icao24) {
        this.registration = registration;
        this.iata = iata;
        this.icao = icao;
        this.icao24 = icao24;
    }

    public Aircraft() {
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getIcao24() {
        return icao24;
    }

    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }
}
