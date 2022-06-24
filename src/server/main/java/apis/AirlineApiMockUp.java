package apis;

import utils.api.airline.AirlineApiUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This mockApplication returns flights between Munic and Berlin
 */

public class AirlineApiMockUp implements AirlineApi {

    // Source: https://aviationstack.com/
    // https://aviationstack.com/documentation


    // München: IATA-Code: MUC, IATA-Code: BER

    public AirlineApiMockUp() {
    }

/*
    public static void main(String[] args) {
        AirlinesAPIMockUp mock = new AirlinesAPIMockUp();
    }

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
