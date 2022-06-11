package apis;

import org.springframework.web.reactive.function.client.WebClient;
import utils.api.airportNameIcao.Icao2NameAPI;

public class AirportNameAPIMockUp implements apis.AirportNameAPI {

    private WebClient webClient;

    private String startAirport = "dep_iata=MUC";

    public AirportNameAPIMockUp() {
    }

    @Override
    public Icao2NameAPI getAirportData(String airportICAO) {
        return new Icao2NameAPI(null,null,null);
    }
}
