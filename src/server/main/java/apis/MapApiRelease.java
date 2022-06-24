package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.maps.CoordinatesMapApiUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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

    public byte[] getImageOfMap(List<CoordinatesMapApiUtil> coordinatesMapAPIList) {
        if (coordinatesMapAPIList.isEmpty()) {
            return new byte[0];
        }
        String zoomFactor = "";
        if(coordinatesMapAPIList.size() == 1){
            zoomFactor = "&zoom=6";
        }
        String requestParams = MapApi.getCoords(coordinatesMapAPIList);
        byte[] image;
        try {
            String http = ("https://www.mapquestapi.com/staticmap/v5/map?locations=" + requestParams + zoomFactor + "&size=600,400@2x&key=9GECRq8QYifLKMgRw1g2GvMNzLWeHwyA");
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
