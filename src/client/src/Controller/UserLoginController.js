import axios from 'axios';

const USER_API_BASE_URL = "";

class UserLoginController {
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

export default new UserLoginController()
