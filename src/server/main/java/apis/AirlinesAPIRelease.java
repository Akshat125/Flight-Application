package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.airline.FlightData;
import java.net.URI;
import java.net.URISyntaxException;

public class AirlinesAPIRelease implements AirlinesAPI {

    // Source: https://aviationstack.com/
    // https://aviationstack.com/documentation

    /**
     * Do not use this Implementation atm! use the Mockup instead
     */


    private WebClient webClient;
    private String regex = "&";
    private String searchFor = "flights?";
    private String accessKey = "access_key=0a58c3ceafb82f4ef97033fd718d2655";
    private String limit = "limit=2";

    // München: IATA-Code: MUC, ICAO-Code: EDDM
    private String startAirport = "dep_iata=MUC";

    public AirlinesAPIRelease() {
        webClient = WebClient.builder().baseUrl("http://api.aviationstack.com/v1/").defaultHeader(MediaType.APPLICATION_JSON_VALUE).build();
    }

    public FlightData getFlightData(String formDep_iata, String toArr_icao) {
        try {
            String res = "";
            res = webClient.get()
                    .uri(new URI(("http://api.aviationstack.com/v1/flights?access_key=0a58c3ceafb82f4ef97033fd718d2655&dep_iata="+ formDep_iata + "&arr_icao=" + toArr_icao).toString()))
                    .retrieve()
                    .bodyToMono(String.class)
                    .onErrorStop()
                    .block();
            return AirlinesAPI.jsonStringToJavaClass(res);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
