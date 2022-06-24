package apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.api.weather.WeatherApiUtil;

public interface WeatherApi {

    WeatherApiUtil getWeatherByCoordinates(double lon, double lat);

    static WeatherApiUtil jsonStringToJavaClass(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            WeatherApiUtil weatherAPI;
            weatherAPI = objectMapper.readValue(jsonString, WeatherApiUtil.class);
            return weatherAPI;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
