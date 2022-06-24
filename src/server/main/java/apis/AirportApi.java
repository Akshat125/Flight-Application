package apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.api.airport.AirportApiUtil;

import java.util.List;

public interface AirportApi {

    List<AirportApiUtil> getAirportsByString(String airportSearch);

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
