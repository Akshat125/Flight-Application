package apis;

import utils.api.maps.CoordinatesMapApiUtil;

import java.util.List;

/**
 * Documentation: https://developer.mapquest.com/documentation/static-map-api/v5/
 */
public interface MapApi {

    // Source: https://developer.mapquest.com/
    // Docs: https://developer.mapquest.com/documentation/static-map-api/v5/map

    /**
     * @param coordinatesMapAPIList takes a List of Coordinates
     * @return byte[] and returns the Byte Array/Image of a static Map, showing all Markers of the given Coordinates-List
     */
    byte[] getImageOfMap(List<CoordinatesMapApiUtil> coordinatesMapAPIList);

    /**
     * @param coordinatesMapAPIList takes a List of Coordinates and returns its String representation for the API-get-request
     * @return String for get-request
     */
    static String getCoords(List<CoordinatesMapApiUtil> coordinatesMapAPIList) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < coordinatesMapAPIList.size(); i++) {
            sb.append(coordinatesMapAPIList.get(i).getLatitude());
            sb.append(",");
            sb.append(coordinatesMapAPIList.get(i).getLongitude());
            if (i < coordinatesMapAPIList.size() - 1) {
                sb.append("%7C%7C");
            }
        }

        return sb.toString();
    }
}
