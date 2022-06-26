package apis;

import utils.api.airline.AirlineApiUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Documentation: https://aviationstack.com/ || https://aviationstack.com/documentation
 */
public class AirlineApiMockUp implements AirlineApi {

    public AirlineApiMockUp() {
    }

    /**
     * @param formDep_iata takes a corresponding IATA_CODE of a given departure Airport
     * @param toArr_iata   takes a corresponding IATA_CODE of a given arrival Airport
     * @return AirlineApiUtil
     */
    public AirlineApiUtil getFlightData(String formDep_iata, String toArr_iata) {
        try {
            return AirlineApi.jsonStringToJavaClass(Files.readString(Path.of("src/server/main/resources/muc&ber_mock")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return AirlineApi.jsonStringToJavaClass("");
    }
}
