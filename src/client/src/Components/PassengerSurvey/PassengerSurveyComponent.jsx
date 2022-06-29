import React, {Component} from 'react';
import RatingComponent from "./Subcomponents/RatingComponent";
import './ratestyle.css'
//import "font-awesome/css/font-awesome.min.css"
import "bootstrap/dist/css/bootstrap.css"
class PassengerSurveyComponent extends Component {

    constructor(props) {
        super(props);


        this.state = {
            visible: false
        }

    }

    //setVisible()    {
       // this.setState(this.setVisible);
       //this.state.visible = !this.state.visible;}

    componentDidMount() {
        const ratings = {
            comfort: 4.7,
            food: 3.4,
            entertainment: 2.3,
            service: 3.6,
            journey: 4.1
        };

        // Total Stars
        const starsTotal = 5;

        // Run getRatings when DOM loads
        document.addEventListener("DOMContentLoaded", getRatings);

        // Form Elements
        const productSelect = document.getElementById("product-select");
        const ratingControl = document.getElementById("rating-control");

        // Init product
        let product;

        // Product select change
        productSelect.addEventListener("change", (e) => {
            product = e.target.value;
            // Enable rating control
            ratingControl.disabled = false;
            ratingControl.value = ratings[product];
        });

        // Rating control change
        ratingControl.addEventListener("blur", (e) => {
            const rating = e.target.value;

            // Make sure 5 or under
            if (rating > 5) {
                alert("Please rate 1 - 5");
                return;
            }

            // Change rating
            ratings[product] = rating;

            getRatings();
        });

        // Get ratings
        function getRatings() {
            for (let rating in ratings) {
                // Get percentage
                const starPercentage = (ratings[rating] / starsTotal) * 100;

                // Round to nearest 10
                const starPercentageRounded = `${Math.round(starPercentage / 10) * 10}%`;

                // Set width of stars-inner to percentage
                document.querySelector(
                    `.${rating} .stars-inner`
                ).style.width = starPercentageRounded;

                // Add number rating
                document.querySelector(`.${rating} .number-rating`).innerHTML =
                    ratings[rating];
            }
        }
    }

    render() {

        //const {rating} = this.state;
        return (
            /*
            <div className="passenger-survey">
                <h2>Rating from state:{rating}</h2>
                <RatingComponent
                    name="rate1"
                    starCount={5}
                    value={rating}
                    onStarClick={this.onStarClick.bind(this)}
                />
            </div>
            */
            <div className="container mt-5">

                <div className="form-group">
                    <select id="product-select" className="form-control custom-select">
                        <option value="0" disabled selected>Rate your flight</option>
                        <option value="comfort">Comfort</option>
                        <option value="food">Food</option>
                        <option value="entertainment">Entertainment</option>
                        <option value="service">Service</option>
                        <option value="journey">Journey</option>
                    </select>
                </div>
                <div className="form-group">
                    <input type="number" id="rating-control" className="form-control" step="0.1" max="5"
                           placeholder="Rate 1 - 5"></input>
                </div>

                <table className="table table-striped">
                    <thead>
                    <tr>
                        <th>Air Pingu</th>
                        <th>Rating</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr className="comfort">
                        <td>Comfort</td>
                        <td>
                            <div className="stars-outer">
                                <div className="stars-inner"></div>
                            </div>
                            <span className="number-rating"></span>
                        </td>
                    </tr>
                    <tr className="food">
                        <td>Food</td>
                        <td>
                            <div className="stars-outer">
                                <div className="stars-inner"></div>
                            </div>
                            <span className="number-rating"></span>
                        </td>
                    </tr>
                    <tr className="entertainment">
                        <td>Entertainment</td>
                        <td>
                            <div className="stars-outer">
                                <div className="stars-inner"></div>
                            </div>
                            <span className="number-rating"></span>
                        </td>
                    </tr>
                    <tr className="service">
                        <td>Service</td>
                        <td>
                            <div className="stars-outer">
                                <div className="stars-inner"></div>
                            </div>
                            <span className="number-rating"></span>
                        </td>
                    </tr>
                    <tr className="journey">
                        <td>Journey</td>
                        <td>
                            <div className="stars-outer">
                                <div className="stars-inner"></div>
                            </div>
                            <span className="number-rating"></span>
                        </td>
                    </tr>
                    </tbody>
                </table>

                <footer>
                    <text> wlenf</text>
                </footer>
                </div>


            //<div dangerouslySetInnerHTML={ {__html: survey} } />


    );
    }
}

export default PassengerSurveyComponent;
