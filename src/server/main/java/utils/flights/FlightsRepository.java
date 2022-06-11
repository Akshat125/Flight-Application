package utils.flights;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * This interface allows you to store new Users into the Database
 */

@Repository
public interface FlightsRepository extends CrudRepository<Flights, Long> {
    Flights findByHashode(int hashcode);
    List<Flights> findAll();
    Flights getByID(long ID);
}
