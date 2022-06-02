import axios from 'axios';

const EMPLOYEE_API_BASE_URL = "http://localhost:8080/"; //TODO: tbd
// TODO: url for Lufthansa, Google Maps API
class FlightService {
    getUserData() {
        return axios.get(EMPLOYEE_API_BASE_URL);
    }

    postUserData(employee){
        return axios.post(EMPLOYEE_API_BASE_URL, employee);
    }

}

export default new FlightService()
