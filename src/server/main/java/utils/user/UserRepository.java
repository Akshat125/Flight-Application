package utils.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to handle the DB interaction for the Users
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByNameAndPassword(String name, String password);
    User findByName(String name);
}
