package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.airport.AirportAPI;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class AirportsAPIRelease implements AirportsAPI{
    // Source: https://support.travelpayouts.com/

    private WebClient webClient;

    public AirportsAPIRelease() {
        webClient = WebClient.builder().baseUrl("https://autocomplete.travelpayouts.com/places2?locale=de&types[]=airport&types[]=city&term=").defaultHeader(MediaType.APPLICATION_JSON_VALUE).build();
    }

    public List<AirportAPI> getAirportsByString(String airportSearch) {

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
            return AirportsAPI.jsonStringToJavaClass(res);

        } catch (URISyntaxException e) {
           return new ArrayList<>();
        }
    }
}
