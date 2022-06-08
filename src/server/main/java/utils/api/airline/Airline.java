package utils.api.airline;

public class Airline{
    public String name;
    public String iata;
    public String icao;

    public Airline(String name, String iata, String icao) {
        this.name = name;
        this.iata = iata;
        this.icao = icao;
    }

    public Airline() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
