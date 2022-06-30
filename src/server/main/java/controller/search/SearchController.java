package controller.search;

import apis.FassadeApi;
import main.SpringbootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import utils.api.airport.AirportApiUtil;
import utils.api.iatacoordinates.IataCoordinatesApiUtil;
import utils.api.iatacoordinates.IataCoordinatesRepository;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SearchController {

    private FassadeApi fassadeAPI;
    private List<AirportApiUtil> airports;
    private List<AirportResponse> airportResponses;
    private IataCoordinatesRepository iataCoordinatesRepository;
    private List<IataCoordinatesApiUtil> iataList;

    private SearchController() {
        this.fassadeAPI = new FassadeApi();
        this.airportResponses = new ArrayList<>();
        this.iataList = new ArrayList<>();
    }

    /**
     * @param searchVariable takes a search Query and returns a List of Airports, which fits the query the best
     * @return List<Airports>
     */
    @GetMapping("/getAirport/{searchString}")
    public ResponseEntity<List<AirportResponse>> getAirports(@PathVariable("searchString") String searchVariable) {
        this.iataCoordinatesRepository = SpringbootApplication.getApplicationContext().getBean(IataCoordinatesRepository.class);
        this.iataList = iataCoordinatesRepository.findAll();
        airportResponses.clear();
        if (searchVariable == null || searchVariable.trim().equals("")) {
            return ResponseEntity.ok(airportResponses);
        } else
            airports = this.fassadeAPI.searchForAirport(searchVariable);
        int maxItemsResponse = Math.min(5, airports.size());
        for (int i = 0; i < maxItemsResponse; i++) {
            if (airports.get(i).getType().equals("city")) {
                airportResponses.add(new AirportResponse(airports.get(i).getName(), airports.get(i).getName(), airports.get(i).getCountry_name(), airports.get(i).getCode()));
            } else {
                airportResponses.add(new AirportResponse(airports.get(i).getName(), airports.get(i).getCity_name(), airports.get(i).getCountry_name(), airports.get(i).getCode()));
            }
            IataCoordinatesApiUtil iataToAdd = new IataCoordinatesApiUtil(airports.get(i).getCode(), airports.get(i).getCoordinates().getLat(), airports.get(i).getCoordinates().getLon());
            if (!(iataList.contains(iataToAdd))) {
                iataCoordinatesRepository.save(iataToAdd);
                iataList.add(iataToAdd);
            }
        }
        return ResponseEntity.ok(airportResponses);
    }


}
