package apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.api.airport.AirportAPI;

import java.util.List;

public interface AirportsAPI {

    List<AirportAPI> getAirportsByString(String airportSearch);

    static List<AirportAPI> jsonStringToJavaClass(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<AirportAPI> airports;
            airports = objectMapper.readValue(jsonString, new com.fasterxml.jackson.core.type.TypeReference<List<AirportAPI>>(){});
            return airports;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
