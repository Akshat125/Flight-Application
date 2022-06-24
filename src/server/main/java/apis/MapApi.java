package apis;

import utils.api.maps.CoordinatesMapApiUtil;

import java.util.List;

public interface MapApi {

    // Source: https://developer.mapquest.com/
    // Docs: https://developer.mapquest.com/documentation/static-map-api/v5/map

    byte[] getImageOfMap(List<CoordinatesMapApiUtil> coordinatesMapAPIList);

    static String getCoords(List<CoordinatesMapApiUtil> coordinatesMapAPIList){

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
