package apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.api.poiTripMap.PoiTripMapUtil;
import java.util.List;

/**
 * Documentation: https://opentripmap.io/docs
 */
public interface PoiTripMapApi {

    /**
     * @param lon takes the Longitude
     *            and
     * @param lat takes the Latitude
     * @return PoiTripMapUtil || and returns PointOfInterest-Data
     */
    List<PoiTripMapUtil> getPOIsByCoordinates(double lon, double lat);

    /**
     * @param jsonString takes a Jason String and return a new Object of PoiTripMapUtil
     * @return PoiTripMapUtil
     */
    static List<PoiTripMapUtil> jsonStringToJavaClass(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            List<PoiTripMapUtil> poiTripMapUtil;
            poiTripMapUtil = objectMapper.readValue(jsonString, new com.fasterxml.jackson.core.type.TypeReference<>() {
            });
            return poiTripMapUtil;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
