package apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.api.airline.FlightDataAPI;
import utils.api.maps.CoordinatesMapAPI;

import java.util.List;

public interface MapsAPI {

    // Source: https://developer.mapquest.com/
    // Docs: https://developer.mapquest.com/documentation/static-map-api/v5/map

    byte[] getImageOfMap(List<CoordinatesMapAPI> coordinatesMapAPIList);

    static String getCoords(List<CoordinatesMapAPI> coordinatesMapAPIList){

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < coordinatesMapAPIList.size(); i++) {
            sb.append(coordinatesMapAPIList.get(i).getLatitude());
            sb.append(",");
            sb.append(coordinatesMapAPIList.get(i).getLongitude());
            if(i < coordinatesMapAPIList.size()-1){
                sb.append("%7C%7C");
            }
        }

        return sb.toString();
    }

}
