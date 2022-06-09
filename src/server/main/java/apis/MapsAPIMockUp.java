package apis;

import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.maps.CoordinatesMapAPI;
import java.util.List;

public class MapsAPIMockUp implements MapsAPI {

    private WebClient webClient;
    public MapsAPIMockUp() {
        webClient = WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder().codecs(
                                clientCodecConfigurer ->
                                        clientCodecConfigurer.defaultCodecs().maxInMemorySize(1000000))
                        .build())
                .build();
    }

    /*
    public static void main(String[] args) {
        MapsAPIMockUp mapsAPIMockUp = new MapsAPIMockUp();
        //System.out.println(Arrays.toString(mapsAPIMockUp.getImageOfMap(null)));
    }
     */

    public byte[] getImageOfMap(List<CoordinatesMapAPI> coordinatesMapAPIList) {
        return new byte[0]; // no mockup possible (file is to large otherwise..
    }
}
