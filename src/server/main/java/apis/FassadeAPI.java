package apis;

import utils.api.airport.AirportAPI;
import utils.api.airport.Coordinates;
import utils.api.maps.CoordinatesMapAPI;
import utils.api.weather.WeatherAPI;

import java.util.List;

public class FassadeAPI {

    // switch between mockup and release version
    private static final boolean USE_MOCKUP = true;

    private AirlinesAPI airlinesAPI;
    private MapsAPI mapsAPI;
    private WeathersAPI weatherAPI;
    private AirportsAPI airportsAPI;

    public FassadeAPI(){
        if(USE_MOCKUP){
            this.airlinesAPI = new AirlinesAPIMockUp();
            this.mapsAPI = new MapsAPIMockUp();
            this.weatherAPI = new WeathersAPIMockUp();
        }else{
            this.airlinesAPI = new AirlinesAPIRelease();
            this.mapsAPI = new MapsAPIRelease();
            this.weatherAPI = new WeathersAPIRelease();
        }
        // no restrictions, can be used right now
        this.airportsAPI = new AirportsAPIRelease();
    }

    public List<AirportAPI> searchForAirport(String searchString){
        return this.airportsAPI.getAirportsByString(searchString);
    }

    public WeatherAPI getWeatherByCoordinates(double lon, double lat) {
        if(lon > 180 || lon < -180 || lat > 90 || lat < -90){
            return null;
        }
        return weatherAPI.getWeatherByCoordinates(lon,lat);
    }

    public byte[] getMapByIATA(List<CoordinatesMapAPI> coordinates){
        if(coordinates == null || coordinates.isEmpty()){
            return new byte[0];
        }
        return mapsAPI.getImageOfMap(coordinates);
    }
}
