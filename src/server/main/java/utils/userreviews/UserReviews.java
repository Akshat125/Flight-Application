package utils.userreviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserReviews {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private long userID;
    private long reviewID;

    public UserReviews(long userID, long reviewID) {
        this.userID = userID;
        this.reviewID = reviewID;
    }

    public UserReviews() {
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getReviewID() {
        return reviewID;
    }

    public void setReviewID(long reviewID) {
        this.reviewID = reviewID;
    }
}
