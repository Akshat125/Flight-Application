package apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.api.airportNameIcao.IcaoMappingNameApiUtil;

/**
 * Documentation: https://airlabs.co/docs/
 */
public interface AirportNameApi {

    /**
     * @param airportICAO takes the ICAO_Code of a given Airport and returns a new Object of Icao2NameApiUtil, which contains the name of the Airport
     * @return Icao2NameApiUtil
     */
    IcaoMappingNameApiUtil getAirportData(String airportICAO);

    /**
     * @param jsonString takes a Jason String and return a new Object of Icao2NameApiUtil
     * @return Icao2NameApiUtil
     */
    static IcaoMappingNameApiUtil jsonStringToJavaClass(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonString, IcaoMappingNameApiUtil.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
