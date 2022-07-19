package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
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
        webClient = WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder().codecs(
                                clientCodecConfigurer ->
                                        clientCodecConfigurer.defaultCodecs().maxInMemorySize(10000000))
                        .build())
                .build();
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
                    .uri(new URI("https://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lon + "&unit=metric&cnt=40&lang=en&appid=" + ApiKey.WEATHER_KEY.getKEY()))
                    .retrieve()
                    .bodyToMono(String.class)
                    .onErrorStop()
                    .block();
            return WeatherApi.jsonStringToJavaClass(res);
        } catch (URISyntaxException e) {
            return null;
        }
    }

}
