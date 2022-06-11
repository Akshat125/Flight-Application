package utils.api.airline;

import java.util.ArrayList;

public class Response {
    private String airline_iata;
    private String airline_icao;
    private String flight_number;
    private String flight_iata;
    private String flight_icao;
    private String cs_airline_iata;
    private String cs_flight_iata;
    private String cs_flight_number;
    private String dep_iata;
    private String dep_icao;
    private ArrayList<String> dep_terminals;
    private String dep_time;
    private String dep_time_utc;
    private String arr_iata;
    private String arr_icao;
    private ArrayList<String> arr_terminals;
    private String arr_time;
    private String arr_time_utc;
    private int duration;
    private ArrayList<String> days;
    private Object aircraft_icao;

    public Response(String airline_iata, String airline_icao, String flight_number, String flight_iata, String flight_icao, String cs_airline_iata, String cs_flight_iata, String cs_flight_number, String dep_iata, String dep_icao, ArrayList<String> dep_terminals, String dep_time, String dep_time_utc, String arr_iata, String arr_icao, ArrayList<String> arr_terminals, String arr_time, String arr_time_utc, int duration, ArrayList<String> days, Object aircraft_icao) {
        this.airline_iata = airline_iata;
        this.airline_icao = airline_icao;
        this.flight_number = flight_number;
        this.flight_iata = flight_iata;
        this.flight_icao = flight_icao;
        this.cs_airline_iata = cs_airline_iata;
        this.cs_flight_iata = cs_flight_iata;
        this.cs_flight_number = cs_flight_number;
        this.dep_iata = dep_iata;
        this.dep_icao = dep_icao;
        this.dep_terminals = dep_terminals;
        this.dep_time = dep_time;
        this.dep_time_utc = dep_time_utc;
        this.arr_iata = arr_iata;
        this.arr_icao = arr_icao;
        this.arr_terminals = arr_terminals;
        this.arr_time = arr_time;
        this.arr_time_utc = arr_time_utc;
        this.duration = duration;
        this.days = days;
        this.aircraft_icao = aircraft_icao;
    }

    public String icao_code;
    public String country_code;
    public String iata_code;
    public double lng;
    public String name;
    public double lat;

    public Response(String icao_code, String country_code, String iata_code, double lng, String name, double lat){
        this.icao_code = icao_code;
        this.country_code = country_code;
        this.iata_code = iata_code;
        this.lng = lng;
        this.name = name;
        this.lat = lat;
    }

    public Response() {
    }

    public String getIcao_code() {
        return icao_code;
    }

    public void setIcao_code(String icao_code) {
        this.icao_code = icao_code;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getIata_code() {
        return iata_code;
    }

    public void setIata_code(String iata_code) {
        this.iata_code = iata_code;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
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

    public String getCs_airline_iata() {
        return cs_airline_iata;
    }

    public void setCs_airline_iata(String cs_airline_iata) {
        this.cs_airline_iata = cs_airline_iata;
    }

    public String getCs_flight_iata() {
        return cs_flight_iata;
    }

    public void setCs_flight_iata(String cs_flight_iata) {
        this.cs_flight_iata = cs_flight_iata;
    }

    public String getCs_flight_number() {
        return cs_flight_number;
    }

    public void setCs_flight_number(String cs_flight_number) {
        this.cs_flight_number = cs_flight_number;
    }

    public String getDep_iata() {
        return dep_iata;
    }

    public void setDep_iata(String dep_iata) {
        this.dep_iata = dep_iata;
    }

    public String getDep_icao() {
        return dep_icao;
    }

    public void setDep_icao(String dep_icao) {
        this.dep_icao = dep_icao;
    }

    public ArrayList<String> getDep_terminals() {
        return dep_terminals;
    }

    public void setDep_terminals(ArrayList<String> dep_terminals) {
        this.dep_terminals = dep_terminals;
    }

    public String getDep_time() {
        return dep_time;
    }

    public void setDep_time(String dep_time) {
        this.dep_time = dep_time;
    }

    public String getDep_time_utc() {
        return dep_time_utc;
    }

    public void setDep_time_utc(String dep_time_utc) {
        this.dep_time_utc = dep_time_utc;
    }

    public String getArr_iata() {
        return arr_iata;
    }

    public void setArr_iata(String arr_iata) {
        this.arr_iata = arr_iata;
    }

    public String getArr_icao() {
        return arr_icao;
    }

    public void setArr_icao(String arr_icao) {
        this.arr_icao = arr_icao;
    }

    public ArrayList<String> getArr_terminals() {
        return arr_terminals;
    }

    public void setArr_terminals(ArrayList<String> arr_terminals) {
        this.arr_terminals = arr_terminals;
    }

    public String getArr_time() {
        return arr_time;
    }

    public void setArr_time(String arr_time) {
        this.arr_time = arr_time;
    }

    public String getArr_time_utc() {
        return arr_time_utc;
    }

    public void setArr_time_utc(String arr_time_utc) {
        this.arr_time_utc = arr_time_utc;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<String> getDays() {
        return days;
    }

    public void setDays(ArrayList<String> days) {
        this.days = days;
    }

    public Object getAircraft_icao() {
        return aircraft_icao;
    }

    public void setAircraft_icao(Object aircraft_icao) {
        this.aircraft_icao = aircraft_icao;
    }
}
