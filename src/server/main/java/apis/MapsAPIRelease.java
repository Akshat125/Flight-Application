package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.maps.CoordinatesMapAPI;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class MapsAPIRelease implements MapsAPI {

    private WebClient webClient;

    public MapsAPIRelease() {
        webClient = WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder().codecs(
                                clientCodecConfigurer ->
                                        clientCodecConfigurer.defaultCodecs().maxInMemorySize(1000000))
                        .build())
                .build();
    }

    public byte[] getImageOfMap(List<CoordinatesMapAPI> coordinatesMapAPIList) {
        if (coordinatesMapAPIList.isEmpty()) {
            return new byte[0];
        }
        String requestParams = MapsAPI.getCoords(coordinatesMapAPIList);
        byte[] image;
        try {
            String http = ("https://www.mapquestapi.com/staticmap/v5/map?locations=" + requestParams + "&Rochester,NY&size=170,30@2x&key=9GECRq8QYifLKMgRw1g2GvMNzLWeHwyA");
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
