package controller.review;


import main.SpringbootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.review.Review;
import utils.review.ReviewRepository;
import utils.user.User;
import utils.user.UserRepository;
import utils.userreviews.UserReviewRepository;
import utils.userreviews.UserReviews;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ReviewController {

    private UserRepository userRepository;
    private UserReviewRepository userReviewRepository;
    private ReviewRepository reviewRepository;

    /**
     * @param reviewMapping takes a new Review as String, the Review then can be seen from all other Users (private or public)
     * @return the new Review
     */
    @PutMapping("addReview/{query}")
    public ResponseEntity<Review> addReview(@PathVariable("query") String reviewMapping) {

        String[] requestArgs = reviewMapping.split("&and&");
        if (requestArgs.length != 9) {
            return ResponseEntity.badRequest().build();
        }
        try {
            String userName = requestArgs[0];
            String userPassword = requestArgs[1];
            String postPublic = requestArgs[2];
            int ratingFlight = Integer.parseInt(requestArgs[3]);
            int ratingCatering = Integer.parseInt(requestArgs[4]);
            int ratingEntertainment = Integer.parseInt(requestArgs[5]);
            int ratingService = Integer.parseInt(requestArgs[6]);
            int ratingComfort = Integer.parseInt(requestArgs[7]);
            String reviewText = requestArgs[8];

            this.userRepository = SpringbootApplication.getApplicationContext().getBean(UserRepository.class);
            this.userReviewRepository = SpringbootApplication.getApplicationContext().getBean(UserReviewRepository.class);
            this.reviewRepository = SpringbootApplication.getApplicationContext().getBean(ReviewRepository.class);


            User user = userRepository.findUserByNameAndPassword(userName, userPassword);
            if (user == null) {
                return ResponseEntity.badRequest().build();
            }
            String nameInDB;
            if (postPublic.equalsIgnoreCase("true")) {
                nameInDB = user.getName();
            } else {
                nameInDB = "Anonymous User";
            }
            Review review = new Review(nameInDB, ratingFlight, ratingCatering, ratingEntertainment, ratingService, ratingComfort, reviewText);
            int reviewHash = review.getHash();
            reviewRepository.save(review);
            Review reviewDB = reviewRepository.findReviewByHash(reviewHash);
            userReviewRepository.save(new UserReviews(user.getID(), reviewDB.getID()));
            Review retReview = new Review(user.getName(), ratingFlight, ratingCatering, ratingEntertainment, ratingService, ratingComfort, reviewText);
            retReview.setHash(review.getHash());
            retReview.setID(reviewDB.getID());
            return ResponseEntity.ok(retReview);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * @param userLoginData takes the Username and Password/ID and returns all the added Reviews
     * @return List<Review>
     */
    @GetMapping("getAllReviews/{query}")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable("query") String userLoginData) {

        String[] requestArgs = userLoginData.split("&and&");

        if (requestArgs.length != 2) {
            return ResponseEntity.badRequest().build();
        }
        this.userRepository = SpringbootApplication.getApplicationContext().getBean(UserRepository.class);
        this.userReviewRepository = SpringbootApplication.getApplicationContext().getBean(UserReviewRepository.class);
        this.reviewRepository = SpringbootApplication.getApplicationContext().getBean(ReviewRepository.class);

        User user = userRepository.findUserByNameAndPassword(requestArgs[0], requestArgs[1]);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        List<UserReviews> userReviews = userReviewRepository.findUserReviewsByUserID(user.getID());
        List<Long> reviewIds = new ArrayList<>();
        userReviews.forEach(x -> {
            reviewIds.add(x.getReviewID());
        });

        List<Review> retReview = new ArrayList<>();

        reviewIds.forEach(x -> {
            Review review;
            review = reviewRepository.findReviewByID(x);
            Review newReview = new Review(user.getName(), review.getStarRatingFlight(), review.getStarRatingCatering(), review.getStarRatingEntertainment(), review.getStarRatingService(), review.getStarRatingComfort(), review.getReviewText());
            newReview.setHash(review.getHash());
            newReview.setID(review.getID());
            retReview.add(newReview);
        });

        List<Review> allReviews = reviewRepository.findAll();

        allReviews.forEach(x -> {
            if (!retReview.contains(x)) {
                retReview.add(x);
            }
        });

        return ResponseEntity.ok(retReview);
    }

    /**
     * @param userLoginDataReviewHash takes the Username, the Password/ID and the hash Value corresponding to the Review and deletes it
     * @return true/false
     */
    @DeleteMapping("deleteReview/{query}")
    public ResponseEntity<Boolean> deleteReview(@PathVariable("query") String userLoginDataReviewHash) {

        String[] requestArgs = userLoginDataReviewHash.split("&and&");
        if (requestArgs.length != 3) {
            return ResponseEntity.badRequest().build();
        }
        try {
            this.userRepository = SpringbootApplication.getApplicationContext().getBean(UserRepository.class);
            this.userReviewRepository = SpringbootApplication.getApplicationContext().getBean(UserReviewRepository.class);
            this.reviewRepository = SpringbootApplication.getApplicationContext().getBean(ReviewRepository.class);

            String userName = requestArgs[0];
            String userPassword = requestArgs[1];
            int hash = Integer.parseInt(requestArgs[2]);

            User user = userRepository.findUserByNameAndPassword(userName, userPassword);
            Review review = reviewRepository.findReviewByHash(hash);
            if (user == null || review == null) {
                return ResponseEntity.ok(false);
            }

            UserReviews userReviews = userReviewRepository.findUserReviewsByUserIDAndReviewID(user.getID(), review.getID());
            if (userReviews == null) {
                return ResponseEntity.ok(false);
            }
            userReviewRepository.delete(userReviews);
            reviewRepository.delete(review);
            return ResponseEntity.ok(true);

        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }


    }
}
