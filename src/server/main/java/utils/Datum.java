package utils;

public class Datum{
    public String flight_date;
    public String flight_status;
    public Departure departure;
    public Arrival arrival;
    public Airline airline;
    public Flight flight;
    public Aircraft aircraft;
    public Object live;

    public Datum(String flight_date, String flight_status, Departure departure, Arrival arrival, Airline airline, Flight flight, Aircraft aircraft, Object live) {
        this.flight_date = flight_date;
        this.flight_status = flight_status;
        this.departure = departure;
        this.arrival = arrival;
        this.airline = airline;
        this.flight = flight;
        this.aircraft = aircraft;
        this.live = live;
    }

    public Datum() {
    }

    public String getFlight_date() {
        return flight_date;
    }

    public void setFlight_date(String flight_date) {
        this.flight_date = flight_date;
    }

    public String getFlight_status() {
        return flight_status;
    }

    public void setFlight_status(String flight_status) {
        this.flight_status = flight_status;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Object getLive() {
        return live;
    }

    public void setLive(Object live) {
        this.live = live;
    }
}