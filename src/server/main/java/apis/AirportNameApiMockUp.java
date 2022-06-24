package apis;

import org.springframework.web.reactive.function.client.WebClient;
import utils.api.airportNameIcao.Icao2NameApiUtil;

public class AirportNameApiMockUp implements AirportNameApi {

    private WebClient webClient;

    private String startAirport = "dep_iata=MUC";

    public AirportNameApiMockUp() {
    }

    @Override
    public Icao2NameApiUtil getAirportData(String airportICAO) {
        return new Icao2NameApiUtil(null,null,null);
    }
}
