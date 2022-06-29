package utils.api.icaoname;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IcaoNameApiUtil {
    /**
     * This is a helper Class to map the ICAO-Code to specific Airport name
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private String icao;
    private String airportName;

    public IcaoNameApiUtil(String icao, String airportName) {
        this.icao = icao;
        this.airportName = airportName;
    }

    public IcaoNameApiUtil() {
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
