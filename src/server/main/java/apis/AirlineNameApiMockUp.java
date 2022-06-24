package apis;

import utils.api.airlinename.AirlineNameApiUtil;
import utils.api.airlinename.Response;

/**
 * Documentation: https://airlabs.co/docs/
 */
public class AirlineNameApiMockUp implements AirlineNameApi {

    /**
     * @param airline_icao takes the ICAO_CODE of a given Airline and return the corresponding Airline name/AirlineNameApiUtil
     * @return AirlineNameApiUtil
     */
    @Override
    public AirlineNameApiUtil getAirlineName(String airline_icao) {
        AirlineNameApiUtil airlineNameApiUtil = new AirlineNameApiUtil();
        airlineNameApiUtil.getResponse().add(new Response("DLH", "LH", "Lufthansa"));
        return airlineNameApiUtil;
    }
}
