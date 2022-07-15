package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.poiTripMap.PoiTripMapUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Documentation: https://opentripmap.io/docs
 */
public class PoiTripMapApiRelease implements PoiTripMapApi {

    private WebClient webClient;

    public PoiTripMapApiRelease() {
        webClient = WebClient.builder().defaultHeader(MediaType.APPLICATION_JSON_VALUE).build();
    }

    /**
     * @param lon takes the Longitude
     *            and
     * @param lat takes the Latitude
     * @return PoiTripMapUtil || and returns PointOfInterest-Data
     */
    @Override
    public List<PoiTripMapUtil> getPOIsByCoordinates(double lon, double lat) {
        try {
            // https://api.opentripmap.com/0.1/en/places/radius?radius=5000&lon=11.57549&lat=48.13743&kinds=cultural%2Carchitecture&format=json&rate=1&limit=10&apikey=5ae2e3f221c38a28845f05b605dbd950bdd99b38cb834b3b9aa9a64e
            String res = webClient.get()
                    .uri(new URI("https://api.opentripmap.com/0.1/en/places/radius?radius=15000&lon=" + lon + "&lat=" + lat + "&kinds=cultural&format=json&rate=1&limit=10&apikey=" + ApiKey.POI_KEY.getKEY()))
                    .retrieve()
                    .bodyToMono(String.class)
                    .onErrorStop()
                    .block();
            return PoiTripMapApi.jsonStringToJavaClass(res);
        } catch (URISyntaxException e) {
            return null;
        }
    }
}
