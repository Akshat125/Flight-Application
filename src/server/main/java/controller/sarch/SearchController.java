package controller.sarch;

import apis.FassadeAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import utils.api.airport.AirportAPI;

import java.util.ArrayList;
import java.util.List;


@RestController
public class SearchController {

    private FassadeAPI fassadeAPI;
    List<AirportAPI> airports;
    List<AirportResponse> airportResponses;

    private SearchController(){
        this.fassadeAPI = new FassadeAPI();
        this.airportResponses = new ArrayList<>();
    }

    @GetMapping("getAirport/{searchString}")
    public ResponseEntity<List<AirportResponse>> getAirports(@PathVariable("searchString") String searchVariable){
        airportResponses.clear();
        if(searchVariable == null || searchVariable.trim().equals("")){
            return ResponseEntity.badRequest().build();
        }else
            airports = this.fassadeAPI.searchForAirport(searchVariable);
        int maxItemsResponse = Math.min(5,airports.size());
        for (int i = 0; i < maxItemsResponse; i++) {
            airportResponses.add(new AirportResponse(airports.get(i).getName(),airports.get(i).getCity_name(),airports.get(i).country_name,airports.get(i).code));
        }
            return ResponseEntity.ok(airportResponses);
    }


}
