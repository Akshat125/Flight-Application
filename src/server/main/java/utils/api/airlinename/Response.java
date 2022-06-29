package utils.api.airlinename;

public class Response {
    /**
     * This is a helper-Class to handle the API-Calls for specific Airline-name information: main: AirlineNameApiUtil
     */

    private String icao_code;
    private String iata_code;
    private String name;

    public Response(String icao_code, String iata_code, String name) {
        this.icao_code = icao_code;
        this.iata_code = iata_code;
        this.name = name;
    }

    public Response() {
    }

    public String getIcao_code() {
        return icao_code;
    }

    public void setIcao_code(String icao_code) {
        this.icao_code = icao_code;
    }

    public String getIata_code() {
        return iata_code;
    }

    public void setIata_code(String iata_code) {
        this.iata_code = iata_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
