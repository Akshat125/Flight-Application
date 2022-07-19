package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.airlinename.AirlineNameApiUtil;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Documentation: https://airlabs.co/docs/
 */
public class AirlineNameApiRelease implements AirlineNameApi {


    private WebClient webClient;

    public AirlineNameApiRelease() {
        webClient = WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder().codecs(
                                clientCodecConfigurer ->
                                        clientCodecConfigurer.defaultCodecs().maxInMemorySize(10000000))
                        .build())
                .build();
    }

    /**
     * @param airline_icao takes the ICAO_CODE of a given Airline and return the corresponding Airline name/AirlineNameApiUtil
     * @return AirlineNameApiUtil
     */
    @Override
    public AirlineNameApiUtil getAirlineName(String airline_icao) {
        try {
            String res = webClient.get()
                    .uri(new URI(("https://airlabs.co/api/v9/airlines?icao_code=" + airline_icao + "&api_key=" + ApiKey.AIRLABS_KEY.getKEY())))
                    .retrieve()
                    .bodyToMono(String.class)
                    .onErrorStop()
                    .block();
            return AirlineNameApi.jsonStringToJavaClass(res);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
