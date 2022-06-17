import axios from 'axios'

const AIRLINE_GET_API_BASE_URL = "http://localhost:8080/getFlights"
const AIRLINE_PUT_API_BASE_URL = "http://localhost:8080/addFlight"
const AIRLINE_DELETE_API_BASE_URL = "http://localhost:8080/deleteFlight"
const AIRLINE_POST_API_BASE_URL = "http://localhost:8080/login"

class AirlineController {

    // @param fromIata & toIata
    /* @ret: List of all flights from a given Iata to a given Iata at a given day
             days are: sun, mon, wed, fri, sat, thu, tue,
    */
    /* e.g. for flight attributes:
    {
    "flightNumber":"1586",
    "airline":"Airline",
    "departureAirport":"Munich International Airport",
    "arrivalAirport":"Berlin Brandenburg Airport",
    "departureIata":"MUC",
    "arrivalIata":"BER",
    "departureTerminal":"[2]",
    "arrivalTerminal":"[1, T1]",
    "arrivalTimezone":"arrTimezone",
    "departureTimezone":"depTimezone",
    "departureTimeInUTC":"09:00",
    "departureTime":"11:00",
    "arrivalTimeInUTC":"10:05",
    "arrivalTime":"12:05",
    "duration":65,
    "hashode":1078481382,
    "id":0}
     */

    getFLights(fromIata, toIata) {
        return axios.get(AIRLINE_GET_API_BASE_URL + "/" + fromIata + "&and&" + toIata);
    }

    // @param: username &and& password &and& hashCode
    /* @return:
       -> 400: something went wrong
       -> true: flight exists
       -> false: flight doesn't exist
     */
    putFlight(username, password, flightHashCode) {
        return axios.put(AIRLINE_PUT_API_BASE_URL + "/" + username + "&and&" + password + "&and&" + flightHashCode);
    }

    // @param: username &and& password &and& hashCode
    /* @return:
       -> 400: something went wrong
       else -> true: flight exists
       else -> false: flight doesn't exist
     */

    deleteFlight(username, password, flightHashCode) {
        return axios.delete(AIRLINE_DELETE_API_BASE_URL + "/" + username + "&and&" + password + "&and&" + flightHashCode);
    }

    // @param: login information for a specific user := username &and& password
    /* @return:
       -> 400: something went wrong
       else -> list of flights corresponding to the user
     */

    postUserFlights (username, password) {
        return axios.post(AIRLINE_POST_API_BASE_URL + "/" + username + "&and&" + password);
    }

}

export default new AirlineController()
