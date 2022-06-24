package apis;

import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.maps.CoordinatesMapApiUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class MapApiMockUp implements MapApi {

    private WebClient webClient;
    public MapApiMockUp() {
        webClient = WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder().codecs(
                                clientCodecConfigurer ->
                                        clientCodecConfigurer.defaultCodecs().maxInMemorySize(10000000))
                        .build())
                .build();
    }

    /*
    public static void main(String[] args) {
        MapsAPIMockUp mapsAPIMockUp = new MapsAPIMockUp();
        //System.out.println(Arrays.toString(mapsAPIMockUp.getImageOfMap(null)));
    }
     */

    public byte[] getImageOfMap(List<CoordinatesMapApiUtil> coordinatesMapAPIList) {
        File mockImage= new File("src/server/main/resources/muc&ber.jpg");
        try {
            return Files.readAllBytes(mockImage.toPath());
        } catch (IOException e) {
            return new byte[0];
        }
    }
}
