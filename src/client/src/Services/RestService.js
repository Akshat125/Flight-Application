import axios from 'axios';

const USER_API_BASE_URL = "http://localhost:8080/"; //TODO: tbd
// TODO: url for Lufthansa, Google Maps API
class RestService {
    getUserData() {
        return axios.get(USER_API_BASE_URL);
    }

    getUserById(userId) {
        return axios.get(USER_API_BASE_URL + '/' + userId);
    }

    postUserData(user){
        return axios.post(USER_API_BASE_URL, user);
    }
}

export default new RestService()
