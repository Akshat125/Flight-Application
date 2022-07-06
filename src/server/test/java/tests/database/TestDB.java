package tests.database;

import main.SpringbootApplication;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import utils.review.Review;
import utils.review.ReviewRepository;
import utils.user.User;
import utils.user.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class TestDB {

    private static ConfigurableApplicationContext applicationContext;
    // Test adding new User

    @BeforeAll
    static void prepareDB() {
        applicationContext = SpringApplication.run(SpringbootApplication.class);
    }

    @Test
    public void testAddUserAndDelete() {
        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        User newUser = new User("%?nameTest?%", "ID of %?nameTest?%");
        userRepository.save(newUser);
        // Test add
        assertEquals(newUser, userRepository.findByName("%?nameTest?%"));
        assertEquals(newUser, userRepository.findUserByNameAndPassword("%?nameTest?%", "ID of %?nameTest?%"));

        // Test attributes
        assertEquals("%?nameTest?%", userRepository.findByName("%?nameTest?%").getName());
        assertEquals("ID of %?nameTest?%", userRepository.findByName("%?nameTest?%").getPassword());
        assertTrue(userRepository.findByName("%?nameTest?%").getID() >= 0);

        // Test delete user
        userRepository.delete(newUser);
        assertNull(userRepository.findByName("%?nameTest?%"));
        assertNull(userRepository.findUserByNameAndPassword("%?nameTest?%", "ID of %?nameTest?%"));
    }

    @Test
    public void testAddReviewAndDelete(){
        ReviewRepository reviewRepository = applicationContext.getBean(ReviewRepository.class);
        Review newReview = new Review("%? name of review %?",1,2,3,4,5,"?%& review Text !%§$");

        // Test add
        reviewRepository.save(newReview);
        assertEquals(newReview, reviewRepository.findReviewByHash(newReview.getHash()));

        // Test attributes
        assertEquals("%? name of review %?", reviewRepository.findReviewByHash(newReview.getHash()).getName());
        assertEquals(1, reviewRepository.findReviewByHash(newReview.getHash()).getStarRatingFlight());
        assertEquals(2, reviewRepository.findReviewByHash(newReview.getHash()).getStarRatingCatering());
        assertEquals(3, reviewRepository.findReviewByHash(newReview.getHash()).getStarRatingEntertainment());
        assertEquals(4, reviewRepository.findReviewByHash(newReview.getHash()).getStarRatingService());
        assertEquals(5, reviewRepository.findReviewByHash(newReview.getHash()).getStarRatingComfort());
        assertEquals("?%& review Text !%§$", reviewRepository.findReviewByHash(newReview.getHash()).getReviewText());

        // Test delete
        reviewRepository.delete(newReview);
        assertNull(reviewRepository.findReviewByHash(newReview.getHash()));
    }


    // TODO test remaining DB Entities
}
