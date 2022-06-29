package utils.userflights;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserFlights {
    /**
     * This Class is used to store User-Flights (the ID-mapping: ID-User to ID-Flight)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private long userID;
    private long flightID;

    public UserFlights(long userID, long flightID){
        this.userID = userID;
        this.flightID = flightID;
    }

    public UserFlights(){

    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getFlightID() {
        return flightID;
    }

    public void setFlightID(long flightID) {
        this.flightID = flightID;
    }
}
