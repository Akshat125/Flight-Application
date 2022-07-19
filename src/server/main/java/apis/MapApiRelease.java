package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.maps.CoordinatesMapApiUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Documentation: https://developer.mapquest.com/documentation/static-map-api/v5/
 */
public class MapApiRelease implements MapApi {

    private WebClient webClient;

    public MapApiRelease() {
        webClient = WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder().codecs(
                                clientCodecConfigurer ->
                                        clientCodecConfigurer.defaultCodecs().maxInMemorySize(10000000))
                        .build())
                .build();
    }

    /**
     * @param coordinatesMapAPIList takes a List of Coordinates
     * @return byte[] and returns the Byte Array/Image of a static Map, showing all Markers of the given Coordinates-List
     */
    @Override
    public byte[] getImageOfMap(List<CoordinatesMapApiUtil> coordinatesMapAPIList) {
        if (coordinatesMapAPIList.isEmpty()) {
            return new byte[0];
        }
        String zoomFactor = "";
        if (coordinatesMapAPIList.size() == 1) {
            zoomFactor = "&zoom=6";
        }
        String requestParams = MapApi.getCoords(coordinatesMapAPIList);
        byte[] image;
        try {
            String http = ("https://www.mapquestapi.com/staticmap/v5/map?locations=" + requestParams + zoomFactor + "&size=300,200@2x&key=" + ApiKey.MAP_KEY.getKEY());
            URI uri = new URI(http);
            String searchURI = uri.toASCIIString();
            image = webClient
                    .get()
                    .uri(new URI(searchURI))
                    .accept(MediaType.IMAGE_JPEG)
                    .retrieve()
                    .bodyToMono(byte[].class)
                    .block();
            return image;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
