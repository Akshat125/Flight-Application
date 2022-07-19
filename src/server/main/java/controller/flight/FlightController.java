package controller.flight;

import apis.FassadeApi;
import main.SpringbootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.airlinename.AirlineName;
import utils.airlinename.AirlineNameRepository;
import utils.api.airline.AirlineApiUtil;
import utils.api.airlinename.AirlineNameApiUtil;
import utils.api.airportNameIcao.IcaoMappingNameApiUtil;
import utils.api.icaoname.IacoNameRepository;
import utils.api.icaoname.IcaoNameApiUtil;
import utils.flight.Flight;
import utils.flight.FlightRepository;
import utils.user.User;
import utils.user.UserRepository;
import utils.userflights.UserFlights;
import utils.userflights.UserFlightsRepository;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FlightController {

    private List<Flight> flightList;
    private List<Flight> flightListWhileSurfing;
    private FassadeApi fassadeAPI;
    private AirlineApiUtil flightData;
    private IacoNameRepository iacoNameRepository;
    private IcaoMappingNameApiUtil icao2NameAPI;
    private FlightRepository flightsRepository;
    private UserRepository userRepository;
    private UserFlightsRepository userFlightsRepository;

    private AirlineNameRepository airlineNameRepository;
    private AirlineName airlineName;

    public FlightController() {
        this.flightListWhileSurfing = new ArrayList<>();
        this.flightList = new ArrayList<>();
        this.fassadeAPI = new FassadeApi();
    }

    /**
     * @param fromIataToIata this GET request takes the departure IATA Airport, the arrival IATA Airport and the Day (Mon,Sun,Wed..)
     * @return JSON formatted Flights, which correspond to the given params
     */
    @GetMapping("/getFlights/{fromIataToIataAtDay}")
    public ResponseEntity<List<Flight>> getFlights(@PathVariable("fromIataToIataAtDay") String fromIataToIata) {
        this.iacoNameRepository = SpringbootApplication.getApplicationContext().getBean(IacoNameRepository.class);
        this.airlineNameRepository = SpringbootApplication.getApplicationContext().getBean(AirlineNameRepository.class);
        String[] flightArray = fromIataToIata.split("&");
        String airline_icao;
        AirlineName airlineName;
        AirlineNameApiUtil airlineNameUtil;
        String airlineNameRet;
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
                iacoNameRepository.save(new IcaoNameApiUtil(icao2NameAPI.getResponse().isEmpty()?"Not available":icao2NameAPI.getResponse().get(0).getIcao_code(), icao2NameAPI.getResponse().isEmpty()?"Not available":icao2NameAPI.getResponse().get(0).getName()));
                departureAirport.add(new IcaoNameApiUtil(icao2NameAPI.getResponse().isEmpty()?"Not available":icao2NameAPI.getResponse().get(0).getIcao_code(), icao2NameAPI.getResponse().isEmpty()?"Not available":icao2NameAPI.getResponse().get(0).getName()));
            }
            if (arrivalAirport.isEmpty()) {
                icao2NameAPI = fassadeAPI.getNameAirport(flightData.getResponse().get(i).getArr_icao());
                iacoNameRepository.save(new IcaoNameApiUtil(icao2NameAPI.getResponse().isEmpty()?"Not available":icao2NameAPI.getResponse().get(0).getIcao_code(), icao2NameAPI.getResponse().isEmpty()?"Not available":icao2NameAPI.getResponse().get(0).getName()));
                arrivalAirport.add(new IcaoNameApiUtil(icao2NameAPI.getResponse().isEmpty()?"Not available":icao2NameAPI.getResponse().get(0).getIcao_code(), icao2NameAPI.getResponse().isEmpty()?"Not available":icao2NameAPI.getResponse().get(0).getName()));
            }

            airline_icao = flightData.getResponse().get(i).getAirline_icao();
            airlineName = airlineNameRepository.findAirlineNameByIcaoCode(airline_icao);

            if (airlineName == null) {
                airlineNameUtil = fassadeAPI.getAirlineNameByIcao(airline_icao);
                if (airlineNameUtil == null) {
                    airlineNameRet = airline_icao;
                } else {
                    airlineNameRet = airlineNameUtil.getResponse().isEmpty()?"Not available":airlineNameUtil.getResponse().get(0).getName();
                    airlineNameRepository.save(new AirlineName(airlineNameRet, airline_icao));
                }
            } else {
                airlineNameRet = airlineName.getName();
            }

            if (flightData.getResponse().get(i).getDays().toString().contains(flightArray[2].toLowerCase())) {
                Flight flight = new Flight(flightData.getResponse().get(i).getFlight_number(), airlineNameRet, departureAirport.isEmpty()?"Not available":departureAirport.get(0).getAirportName(), arrivalAirport.isEmpty()?"Not available":arrivalAirport.get(0).getAirportName(),
                        flightData.getResponse().get(i).getDep_iata(), flightData.getResponse().get(i).getArr_iata(),
                        flightData.getResponse().get(i).getDep_terminals() == null || flightData.getResponse().get(i).getDep_terminals().isEmpty()? "/" : flightData.getResponse().get(i).getDep_terminals().toString(),
                        flightData.getResponse().get(i).getArr_terminals() == null || flightData.getResponse().get(i).getArr_terminals().isEmpty() ? "/" : flightData.getResponse().get(i).getArr_terminals().toString(),
                        flightData.getResponse().get(i).getDep_time_utc(), flightData.getResponse().get(i).getDep_time(),
                        flightData.getResponse().get(i).getArr_time_utc(), flightData.getResponse().get(i).getArr_time(), flightData.getResponse().get(i).getDuration());
                flightListWhileSurfing.add(flight);
                flightList.add(flight);
            }
        }

        return ResponseEntity.ok(flightListWhileSurfing);
    }

    /**
     * @param addFlightByUserAndPasswordAndHashCode takes the Username, the Password/ID and the hash value of the flight and saves it to the User
     * @return true/false
     */
    @PutMapping("/addFlight/{addFlightByUserAndPasswordAndHashCode}")
    public ResponseEntity<Boolean> addFlight(@PathVariable("addFlightByUserAndPasswordAndHashCode") String addFlightByUserAndPasswordAndHashCode) {
        String[] params = addFlightByUserAndPasswordAndHashCode.split("&and&");
        if (params.length != 3) {
            return ResponseEntity.badRequest().build();
        }
        this.flightsRepository = SpringbootApplication.getApplicationContext().getBean(FlightRepository.class);
        this.userFlightsRepository = SpringbootApplication.getApplicationContext().getBean(UserFlightsRepository.class);
        this.userRepository = SpringbootApplication.getApplicationContext().getBean(UserRepository.class);
        for (Flight flights : flightList) {
            if (Integer.parseInt(params[2]) == flights.getHashode()) {
                flightsRepository.save(flights);
                Flight flight = flightsRepository.findByHashode(Integer.parseInt(params[2]));
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

    /**
     * @param deleteParams akes the Username, the Password/ID and the hash value of the flight and deletes the Flight
     * @return true/false
     */
    @DeleteMapping("deleteFlight/{deleteFlightByUserAndPasswordAndHashCode}")
    public ResponseEntity<Boolean> deleteFlight(@PathVariable("deleteFlightByUserAndPasswordAndHashCode") String deleteParams) {
        String[] params = deleteParams.split("&and&");
        this.flightsRepository = SpringbootApplication.getApplicationContext().getBean(FlightRepository.class);
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
