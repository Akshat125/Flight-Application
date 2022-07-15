package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.airline.AirlineApiUtil;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Documentation: https://aviationstack.com/ || https://aviationstack.com/documentation
 */
public class AirlineApiRelease implements AirlineApi {

    private WebClient webClient;

    public AirlineApiRelease() {
        webClient = WebClient.builder().defaultHeader(MediaType.APPLICATION_JSON_VALUE).build();
    }

    /**
     * @param formDep_iata takes a corresponding IATA_CODE of a given departure Airport
     * @param toArr_iata   takes a corresponding IATA_CODE of a given arrival Airport
     * @return AirlineApiUtil
     */
    public AirlineApiUtil getFlightData(String formDep_iata, String toArr_iata) {
        try {
            String res = webClient.get()
                    .uri(new URI(("https://airlabs.co/api/v9/routes?api_key=" + ApiKey.AIRLABS_KEY.getKEY() + "&dep_iata=" + formDep_iata + "&arr_iata=" + toArr_iata)))
                    .retrieve()
                    .bodyToMono(String.class)
                    .onErrorStop()
                    .block();
            return AirlineApi.jsonStringToJavaClass(res);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
