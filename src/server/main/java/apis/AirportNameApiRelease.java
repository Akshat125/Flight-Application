package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
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
        webClient = WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder().codecs(
                                clientCodecConfigurer ->
                                        clientCodecConfigurer.defaultCodecs().maxInMemorySize(10000000))
                        .build())
                .build();
    }

    /**
     * @param airportICAO takes the ICAO_Code of a given Airport and returns a new Object of Icao2NameApiUtil, which contains the name of the Airport
     * @return Icao2NameApiUtil
     */
    public IcaoMappingNameApiUtil getAirportData(String airportICAO) {
        try {
            String res = webClient.get()
                    .uri(new URI(("https://airlabs.co/api/v9/airports?icao_code=" + airportICAO + "&api_key=" + ApiKey.AIRLABS_KEY.getKEY())))
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
