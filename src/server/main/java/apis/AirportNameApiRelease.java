package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.airportNameIcao.Icao2NameApiUtil;

import java.net.URI;
import java.net.URISyntaxException;

public class AirportNameApiRelease implements AirportNameApi {

    private WebClient webClient;

    public AirportNameApiRelease() {
        webClient = WebClient.builder().defaultHeader(MediaType.APPLICATION_JSON_VALUE).build();
    }

    public Icao2NameApiUtil getAirportData(String airportICAO) {
        try {
            String res = webClient.get()
                    .uri(new URI(("https://airlabs.co/api/v9/airports?icao_code=" + airportICAO + "&api_key=f6753372-61ae-40c3-85ed-2333a7ea8b15")))
                    .retrieve()
                    .bodyToMono(String.class)
                    .onErrorStop()
                    .block();
            return AirportNameApi.jsonStringToJavaClass(res);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}