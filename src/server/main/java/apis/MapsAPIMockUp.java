package apis;

import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.maps.CoordinatesMapAPI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class MapsAPIMockUp implements MapsAPI {

    private WebClient webClient;
    public MapsAPIMockUp() {
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

    public byte[] getImageOfMap(List<CoordinatesMapAPI> coordinatesMapAPIList) {
        File mockImage= new File("src/server/main/resources/muc&ber.jpg");
        try {
            byte[] mockImageArray = Files.readAllBytes(mockImage.toPath());
            return mockImageArray;
        } catch (IOException e) {
            return new byte[0];
        }
    }
}
