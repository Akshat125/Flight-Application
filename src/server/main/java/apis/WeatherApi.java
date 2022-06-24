package apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.api.weather.WeatherApiUtil;

/**
 * Documentation: https://openweathermap.org/forecast5
 */
public interface WeatherApi {

    /**
     * @param lon takes the Longitude
     *            and
     * @param lat takes the Latitude
     * @return WeatherApiUtil || and returns Weather-Data for the next 5 Days in 3h steps
     */
    WeatherApiUtil getWeatherByCoordinates(double lon, double lat);


    /**
     * @param jsonString takes a Jason String and return a new Object of WeatherApiUtil
     * @return WeatherApiUtil
     */
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
