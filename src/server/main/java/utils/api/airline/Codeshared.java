package utils.api.airline;

public class Codeshared{
    public String airline_name;
    public String airline_iata;
    public String airline_icao;
    public String flight_number;
    public String flight_iata;
    public String flight_icao;

    public Codeshared(String airline_name, String airline_iata, String airline_icao, String flight_number, String flight_iata, String flight_icao) {
        this.airline_name = airline_name;
        this.airline_iata = airline_iata;
        this.airline_icao = airline_icao;
        this.flight_number = flight_number;
        this.flight_iata = flight_iata;
        this.flight_icao = flight_icao;
    }

    public Codeshared() {
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public String getAirline_iata() {
        return airline_iata;
    }

    public void setAirline_iata(String airline_iata) {
        this.airline_iata = airline_iata;
    }

    public String getAirline_icao() {
        return airline_icao;
    }

    public void setAirline_icao(String airline_icao) {
        this.airline_icao = airline_icao;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getFlight_iata() {
        return flight_iata;
    }

    public void setFlight_iata(String flight_iata) {
        this.flight_iata = flight_iata;
    }

    public String getFlight_icao() {
        return flight_icao;
    }

    public void setFlight_icao(String flight_icao) {
        this.flight_icao = flight_icao;
    }
}