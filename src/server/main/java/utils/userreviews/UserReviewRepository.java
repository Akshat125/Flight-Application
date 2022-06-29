package utils.userreviews;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to handle the DB interaction for the mapping between User and Review IDs
 */
@Repository
public interface UserReviewRepository extends CrudRepository<UserReviews,Long>{
    List<UserReviews> findUserReviewsByUserID(long userID);
    UserReviews findUserReviewsByUserIDAndReviewID(long userID, long reviewID);
}
