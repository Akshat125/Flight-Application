package utils.api.iatacoordinates;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * This interface allows you to store new iatas with their coordinates into the Database
 */

@Repository
public interface IataCoordinatesRepository extends CrudRepository<IataCoordinatesMapping, String>{
    List<IataCoordinatesMapping> findByIata(String iata);
    List<IataCoordinatesMapping> findAll();
}
