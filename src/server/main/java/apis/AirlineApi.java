package apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.api.airline.AirlineApiUtil;

/**
 * Documentation: https://aviationstack.com/ || https://aviationstack.com/documentation
 */
public interface AirlineApi {

    /**
     * @param formDep_iata takes a corresponding IATA_CODE of a given departure Airport
     * @param toArr_iata   takes a corresponding IATA_CODE of a given arrival Airport
     * @return AirlineApiUtil
     */
    AirlineApiUtil getFlightData(String formDep_iata, String toArr_iata);


    /**
     * @param jsonString takes a Jason String and return a new Object of AirlineApiUtil
     * @return AirlineApiUtil
     */
    static AirlineApiUtil jsonStringToJavaClass(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonString, AirlineApiUtil.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
