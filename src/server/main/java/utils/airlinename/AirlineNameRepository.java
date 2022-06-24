package utils.airlinename;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirlineNameRepository extends CrudRepository<AirlineName, Long> {
    AirlineName findAirlineNameByName(String name);
    AirlineName findAirlineNameByIcaoCode(String icaoCode);
    List<AirlineName> findAll();
}
