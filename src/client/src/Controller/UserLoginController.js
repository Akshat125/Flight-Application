import axios from 'axios';

const USER_PUT_API_BASE_URL = "http://localhost:8080/createUser";

class UserLoginController {
    // @param: username &and& password
    // @return: 400 if something went wrong else a new user
    putUser(username, password) {
        return axios.post(USER_PUT_API_BASE_URL + "/" + username + "&and&" + password);
    }
}

export default new UserLoginController()
