package utils.api.airport;

import java.util.ArrayList;

public class AirportAPI {

    public String type;
    public String code;
    public String name;
    public String country_code;
    public String country_name;
    public String state_code;
    public Coordinates coordinates;
    public ArrayList<String> index_strings;
    public int weight;
    public Object cases;
    public Object country_cases;
    public Object main_airport_name;
    public String city_code;
    public String city_name;
    public Object city_cases;

    public AirportAPI(String type, String code, String name, String country_code, String country_name, String state_code, Coordinates coordinates, ArrayList<String> index_strings, int weight, Object cases, Object country_cases, Object main_airport_name, String city_code, String city_name, Object city_cases) {
        this.type = type;
        this.code = code;
        this.name = name;
        this.country_code = country_code;
        this.country_name = country_name;
        this.state_code = state_code;
        this.coordinates = coordinates;
        this.index_strings = index_strings;
        this.weight = weight;
        this.cases = cases;
        this.country_cases = country_cases;
        this.main_airport_name = main_airport_name;
        this.city_code = city_code;
        this.city_name = city_name;
        this.city_cases = city_cases;
    }

    public AirportAPI() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ArrayList<String> getIndex_strings() {
        return index_strings;
    }

    public void setIndex_strings(ArrayList<String> index_strings) {
        this.index_strings = index_strings;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Object getCases() {
        return cases;
    }

    public void setCases(Object cases) {
        this.cases = cases;
    }

    public Object getCountry_cases() {
        return country_cases;
    }

    public void setCountry_cases(Object country_cases) {
        this.country_cases = country_cases;
    }

    public Object getMain_airport_name() {
        return main_airport_name;
    }

    public void setMain_airport_name(Object main_airport_name) {
        this.main_airport_name = main_airport_name;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public Object getCity_cases() {
        return city_cases;
    }

    public void setCity_cases(Object city_cases) {
        this.city_cases = city_cases;
    }
}
