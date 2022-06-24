package controller.flight;

import apis.FassadeApi;
import main.SpringbootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.api.airline.AirlineApiUtil;
import utils.api.airportNameIcao.Icao2NameApiUtil;
import utils.api.icaoname.IacoNameRepository;
import utils.api.icaoname.IcaoNameApiUtil;
import utils.flights.Flights;
import utils.flights.FlightsRepository;
import utils.user.User;
import utils.user.UserRepository;
import utils.userflights.UserFlights;
import utils.userflights.UserFlightsRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FlightController {

    private List<Flights> flightList;
    private List<Flights> flightListWhileSurfing;
    private FassadeApi fassadeAPI;
    private AirlineApiUtil flightData;
    private Icao2NameApiUtil airportData;
    private IacoNameRepository iacoNameRepository;
    private Icao2NameApiUtil icao2NameAPI;
    private FlightsRepository flightsRepository;
    private UserRepository userRepository;
    private UserFlightsRepository userFlightsRepository;

    public FlightController() {
        this.flightListWhileSurfing = new ArrayList<>();
        this.flightList = new ArrayList<>();
        this.fassadeAPI = new FassadeApi();
    }

    @GetMapping("/getFlights/{fromIataToIataAtDay}")
    public ResponseEntity<List<Flights>> getFlights(@PathVariable("fromIataToIataAtDay") String fromIataToIata) {
        this.iacoNameRepository = SpringbootApplication.getApplicationContext().getBean(IacoNameRepository.class);
        String[] flightArray = fromIataToIata.split("&");
        // flightArray[0] -> from iata
        // flightArray[1] -> to iata
        // flightArray[2] -> sun/mon/wed/fri/sat/thu/tue
        flightListWhileSurfing.clear();
        if (flightArray.length != 3) {
            return ResponseEntity.ok(flightListWhileSurfing);
        }
        flightData = fassadeAPI.getFlightDataByIata(flightArray[0], flightArray[1]);


        for (int i = 0; i < flightData.getResponse().size(); i++) {
            List<IcaoNameApiUtil> departureAirport = iacoNameRepository.findByIcao(flightData.getResponse().get(i).getDep_icao());
            List<IcaoNameApiUtil> arrivalAirport = iacoNameRepository.findByIcao(flightData.getResponse().get(i).getArr_icao());
            if (departureAirport.isEmpty()) {
                icao2NameAPI = fassadeAPI.getNameAirport(flightData.getResponse().get(i).getDep_icao());
                iacoNameRepository.save(new IcaoNameApiUtil(icao2NameAPI.getResponse().get(0).getIcao_code(), icao2NameAPI.getResponse().get(0).getName()));
                departureAirport.add(new IcaoNameApiUtil(icao2NameAPI.getResponse().get(0).getIcao_code(), icao2NameAPI.getResponse().get(0).getName()));
            }
            if (arrivalAirport.isEmpty()) {
                icao2NameAPI = fassadeAPI.getNameAirport(flightData.getResponse().get(i).getArr_icao());
                iacoNameRepository.save(new IcaoNameApiUtil(icao2NameAPI.getResponse().get(0).getIcao_code(), icao2NameAPI.getResponse().get(0).getName()));
                arrivalAirport.add(new IcaoNameApiUtil(icao2NameAPI.getResponse().get(0).getIcao_code(), icao2NameAPI.getResponse().get(0).getName()));
            }

            if (flightData.getResponse().get(i).getDays().toString().contains(flightArray[2].toLowerCase())) {
                Flights flight = new Flights(flightData.getResponse().get(i).getFlight_number(), "Airline", departureAirport.get(0).getAirportName(), arrivalAirport.get(0).getAirportName(),
                        flightData.getResponse().get(i).getDep_iata(), flightData.getResponse().get(i).getArr_iata(),
                        flightData.getResponse().get(i).getDep_terminals() == null ? "/" : flightData.getResponse().get(i).getDep_terminals().toString(),
                        flightData.getResponse().get(i).getDep_terminals() == null ? "/" : flightData.getResponse().get(i).getArr_terminals().toString(),
                        flightData.getResponse().get(i).getDep_time_utc(), flightData.getResponse().get(i).getDep_time(),
                        flightData.getResponse().get(i).getArr_time_utc(), flightData.getResponse().get(i).getArr_time(), flightData.getResponse().get(i).getDuration());
                flightListWhileSurfing.add(flight);
                flightList.add(flight);
            }
        }

        return ResponseEntity.ok(flightListWhileSurfing);
    }

    @PutMapping("/addFlight/{addFlightByUserAndPasswordAndHashCode}")
    public ResponseEntity<Boolean> addFlight(@PathVariable("addFlightByUserAndPasswordAndHashCode") String addFlightByUserAndPasswordAndHashCode) {
        String[] params = addFlightByUserAndPasswordAndHashCode.split("&and&");
        if (params.length != 3) {
            return ResponseEntity.badRequest().build();
        }
        this.flightsRepository = SpringbootApplication.getApplicationContext().getBean(FlightsRepository.class);
        this.userFlightsRepository = SpringbootApplication.getApplicationContext().getBean(UserFlightsRepository.class);
        this.userRepository = SpringbootApplication.getApplicationContext().getBean(UserRepository.class);
        for (Flights flights : flightList) {
            if (Integer.parseInt(params[2]) == flights.getHashode()) {
                System.out.println("HASH: " + Integer.parseInt(params[2]));
                flightsRepository.save(flights);
                Flights flight = flightsRepository.findByHashode(Integer.parseInt(params[2]));
                if (flight == null) {
                    return ResponseEntity.ok(false);
                }
                User user = userRepository.findUserByNameAndPassword(params[0], params[1]);
                if (user == null) {
                    return ResponseEntity.ok(false);
                }
                userFlightsRepository.save(new UserFlights(user.getID(), flights.getID()));
                return ResponseEntity.ok(true);
            }
        }
        return ResponseEntity.ok(false);
    }

    @DeleteMapping("deleteFlight/{deleteFlightByUserAndPasswordAndHashCode}")
    public ResponseEntity<Boolean> deleteFlight(@PathVariable("deleteFlightByUserAndPasswordAndHashCode") String deleteParams) {
        String[] params = deleteParams.split("&and&");
        this.flightsRepository = SpringbootApplication.getApplicationContext().getBean(FlightsRepository.class);
        this.userFlightsRepository = SpringbootApplication.getApplicationContext().getBean(UserFlightsRepository.class);
        this.userRepository = SpringbootApplication.getApplicationContext().getBean(UserRepository.class);
        if (params.length != 3) {
            return ResponseEntity.badRequest().build();
        }
        try {
            int hash = Integer.parseInt(params[2]);
            User user = userRepository.findUserByNameAndPassword(params[0], params[1]);
            if (user == null) {
                return ResponseEntity.badRequest().build();
            }
            long flightID = flightsRepository.findByHashode(hash).getID();
            long userID = user.getID();
            userFlightsRepository.delete(userFlightsRepository.findUserFlightsByUserIDAndFlightID(userID, flightID));
            flightsRepository.delete(flightsRepository.findByHashode(hash));

        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(true);
    }

}
