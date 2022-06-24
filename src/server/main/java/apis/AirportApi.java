package apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.api.airport.AirportApiUtil;

import java.util.List;

/**
 * Documentation: https://support.travelpayouts.com/
 */
public interface AirportApi {

    /**
     * @param airportSearch takes a search Query and returns a List of all Airports, which are related to that query
     * @return List<AirportApiUtil>
     */
    List<AirportApiUtil> getAirportsByString(String airportSearch);


    /**
     * @param jsonString takes a Jason String and return a new Object of List<AirportApiUtil>
     * @return List<AirportApiUtil>
     */
    static List<AirportApiUtil> jsonStringToJavaClass(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<AirportApiUtil> airports;
            airports = objectMapper.readValue(jsonString, new com.fasterxml.jackson.core.type.TypeReference<>() {
            });
            return airports;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
