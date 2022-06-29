package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.airportNameIcao.IcaoMappingNameApiUtil;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Documentation: https://airlabs.co/docs/
 */
public class AirportNameApiRelease implements AirportNameApi {

    private WebClient webClient;

    public AirportNameApiRelease() {
        webClient = WebClient.builder().defaultHeader(MediaType.APPLICATION_JSON_VALUE).build();
    }

    /**
     * @param airportICAO takes the ICAO_Code of a given Airport and returns a new Object of Icao2NameApiUtil, which contains the name of the Airport
     * @return Icao2NameApiUtil
     */
    public IcaoMappingNameApiUtil getAirportData(String airportICAO) {
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
