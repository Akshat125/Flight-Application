package utils.api.icaoname;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IcaoName {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private String icao;
    private String airportName;

    public IcaoName(String icao, String airportName) {
        this.icao = icao;
        this.airportName = airportName;
    }

    public IcaoName() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}
