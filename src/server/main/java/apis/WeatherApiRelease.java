package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.weather.WeatherApiUtil;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Documentation: https://openweathermap.org/forecast5
 */
public class WeatherApiRelease implements WeatherApi {

    private WebClient webClient;

    public WeatherApiRelease() {
        webClient = WebClient.builder().defaultHeader(MediaType.APPLICATION_JSON_VALUE).build();
    }

    /**
     * @param lon takes the Longitude
     *            and
     * @param lat takes the Latitude
     * @return WeatherApiUtil || and returns Weather-Data for the next 5 Days in 3h steps
     */
    public WeatherApiUtil getWeatherByCoordinates(double lon, double lat) {
        try {
            String res = webClient.get()
                    .uri(new URI("https://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lon + "&unit=metric&cnt=40&lang=de&appid=" + ApiKey.WEATHER_KEY))
                    .retrieve()
                    .bodyToMono(String.class)
                    .onErrorStop()
                    .block();

            System.out.println(WeatherApi.jsonStringToJavaClass(res));
            return WeatherApi.jsonStringToJavaClass(res);
        } catch (URISyntaxException e) {
            return null;
        }
    }

}
