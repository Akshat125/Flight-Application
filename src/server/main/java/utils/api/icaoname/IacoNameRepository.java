package utils.api.icaoname;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to handle the DB interaction for the IATA-Codes to Name mapping
 */
@Repository
public interface IacoNameRepository extends CrudRepository<IcaoNameApiUtil, String> {
    List<IcaoNameApiUtil> findByIcao(String icao);
}
