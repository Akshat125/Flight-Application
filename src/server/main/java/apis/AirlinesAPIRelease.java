package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.airline.AirlineAPI;
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

    // München: IATA-Code: MUC, ICAO-Code: BER
    private String startAirport = "dep_iata=MUC";

    public AirlinesAPIRelease() {
        webClient = WebClient.builder().baseUrl("http://api.aviationstack.com/v1/").defaultHeader(MediaType.APPLICATION_JSON_VALUE).build();
    }

    public AirlineAPI getFlightData(String formDep_iata, String toArr_iata) {
        try {
            String res = webClient.get()
                    .uri(new URI(("https://airlabs.co/api/v9/routes?api_key=f6753372-61ae-40c3-85ed-2333a7ea8b15&dep_iata="+ formDep_iata + "&arr_iata=" + toArr_iata)))
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
