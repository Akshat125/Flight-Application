package apis;

import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.maps.CoordinatesMapApiUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * Documentation: https://developer.mapquest.com/documentation/static-map-api/v5/
 */
public class MapApiMockUp implements MapApi {

    public MapApiMockUp() {
    }

    /**
     * @param coordinatesMapAPIList takes a List of Coordinates
     * @return byte[] and returns the Byte Array/Image of a static Map, showing all Markers of the given Coordinates-List
     */
    public byte[] getImageOfMap(List<CoordinatesMapApiUtil> coordinatesMapAPIList) {
        File mockImage = new File("src/server/main/resources/muc&ber.jpg");
        try {
            return Files.readAllBytes(mockImage.toPath());
        } catch (IOException e) {
            return new byte[0];
        }
    }
}
