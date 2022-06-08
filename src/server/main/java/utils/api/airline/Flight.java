package utils.api.airline;

public class Flight{
    public String number;
    public String iata;
    public String icao;
    public Codeshared codeshared;

    public Flight(String number, String iata, String icao, Codeshared codeshared) {
        this.number = number;
        this.iata = iata;
        this.icao = icao;
        this.codeshared = codeshared;
    }

    public Flight() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public Codeshared getCodeshared() {
        return codeshared;
    }

    public void setCodeshared(Codeshared codeshared) {
        this.codeshared = codeshared;
    }
}