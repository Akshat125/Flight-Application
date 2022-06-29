package utils.api.iatacoordinates;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class IataCoordinatesApiUtil {
    /**
     * This is a helper Class to map the Airline-IATA-Code to specific Airport Coordinates (latitude,longitude)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    private String iata;
    private double latitude;
    private double longitude;

    public IataCoordinatesApiUtil(String iata, double latitude, double longitude) {
        this.iata = iata;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public IataCoordinatesApiUtil() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IataCoordinatesApiUtil that = (IataCoordinatesApiUtil) o;
        return Objects.equals(iata, that.iata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iata);
    }
}
