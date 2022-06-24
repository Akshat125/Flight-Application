package apis;

import utils.api.airportNameIcao.Icao2NameApiUtil;

/**
 * Documentation: https://airlabs.co/docs/
 */
public class AirportNameApiMockUp implements AirportNameApi {

    public AirportNameApiMockUp() {
    }

    /**
     * @param airportICAO takes the ICAO_Code of a given Airport and returns a new Object of Icao2NameApiUtil, which contains the name of the Airport
     * @return Icao2NameApiUtil
     */
    @Override
    public Icao2NameApiUtil getAirportData(String airportICAO) {
        return new Icao2NameApiUtil(null, null, null);
    }
}
