import axios from 'axios'

class AirlineController {

    getAirline() {
        return axios.get();
    }

}

export default new AirlineController()
