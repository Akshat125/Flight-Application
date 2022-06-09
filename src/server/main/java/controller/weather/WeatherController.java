package controller.weather;


import apis.FassadeAPI;
import main.SpringbootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import utils.api.iatacoordinates.IataCoordinatesMapping;
import utils.api.iatacoordinates.IataCoordinatesRepository;
import utils.api.weather.WeatherAPI;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WeatherController {

    private IataCoordinatesRepository iataCoordinatesRepository;
    private List<IataCoordinatesMapping> iataList;
    private Iterable<IataCoordinatesMapping> iterable;
    private FassadeAPI fassadeAPI;
    private List<WeatherResponse> weatherList;


    public WeatherController(){
        this.iataList = new ArrayList<>();
        this.fassadeAPI = new FassadeAPI();
        weatherList = new ArrayList<>();
    }


    @GetMapping("/getWeather/{searchByIATA}")
    public ResponseEntity<List<WeatherResponse>> getWeather(@PathVariable("searchByIATA") String IATA){
        this.iataCoordinatesRepository =  SpringbootApplication.getApplicationContext().getBean(IataCoordinatesRepository.class);
        weatherList.clear();
        this.iterable = iataCoordinatesRepository.findAll();
        for (int i = 0; i < iataCoordinatesRepository.count(); i++) {
            iterable.forEach(x -> iataList.add(x));
        }
        for (IataCoordinatesMapping iataCoordinatesMapping : iataList) {
            if (iataCoordinatesMapping.getIata().trim().equalsIgnoreCase(IATA.trim())) {
                WeatherAPI weather = fassadeAPI.getWeatherByCoordinates(iataCoordinatesMapping.getLongitude(), iataCoordinatesMapping.getLatitude());
                for (int j = 0; j < weather.getList().size(); j++) {
                    weatherList.add(new WeatherResponse(weather.getList().get(j).getDt(), weather.getList().get(j).getMain().getTemp(),
                            weather.getList().get(j).getMain().getFeels_like(), weather.getList().get(j).getMain().getHumidity(),
                            weather.getList().get(j).getWind().getSpeed(), weather.getList().get(j).getWind().getDeg(),
                            weather.getList().get(j).getWeather().get(0).getDescription()));
                }
                return ResponseEntity.ok(weatherList);
            }
        }
        return ResponseEntity.noContent().build();
    }
}
