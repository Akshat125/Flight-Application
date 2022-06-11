import axios from 'axios'

const MAP_API_BASE_URL = "http://localhost:8080/getMapImage";

class MapsController {

    // @Param: String IATAs. NOTE: multiple IATA codes must be seperated by “&”
    // @ret: JPEG-Image (try it in browser - the image will appear)

    getMap(...iatas) {
        var query = iatas.reduce((previous, next) => previous + "&" + next);
        return axios.get(query);
    }

}

export default new MapsController()
