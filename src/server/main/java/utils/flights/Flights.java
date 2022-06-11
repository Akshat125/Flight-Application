package utils.flights;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private String flightNumber;
    private String airline;
    private String departureAirport;
    private String arrivalAirport;
    private String departureIata;
    private String arrivalIata;
    private String departureTerminal;
    private String arrivalTerminal;
    private String arrivalTimezone;
    private String departureTimezone;
    private String departureTimeInUTC;
    private String departureTime;
    private String arrivalTimeInUTC;
    private String arrivalTime;
    private int duration;
    private int hashode;

    public Flights(String flightNumber, String airline, String departureAirport, String arrivalAirport,
                   String departureIata, String arrivalIata, String departureTerminal, String arrivalTerminal,
                   String arrivalTimezone, String departureTimezone, String departureTimeInUTC, String departureTime,
                   String arrivalTimeInUTC, String arrivalTime, int duration) {

        this.flightNumber = flightNumber;
        this.airline = airline;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureIata = departureIata;
        this.arrivalIata = arrivalIata;
        this.departureTerminal = departureTerminal;
        this.arrivalTerminal = arrivalTerminal;
        this.arrivalTimezone = arrivalTimezone;
        this.departureTimezone = departureTimezone;
        this.departureTimeInUTC = departureTimeInUTC;
        this.departureTime = departureTime;
        this.arrivalTimeInUTC = arrivalTimeInUTC;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.hashode = hashCode();
    }

    public Flights() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureIata() {
        return departureIata;
    }

    public void setDepartureIata(String departureIata) {
        this.departureIata = departureIata;
    }

    public String getArrivalIata() {
        return arrivalIata;
    }

    public void setArrivalIata(String arrivalIata) {
        this.arrivalIata = arrivalIata;
    }

    public String getDepartureTerminal() {
        return departureTerminal;
    }

    public void setDepartureTerminal(String departureTerminal) {
        this.departureTerminal = departureTerminal;
    }

    public String getArrivalTerminal() {
        return arrivalTerminal;
    }

    public void setArrivalTerminal(String arrivalTerminal) {
        this.arrivalTerminal = arrivalTerminal;
    }

    public String getArrivalTimezone() {
        return arrivalTimezone;
    }

    public void setArrivalTimezone(String arrivalTimezone) {
        this.arrivalTimezone = arrivalTimezone;
    }

    public String getDepartureTimezone() {
        return departureTimezone;
    }

    public void setDepartureTimezone(String departureTimezone) {
        this.departureTimezone = departureTimezone;
    }

    public String getDepartureTimeInUTC() {
        return departureTimeInUTC;
    }

    public void setDepartureTimeInUTC(String departureTimeInUTC) {
        this.departureTimeInUTC = departureTimeInUTC;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTimeInUTC() {
        return arrivalTimeInUTC;
    }

    public void setArrivalTimeInUTC(String arrivalTimeInUTC) {
        this.arrivalTimeInUTC = arrivalTimeInUTC;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getHashode() {
        return hashode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flights flights = (Flights) o;
        return hashode == flights.hashode;
    }
}
