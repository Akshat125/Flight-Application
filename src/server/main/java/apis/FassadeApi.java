package apis;

import utils.api.airline.AirlineApiUtil;
import utils.api.airport.AirportApiUtil;
import utils.api.airportNameIcao.Icao2NameApiUtil;
import utils.api.maps.CoordinatesMapApiUtil;
import utils.api.weather.WeatherApiUtil;

import java.util.List;

public class FassadeApi {

    // switch between mockup and release version
    private static final boolean USE_MOCKUP = true;

    private AirlineApi airlinesAPI;
    private MapApi mapsAPI;
    private WeatherApi weatherAPI;
    private AirportApi airportsAPI;
    private AirportNameApi airportNameAPI;

    public FassadeApi(){
        if(USE_MOCKUP){
            this.airlinesAPI = new AirlineApiMockUp();
            this.mapsAPI = new MapApiMockUp();
            this.weatherAPI = new WeatherApiMockUp();
            this.airportNameAPI = new AirportNameApiMockUp();
        }else{
            this.airlinesAPI = new AirlineApiRelease();
            this.mapsAPI = new MapApiRelease();
            this.weatherAPI = new WeatherApiRelease();
            this.airportNameAPI = new AirportNameApiRelease();
        }
        // no restrictions, can be used right now
        this.airportsAPI = new AirportApiRelease();
    }

    public List<AirportApiUtil> searchForAirport(String searchString){
        return this.airportsAPI.getAirportsByString(searchString);
    }

    public WeatherApiUtil getWeatherByCoordinates(double lon, double lat) {
        if(lon > 180 || lon < -180 || lat > 90 || lat < -90){
            return null;
        }
        return weatherAPI.getWeatherByCoordinates(lon,lat);
    }

    public byte[] getMapByIATA(List<CoordinatesMapApiUtil> coordinates){
        if(coordinates == null || coordinates.isEmpty()){
            return new byte[0];
        }
        return mapsAPI.getImageOfMap(coordinates);
    }

    public AirlineApiUtil getFlightDataByIata(String fromIata, String toIata){
        return airlinesAPI.getFlightData(fromIata,toIata);
    }

    public Icao2NameApiUtil getNameAirport(String icao){
        return airportNameAPI.getAirportData(icao);
    }
}
