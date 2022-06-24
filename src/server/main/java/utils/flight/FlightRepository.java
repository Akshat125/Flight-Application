package utils.flight;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * This interface allows you to store new Users into the Database
 */

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
    Flight findByHashode(int hashcode);
    List<Flight> findAll();
    Flight getByID(long ID);
}
