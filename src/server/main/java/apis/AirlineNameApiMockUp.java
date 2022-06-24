package apis;

import utils.api.airlinename.AirlineNameApiUtil;
import utils.api.airlinename.Response;

public class AirlineNameApiMockUp implements AirlineNameApi {


    @Override
    public AirlineNameApiUtil getAirlineName(String airline_icao) {
        AirlineNameApiUtil airlineNameApiUtil = new AirlineNameApiUtil();
        airlineNameApiUtil.getResponse().add(new Response("DLH", "LH", "Lufthansa"));
        return airlineNameApiUtil;
    }
}
