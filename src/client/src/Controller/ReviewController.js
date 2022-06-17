import axios from 'axios'

const REVIEW_PUT_API_BASE_URL = "http://localhost:8080/addReview";
const REVIEW_GET_API_BASE_URL = "http://localhost:8080/getAllReviews";
const REVIEW_DELETE_API_BASE_URL = "http://localhost:8080/deleteReview";

class ReviewController {
    /* @params (seperated by &and&):
    1st param: username

    2nd param: password

    3rd param:
        true/false
      → true is Public
      → false is Private

    4th param:
        star rating flight

    5th param:
        star rating catering

    6th param:
        star rating entertainment

    7th param:
        star rating service

    8th param:
        star rating comfort

    9th param:
        review Text
     */

    /* @return
    Review in case all went fine
    Otherwise badRequest 400
    -> Example of a review return: {
                                    "name": "Anonymous User",
                                    "starRatingFlight": 1,
                                    "starRatingCatering": 2,
                                    "starRatingEntertainment": 3,
                                    "starRatingService": 4,
                                    "starRatingComfort": 5,
                                    "reviewText": "Sample Private Review",
                                    "hash": 1561383247,
                                     "id": 48
                                    }
     */

    putReviews(...reviewParameters) {
        const query = reviewParameters.reduce((previous, next) => previous + "&and&" + next);
        return axios.put(REVIEW_PUT_API_BASE_URL + "/" + query);
    }

    // @params (seperated by &and&): users
    /* @return
    Review list(see example of a review response above ^) in case all went fine
    Otherwise badRequest 400
     */

    getReviews(...reviewParameters) {
        const query = reviewParameters.reduce((previous, next) => previous + "&and&" + next);
        return axios.get(REVIEW_GET_API_BASE_URL + "/" + query);
    }

    // @params(seperated by &and&): name, value, password
    // @return (boolean): True in case the review was deleted, false otherwise BadRequest 400 in case the request were wrong

    deleteReview(name, hashValue, password) {
        const query = name + "&and&" + hashValue + "&and&" + password;
        return axios.delete(REVIEW_DELETE_API_BASE_URL + "/" + query)
    }

}

export default new ReviewController()
