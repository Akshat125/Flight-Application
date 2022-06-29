package apis;

import utils.api.airportNameIcao.IcaoMappingNameApiUtil;

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
    public IcaoMappingNameApiUtil getAirportData(String airportICAO) {
        return new IcaoMappingNameApiUtil(null, null, null);
    }
}
