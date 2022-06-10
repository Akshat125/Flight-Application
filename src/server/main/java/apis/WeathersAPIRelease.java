package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.weather.WeatherAPI;
import java.net.URI;
import java.net.URISyntaxException;

public class WeathersAPIRelease implements WeathersAPI {
    // Source: https://openweathermap.org/
    // key = ac41346439bcc8dd543aedd632306b4c
    // https://api.openweathermap.org/data/2.5/forecast?lat=48.353004&lon=11.790143&unit=metric&cnt=40&lang=de&appid=ac41346439bcc8dd543aedd632306b4c

    private WebClient webClient;

    public WeathersAPIRelease() {
        webClient = WebClient.builder().baseUrl("https://api.openweathermap.org/data/2.5/forecast?").defaultHeader(MediaType.APPLICATION_JSON_VALUE).build();
    }

    public WeatherAPI getWeatherByCoordinates(double lon, double lat) {
        try {
            String res = webClient.get()
                    .uri(new URI("https://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lon + "&unit=metric&cnt=40&lang=de&appid=ac41346439bcc8dd543aedd632306b4c"))
                    .retrieve()
                    .bodyToMono(String.class)
                    .onErrorStop()
                    .block();

            System.out.println(WeathersAPI.jsonStringToJavaClass(res));
            return WeathersAPI.jsonStringToJavaClass(res);
        } catch (URISyntaxException e) {
            return null;
        }
    }

}
