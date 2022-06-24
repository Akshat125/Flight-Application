package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.airport.AirportApiUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Documentation: https://support.travelpayouts.com/
 */
public class AirportApiRelease implements AirportApi {

    private WebClient webClient;

    public AirportApiRelease() {
        webClient = WebClient.builder().defaultHeader(MediaType.APPLICATION_JSON_VALUE).build();
    }

    /**
     * @param airportSearch takes a search Query and returns a List of all Airports, which are related to that query
     * @return List<AirportApiUtil>
     */
    public List<AirportApiUtil> getAirportsByString(String airportSearch) {

        try {
            String http = ("https://autocomplete.travelpayouts.com/places2?locale=de&types[]=airport&types[]=city&term=" + airportSearch);
            URI uri = new URI(http);
            String searchURI = uri.toASCIIString();
            String res = webClient.get()
                    .uri(new URI(searchURI))
                    .retrieve()
                    .bodyToMono(String.class)
                    .onErrorStop()
                    .block();
            return AirportApi.jsonStringToJavaClass(res);

        } catch (URISyntaxException e) {
            return new ArrayList<>();
        }
    }
}
