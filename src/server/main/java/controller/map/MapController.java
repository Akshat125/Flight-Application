package controller.map;

import apis.FassadeApi;
import main.SpringbootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import utils.api.iatacoordinates.IataCoordinatesApiUtil;
import utils.api.iatacoordinates.IataCoordinatesRepository;
import utils.api.maps.CoordinatesMapApiUtil;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MapController {
    private FassadeApi fassadeAPI;
    private List<IataCoordinatesApiUtil> iataList;
    private IataCoordinatesRepository iataCoordinatesRepository;
    private Iterable<IataCoordinatesApiUtil> iterable;
    List<CoordinatesMapApiUtil> coordinatesList;

    public MapController() {
        this.fassadeAPI = new FassadeApi();
        this.iataList = new ArrayList<>();
        this.coordinatesList = new ArrayList<>();
    }

    @RequestMapping(value = "/getMapImage/{stringIATA}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getMapByIATA(@PathVariable(value = "stringIATA") String stringIATA) {
        String[] listIataRequest = stringIATA.split("&");

        if (listIataRequest.length == 0) {
            return new byte[0];
        }

        this.coordinatesList.clear();
        this.iataCoordinatesRepository = SpringbootApplication.getApplicationContext().getBean(IataCoordinatesRepository.class);
        this.iterable = iataCoordinatesRepository.findAll();
        for (int i = 0; i < iataCoordinatesRepository.count(); i++) {
            iterable.forEach(x -> iataList.add(x));
        }

        for (String s : listIataRequest) {
            for (IataCoordinatesApiUtil iataCoordinatesMapping : iataList) {
                if (iataCoordinatesMapping.getIata().equalsIgnoreCase(s)) {
                    coordinatesList.add(new CoordinatesMapApiUtil(iataCoordinatesMapping.getLatitude(), iataCoordinatesMapping.getLongitude()));
                    break;
                }
            }
        }

        return fassadeAPI.getMapByIATA(coordinatesList);
    }
}
