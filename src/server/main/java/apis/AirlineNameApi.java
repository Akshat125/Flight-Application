package apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.api.airlinename.AirlineNameApiUtil;

/**
 * Documentation: https://airlabs.co/docs/
 */
public interface AirlineNameApi {

    /**
     * @param airline_icao takes the ICAO_CODE of a given Airline and return the corresponding Airline name/AirlineNameApiUtil
     * @return AirlineNameApiUtil
     */
    AirlineNameApiUtil getAirlineName(String airline_icao);

    /**
     * @param jsonString takes a Jason String and return a new Object of AirlineNameApiUtil
     * @return AirlineNameApiUtil
     */
    static AirlineNameApiUtil jsonStringToJavaClass(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonString, AirlineNameApiUtil.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
