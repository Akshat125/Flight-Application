import axios from 'axios'

const POI_API_BASE_URL = "http://localhost:8080/getPoi";

class POIController {

    getPoi(iata) {
        return (
            axios.get(POI_API_BASE_URL + "/" + iata)
            .then(response =>   {
                return response.data;
            })
        );
    }

}

export default new POIController()
