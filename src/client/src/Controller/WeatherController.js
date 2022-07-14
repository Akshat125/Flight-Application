import axios from 'axios'

const WEATHER_API_BASE_URL = "http://localhost:8080/getWeather";

class WeatherController {

    //@Param: String IATA
    /* @ret: List of Weather-Data (40 entries) containing:
             -date (unix UTC)
             -temp (kelvin)
             -tempFeelsLike (kelvin)
             -humidity (%)
             -windspeed (m/s)
             -windDirection (degree)
             -short description
     */
    //TODO convert Kelvin to Celsius using: T(C) = 273 + T(K)

    getWeather(iata) {
        return (
            axios.get(WEATHER_API_BASE_URL + "/" + iata)
            .then(response =>   {
                return response.data;
            })
        );
    }

}

export default new WeatherController()
