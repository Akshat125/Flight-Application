package utils.api.icaoname;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IacoNameRepository extends CrudRepository<IcaoNameApiUtil, String> {
    List<IcaoNameApiUtil> findByIcao(String icao);
}
