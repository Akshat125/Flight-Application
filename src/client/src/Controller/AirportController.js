import axios from 'axios';

const AIRPORT_API_BASE_URL = "http://localhost:8080/getAirport";



class AirportController {

    // @Param: query-String. e.g. "MUC"
    /* @ret: List of Airports/Cities (max. 5) containing:
             -airportName/ cityName
             -nameCity
             -nameCountry
             -IATA-Code of Airport/City
     */

    getAirport(query) {
        axios.get(AIRPORT_API_BASE_URL + "/" + query);
    }

}

export default new AirportController()
