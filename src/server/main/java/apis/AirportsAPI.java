package apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.api.airport.Airport;

import java.util.List;

public interface AirportsAPI {

    List<Airport> getAirportsByString(String airportSearch);

    static List<Airport> jsonStringToJavaClass(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Airport> airports;
            airports = objectMapper.readValue(jsonString, new com.fasterxml.jackson.core.type.TypeReference<List<Airport>>(){});
            return airports;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
