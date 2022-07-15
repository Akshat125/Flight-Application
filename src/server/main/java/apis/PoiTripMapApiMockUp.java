package apis;

import utils.api.poiTripMap.PoiTripMapUtil;
import java.util.List;

/**
 * Documentation: https://opentripmap.io/docs
 */
public class PoiTripMapApiMockUp implements PoiTripMapApi {

    private final String mockJsonString;

    public PoiTripMapApiMockUp() {
        this.mockJsonString = "[{\"name\":\"Galerie Fred Jahn\",\"kinds\":\"cultural,museums,interesting_places,art_galleries\"},{\"name\":\"Rennert-Saal / Bayerische Staatsoper\",\"kinds\":\"cultural,theatres_and_entertainments,interesting_places,other_theatres\"},{\"name\":\"Hofspielhaus\",\"kinds\":\"theatres_and_entertainments,cultural,interesting_places,other_theatres\"},{\"name\":\"National Theatre Munich\",\"kinds\":\"cultural,theatres_and_entertainments,interesting_places,opera_houses\"},{\"name\":\"Galerie Heiner Friedrich\",\"kinds\":\"cultural,museums,interesting_places,art_galleries\"},{\"name\":\"Wolfsbrunnen\",\"kinds\":\"fountains,historic,monuments_and_memorials,urban_environment,cultural,interesting_places,sculptures,monuments\"},{\"name\":\"Alte Münze\",\"kinds\":\"cultural,museums,interesting_places,other_museums\"},{\"name\":\"Residenztheater\",\"kinds\":\"cultural,theatres_and_entertainments,interesting_places,other_theatres\"},{\"name\":\"Bonbonniere\",\"kinds\":\"theatres_and_entertainments,cultural,interesting_places,other_theatres\"},{\"name\":\"Galerie Rieder\",\"kinds\":\"cultural,museums,interesting_places,art_galleries\"}]";
    }

    /**
     * @param lon takes the Longitude
     *            and
     * @param lat takes the Latitude
     * @return PoiTripMapUtil || and returns PointOfInterest-Data
     */
    @Override
    public List<PoiTripMapUtil> getPOIsByCoordinates(double lon, double lat) {
        return PoiTripMapApi.jsonStringToJavaClass(this.mockJsonString);
    }
}
