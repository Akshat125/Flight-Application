package apis;

import utils.api.airline.AirlineApiUtil;
import utils.api.airlinename.AirlineNameApiUtil;
import utils.api.airport.AirportApiUtil;
import utils.api.airportNameIcao.IcaoMappingNameApiUtil;
import utils.api.maps.CoordinatesMapApiUtil;
import utils.api.weather.WeatherApiUtil;

import java.util.List;

public class FassadeApi {

    /**
     * This classes use the Fassade-Pattern to access the different versions of the current API-Implementations
     * the variable USE_MOCKUP can be set to
     * true -> ue the Mockup-Versions of the APIs
     * or
     * false -> to use the non-mocked implementation
     */
    private static final boolean USE_MOCKUP = true;

    private AirlineApi airlinesAPI;
    private MapApi mapsAPI;
    private WeatherApi weatherAPI;
    private AirportApi airportsAPI;
    private AirportNameApi airportNameAPI;
    private AirlineNameApi airlineNameApi;

    public FassadeApi() {
        if (USE_MOCKUP) {
            this.airlinesAPI = new AirlineApiMockUp();
            this.mapsAPI = new MapApiMockUp();
            this.weatherAPI = new WeatherApiMockUp();
            this.airportNameAPI = new AirportNameApiMockUp();
            this.airlineNameApi = new AirlineNameApiMockUp();
        } else {
            this.airlinesAPI = new AirlineApiRelease();
            this.mapsAPI = new MapApiRelease();
            this.weatherAPI = new WeatherApiRelease();
            this.airportNameAPI = new AirportNameApiRelease();
            this.airlineNameApi = new AirlineNameApiRelease();
        }
        // no restrictions, can be used right now
        this.airportsAPI = new AirportApiRelease();
    }

    /**
     * @param searchString search for a String query
     * @return List<AirportApiUtil> || and returns a List of Airports, which are related to that query
     */
    public List<AirportApiUtil> searchForAirport(String searchString) {
        return this.airportsAPI.getAirportsByString(searchString);
    }

    /**
     * @param lon takes the Longitude
     *            and
     * @param lat takes the Latitude
     * @return WeatherApiUtil || and returns Weather-Data for the next 5 Days in 3h steps
     */
    public WeatherApiUtil getWeatherByCoordinates(double lon, double lat) {
        if (lon > 180 || lon < -180 || lat > 90 || lat < -90) {
            return null;
        }
        return weatherAPI.getWeatherByCoordinates(lon, lat);
    }

    /**
     * @param coordinates takes a List of Coordinates
     * @return byte[] || and returns a static Map/Image, showing all the Markers, which were given by teh Coordinates
     */
    public byte[] getMapByIATA(List<CoordinatesMapApiUtil> coordinates) {
        if (coordinates == null || coordinates.isEmpty()) {
            return new byte[0];
        }
        return mapsAPI.getImageOfMap(coordinates);
    }

    /**
     * @param fromIata takes the IATA_CODE of a given departure Airport
     *                 and
     * @param toIata   takes the IATA_CODE of a given arrival Airport
     * @return AirlineApiUtil || and returns a new Object of AirlineApiUtil, which contains a List of all flights available
     */
    public AirlineApiUtil getFlightDataByIata(String fromIata, String toIata) {
        return airlinesAPI.getFlightData(fromIata, toIata);
    }

    /**
     * @param icao takes the ICAO_CODE of a given Airport
     * @return Icao2NameApiUtil || and returns a new Object of Icao2NameApiUtil, witch contains the name of the Airport
     */
    public IcaoMappingNameApiUtil getNameAirport(String icao) {
        return airportNameAPI.getAirportData(icao);
    }

    /**
     * @param arinlineIcao_code takes the ICAO_CODE of a given Airline
     * @return AirlineNameApiUtil || and returns a new Object of AirlineNameApiUtil, wich contains the name of the Airline
     */
    public AirlineNameApiUtil getAirlineNameByIcao(String arinlineIcao_code) {
        return airlineNameApi.getAirlineName(arinlineIcao_code);
    }
}
