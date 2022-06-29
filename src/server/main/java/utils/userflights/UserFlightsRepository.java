package utils.userflights;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to handle the DB interaction for the mapping between User and Flight IDs
 */
@Repository
public interface UserFlightsRepository extends CrudRepository<UserFlights,Long>{
    List<UserFlights> findUserFlightsByFlightID(long flightID);
    List<UserFlights> findUserFlightsByUserID(long userID);
    UserFlights findUserFlightsByUserIDAndFlightID(long userID, long flightID);
    void deleteUserFlightsByUserIDAndFlightID(long userID, long flightID);
}
