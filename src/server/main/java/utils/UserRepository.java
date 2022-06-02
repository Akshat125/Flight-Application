package utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


/**
 * This interface allows you to store new Users into the Database
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
