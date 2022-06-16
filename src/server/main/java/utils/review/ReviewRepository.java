package utils.review;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findAll();
    Review findReviewByHash(int hash);
    Review findReviewByID(long ID);
}
