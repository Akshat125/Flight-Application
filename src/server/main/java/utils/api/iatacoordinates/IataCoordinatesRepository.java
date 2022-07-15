package utils.api.iatacoordinates;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to handle the DB interaction for the IATA-Codes to Coordinates mapping
 */
@Repository
public interface IataCoordinatesRepository extends CrudRepository<IataCoordinatesApiUtil, String>{
    IataCoordinatesApiUtil findByIata(String iata);
    List<IataCoordinatesApiUtil> findAll();
}
