package utils.api.airline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Params {
    /**
     * This is a helper-Class to handle the API-Calls for specific Airline information: main: AirlineApiUtil
     */

    private String dep_iata;
    private String arr_iata;
    private String lang;

    public Params(String dep_iata, String arr_iata, String lang) {
        this.dep_iata = dep_iata;
        this.arr_iata = arr_iata;
        this.lang = lang;
    }

    public Params() {
    }

    public String getDep_iata() {
        return dep_iata;
    }

    public void setDep_iata(String dep_iata) {
        this.dep_iata = dep_iata;
    }

    public String getArr_iata() {
        return arr_iata;
    }

    public void setArr_iata(String arr_iata) {
        this.arr_iata = arr_iata;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
