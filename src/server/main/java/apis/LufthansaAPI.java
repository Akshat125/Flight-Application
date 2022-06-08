package apis;

import utils.FlightData;

public interface LufthansaAPI {

    FlightData getFlightData(String formDep_iata, String toArr_icao);

}
