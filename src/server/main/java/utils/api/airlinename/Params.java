package utils.api.airlinename;

public class Params {

    private String icao_code;
    private String lang;

    public Params(String icao_code, String lang) {
        this.icao_code = icao_code;
        this.lang = lang;
    }

    public Params() {
    }

    public String getIcao_code() {
        return icao_code;
    }

    public void setIcao_code(String icao_code) {
        this.icao_code = icao_code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
