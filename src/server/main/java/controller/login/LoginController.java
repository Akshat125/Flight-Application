package controller.login;


import main.SpringbootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.flight.Flight;
import utils.flight.FlightRepository;
import utils.user.User;
import utils.user.UserRepository;
import utils.userflights.UserFlights;
import utils.userflights.UserFlightsRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {

    private FlightRepository flightsRepository;
    private UserRepository userRepository;
    private UserFlightsRepository userFlightsRepository;
    private List<Flight> flightsReturn;

    public LoginController() {
        this.flightsReturn = new ArrayList<>();
    }


    /**
     * @param usernameAndPassword takes the Username and the Password/ID and returns all Flights the User saved previously
     * @return List<Flight>
     */
    @GetMapping("getUserFlights/{usernameAndpassword}")
    public ResponseEntity<List<Flight>> loginUserGetFlights(@PathVariable("usernameAndpassword") String usernameAndPassword) {

        String[] params = usernameAndPassword.split("&and&");
        if (params.length != 2) {
            return ResponseEntity.badRequest().build();
        }

        this.flightsRepository = SpringbootApplication.getApplicationContext().getBean(FlightRepository.class);
        this.userRepository = SpringbootApplication.getApplicationContext().getBean(UserRepository.class);
        this.userFlightsRepository = SpringbootApplication.getApplicationContext().getBean(UserFlightsRepository.class);

        User user = userRepository.findUserByNameAndPassword(params[0], params[1]);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        List<UserFlights> userFlights = userFlightsRepository.findUserFlightsByUserID(user.getID());
        flightsReturn.clear();
        for (UserFlights userFlight : userFlights) {
            flightsReturn.add(flightsRepository.getByID(userFlight.getFlightID()));
        }
        return ResponseEntity.ok(flightsReturn);
    }

    /**
     * @param usernameAndPassword takes the Username and the Password/ID
     * @return true in case the user exists OR returns false in case the user doesn't  exist
     */
    @GetMapping("checkLogin/{usernameAndpassword}")
    public ResponseEntity<Boolean> checkLogin(@PathVariable("usernameAndpassword") String usernameAndPassword) {

        String[] params = usernameAndPassword.split("&and&");
        if (params.length != 2) {
            return ResponseEntity.ok(false);
        }

        this.userRepository = SpringbootApplication.getApplicationContext().getBean(UserRepository.class);

        User user = userRepository.findUserByNameAndPassword(params[0], params[1]);
        if (user == null) {
            return ResponseEntity.ok(false);
        }else{
            return ResponseEntity.ok(true);
        }
    }

    /**
     * @param userAndPassword takes the Username and the Password/ID and creates a new User
     * @return true in case the new user was added OR return false in case the user already exists/the request was wrong
     */
    @PutMapping("createUser/{userAndPassword}")
    public ResponseEntity<Boolean> createNewUser(@PathVariable("userAndPassword") String userAndPassword) {
        this.userRepository = SpringbootApplication.getApplicationContext().getBean(UserRepository.class);
        String[] params = userAndPassword.split("&and&");
        if (params.length != 2) {
            return ResponseEntity.ok(false);
        }
        User user = userRepository.findByName(params[0]);
        if (user != null) {
            return ResponseEntity.ok(false);
        }
        User newUser = new User(params[0], params[1]);
        userRepository.save(newUser);
        return ResponseEntity.ok(true);
    }
}
