package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.airport.AirportAPI;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class AirportsAPIMockUp implements AirportsAPI {

    // Source: https://support.travelpayouts.com/

    private WebClient webClient;

    public AirportsAPIMockUp() {
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
            System.out.println(res);
            return AirportsAPI.jsonStringToJavaClass(res);

        } catch (URISyntaxException e) {
           return new ArrayList<>();
        }
    }
    /*
    public static void main(String[] args) {
        AirportsAPIMockUp airportsAPIMockUp = new AirportsAPIMockUp();
        List<Airport> airports = airportsAPIMockUp.getAirportsByString("München");

        for (int i = 0; i < airports.size(); i++) {
           System.out.println("Airport Nr. " + i + " = " + airports.get(i).getName() + " ," + airports.get(i).getType() + " , Lan:" + airports.get(i).getCoordinates().getLat() + " , Lon:" + airports.get(i).getCoordinates().getLon());
        }
    }
     */
}
