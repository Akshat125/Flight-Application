package apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.api.airlinename.AirlineNameApiUtil;

public interface AirlineNameApi {

    AirlineNameApiUtil getAirlineName(String airline_icao);

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
