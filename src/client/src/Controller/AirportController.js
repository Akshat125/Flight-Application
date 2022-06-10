import axios from 'axios';

const AIRPORT_API_BASE_URL = "http://localhost:8080/getAirport";



class AirportController {

    //@Param: query-String. e.g. "MUC"
    //@ret: list of object {airportName: String, nameCity: String, nameCountry: String, iata: String}
    getAirport(query) {
        axios.get(AIRPORT_API_BASE_URL + "/" + query)
    }

}

export default new AirportController()
