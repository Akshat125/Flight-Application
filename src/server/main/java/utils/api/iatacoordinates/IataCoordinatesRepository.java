package utils.api.iatacoordinates;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * This interface allows you to store new iatas with their coordinates into the Database
 */

@Repository
public interface IataCoordinatesRepository extends CrudRepository<IataCoordinatesMapping, String>{
}
