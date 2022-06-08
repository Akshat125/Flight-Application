package apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.api.weather.WeatherAPI;

import java.util.List;

public interface WeathersAPI {

    WeatherAPI getWeatherByCoordinates(double lon, double lat);

    static WeatherAPI jsonStringToJavaClass(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            WeatherAPI weatherAPI;
            weatherAPI = objectMapper.readValue(jsonString, WeatherAPI.class);
            return weatherAPI;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
