package apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.api.airline.FlightDataAPI;

public interface AirlinesAPI {

    FlightDataAPI getFlightData(String formDep_iata, String toArr_icao);

    static FlightDataAPI jsonStringToJavaClass(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonString, FlightDataAPI.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
