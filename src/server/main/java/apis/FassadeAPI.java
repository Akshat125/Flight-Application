package apis;

import utils.api.airline.AirlineAPI;
import utils.api.airport.AirportAPI;
import utils.api.airportNameIcao.Icao2NameAPI;
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
    private apis.AirportNameAPI airportNameAPI;

    public FassadeAPI(){
        if(USE_MOCKUP){
            this.airlinesAPI = new AirlinesAPIMockUp();
            this.mapsAPI = new MapsAPIMockUp();
            this.weatherAPI = new WeathersAPIMockUp();
            this.airportNameAPI = new AirportNameAPIMockUp();
        }else{
            this.airlinesAPI = new AirlinesAPIRelease();
            this.mapsAPI = new MapsAPIRelease();
            this.weatherAPI = new WeathersAPIRelease();
            this.airportNameAPI = new AirportNameAPIRelease();
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

    public AirlineAPI getFlightDataByIata(String fromIata, String toIata){
        return airlinesAPI.getFlightData(fromIata,toIata);
    }

    public Icao2NameAPI getNameAirport(String icao){
        return airportNameAPI.getAirportData(icao);
    }
}
