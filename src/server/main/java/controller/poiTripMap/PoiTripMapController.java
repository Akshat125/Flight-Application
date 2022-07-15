package controller.poiTripMap;

import apis.FassadeApi;
import main.SpringbootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import utils.api.iatacoordinates.IataCoordinatesApiUtil;
import utils.api.iatacoordinates.IataCoordinatesRepository;
import utils.api.poiTripMap.PoiTripMapUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PoiTripMapController {

    private IataCoordinatesRepository iataCoordinatesRepository;
    private FassadeApi fassadeApi;

    public PoiTripMapController() {
        this.fassadeApi = new FassadeApi();
    }

    /**
     * @param stringIATA takes a IATA-Code of a given City
     * @return and returns a List of Points of Interests in the category "culture"
     */
    @GetMapping("/getPoi/{stringIATA}")
    public ResponseEntity<List<PoiTripMapResponse>> getAirports(@PathVariable("stringIATA") String stringIATA) {
        List<PoiTripMapResponse> responseList = new ArrayList<>();
        List<PoiTripMapUtil> poiTripMapList;
        this.iataCoordinatesRepository = SpringbootApplication.getApplicationContext().getBean(IataCoordinatesRepository.class);
        IataCoordinatesApiUtil iataCoordinates = iataCoordinatesRepository.findByIata(stringIATA.toUpperCase(Locale.ROOT));
        if(iataCoordinates == null){
            return ResponseEntity.ok(responseList);
        }else{
            poiTripMapList = fassadeApi.getPoiByCoordinates(iataCoordinates.getLongitude(), iataCoordinates.getLatitude());
            for (PoiTripMapUtil poiTripMapUtil : poiTripMapList) {
                responseList.add(new PoiTripMapResponse(poiTripMapUtil.getName(), poiTripMapUtil.getKinds()));
            }
        }
        return ResponseEntity.ok(responseList);
    }
}
