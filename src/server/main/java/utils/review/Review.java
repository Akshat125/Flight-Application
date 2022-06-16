package utils.review;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private String name;
    private int starRatingFlight;
    private int starRatingCatering;
    private int starRatingEntertainment;
    private int starRatingService;
    private int starRatingComfort;
    private String reviewText;
    private int hash;

    public Review(String name, int starRatingFlight, int starRatingCatering, int starRatingEntertainment, int starRatingService, int starRatingComfort, String reviewText) {
        this.name = name;
        this.starRatingFlight = starRatingFlight;
        this.starRatingCatering = starRatingCatering;
        this.starRatingEntertainment = starRatingEntertainment;
        this.starRatingService = starRatingService;
        this.starRatingComfort = starRatingComfort;
        this.reviewText = reviewText;
        this.hash = hashCode();
    }

    public Review() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStarRatingFlight() {
        return starRatingFlight;
    }

    public void setStarRatingFlight(int starRatingFlight) {
        this.starRatingFlight = starRatingFlight;
    }

    public int getStarRatingCatering() {
        return starRatingCatering;
    }

    public void setStarRatingCatering(int starRatingCatering) {
        this.starRatingCatering = starRatingCatering;
    }

    public int getStarRatingEntertainment() {
        return starRatingEntertainment;
    }

    public void setStarRatingEntertainment(int starRatingEntertainment) {
        this.starRatingEntertainment = starRatingEntertainment;
    }

    public int getStarRatingService() {
        return starRatingService;
    }

    public void setStarRatingService(int starRatingService) {
        this.starRatingService = starRatingService;
    }

    public int getStarRatingComfort() {
        return starRatingComfort;
    }

    public void setStarRatingComfort(int starRatingComfort) {
        this.starRatingComfort = starRatingComfort;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return hash == review.hash;
    }
}
