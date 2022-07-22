import React, {Component} from 'react';
import './ratestyle.css';
import './feedbackPopup.css';
import "bootstrap/dist/css/bootstrap.css";
import './feed';
import Swal from "sweetalert2";

import AirlineController from '../../Controller/AirlineController.js';

import couponImage from "./drinks.jpg";
import removeicon from '../../Images/removeicon.png';

class PassengerSurveyComponent extends Component {

    constructor(props) {
        super(props);


        this.state = {
            visible: false,
            isSubmitted: false,
            comfort: 0,
            food: 0,
            entertainment: 0,
            service: 0,
            journey: 0,
            my_flights: [],
            selected: ""
        }

    }

    //setVisible()    {
    // this.setState(this.setVisible);
    //this.state.visible = !this.state.visible;}

    componentWillUnmount()  {
        this.setState({my_flights: this.props.getSavedFlights()});
        console.log(this.props.getSavedFlights());
    }

    componentDidMount() {
        this.setState({my_flights: this.props.getSavedFlights()});
        console.log(this.props.getSavedFlights());
        const ratings = {
            comfort: 0,
            food: 0,
            entertainment: 0,
            service: 0,
            journey: 0
        };

        if (document !== null)  {
            // Total Stars
            const starsTotal = 5;

            // Run getRatings when DOM loads
            document.addEventListener("DOMContentLoaded", getRatings);

            // Form Elements
            const productSelect = document.getElementById("product-select");
            const ratingControl = document.getElementById("rating-control");

            // Init product
            let product;

            if (productSelect !== null) {
                // Product select change
                productSelect.addEventListener("change", (e) => {
                    product = e.target.value;
                    // Enable rating control
                    ratingControl.disabled = false;
                    ratingControl.value = ratings[product];
                });
            }

            if (ratingControl !== null) {
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
            }

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
    }

    componentDidUpdate()    {
        const ratings = {
            comfort: 0,
            food: 0,
            entertainment: 0,
            service: 0,
            journey: 0
        };

        if (document !== null)  {
            // Total Stars
            const starsTotal = 5;

            // Run getRatings when DOM loads
            document.addEventListener("DOMContentLoaded", getRatings);

            // Form Elements
            const productSelect = document.getElementById("product-select");
            const ratingControl = document.getElementById("rating-control");

            // Init product
            let product;

            if (productSelect !== null) {
                // Product select change
                productSelect.addEventListener("change", (e) => {
                    product = e.target.value;
                    // Enable rating control
                    ratingControl.disabled = false;
                    ratingControl.value = ratings[product];
                });
            }

            if (ratingControl !== null) {
            // Rating control change
                ratingControl.addEventListener("blur", (e) => {
                    const rating = e.target.value;

                    // Make sure 5 or under
                    if (rating > 5) {
                        Swal.fire({
                            icon: 'error',
                            html: 'Please enter a value between 1 and 5.',
                            showConfirmButton: false,
                            timer: 4000
                        });
                        return;
                    }

                    // Change rating
                    ratings[product] = rating;

                    getRatings();
                });
            }

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
                }
            }
        }
    }

    save = (event) => {
        Swal.fire({
            title: "You received a 20% Discount Coupon at Pingu Drinks!",
            text: "Take a sip in the Pingu Bahamas with a refreshing Mocktail.",
            imageUrl: couponImage,
            timer: 5000,
            showConfirmButton: false,
            imageWidth: 550,
            imageHeight: 300,
        });
        this.props.closeSurvey();
    }

    cancel = (event) => {
        this.props.closeSurvey();
        //this.props.history.push('/')
    }

    giveFeedback = (event) => {
        //this.props.prototype.history.push('/')
        var e = document.getElementById('feedback-main');
        if (e.style.display == 'block')
            e.style.display = 'none';
        else
            e.style.display = 'block';
    }

    selectFlight = (flight) =>  {
        this.setState({selected: flight.airline + " " + flight.flightNumber});
    }

    removeFlight = (flight) =>  {
        const resp = AirlineController.deleteFlight(this.props.getUser(), this.props.getPass(), flight.hashode);
        if (resp)   {
            this.setState({my_flights: this.state.my_flights.filter((val) => val !== flight)});
            Swal.fire({
                icon: 'success',
                text: 'Flight successfully removed from list.',
                showConfirmButton: false,
                timer: 2000
            });
        }
        else {
            Swal.fire({
                icon: 'error',
                html: '<h3>Failed to remove flight</h3><br>You may be disconnected from the server.',
                showConfirmButton: false,
                timer: 4000
            });
        }
    }


    render() {

        //const {rating} = this.state;
        return (
            <div className="passenger-survey">
            <h1> passenger survey </h1>
            <h2> my recent flights </h2>
            {this.props.isLoggedIn() && this.state.my_flights.length != 0 ? <p>Select a flight to rate.</p> : null}
            {this.props.isLoggedIn() && this.state.my_flights.length == 0 ? <p>You have no saved flights.</p> : null}

            <div id="my-flights">
            {
                this.props.isLoggedIn() ?
                <table id="my-flights-table">
                {
                    this.state.my_flights.map(flight =>
                        <div id="flightoptioncontainer2">
                        <tr className="flightoption" onClick={this.selectFlight.bind(this, flight)}>
                            <td id="flightno">{flight.flightNumber}</td>
                            <td id="airline">{flight.airline}</td>
                            <td id="departureiata">{flight.departureIata}</td>
                            <td id="departuregate">{flight.departureTerminal}</td>
                            <td id="departuretime">{flight.departureTime}</td>
                            <td id="whitespace"></td>
                            <td id="arrivaliata">{flight.arrivalIata}</td>
                            <td id="arrivalgate">{flight.arrivalTerminal}</td>
                            <td id="arrivaltime">{flight.arrivalTime}</td>
                        </tr>
                        </div>
                    )
                }</table> : null
            }
            </div>
            {this.state.selected.length > 0 ?
            <div className="maxwidth">
            <h3>rate flight: {this.state.selected.length > 0 ? this.state.selected : ""}</h3>
            <div className="container mt-5">
                <div id="maxwidth2">
                <div id="rating-cols">
                    <div className="form-group">
                        <select id="product-select" className="form-control custom-select">
                            <option value="0" disabled selected>Rate category...</option>
                            <option value="comfort">Comfort</option>
                            <option value="food">Food</option>
                            <option value="entertainment">Entertainment</option>
                            <option value="service">Service</option>
                            <option value="journey">Journey</option>
                        </select>
                    </div>
                    <div className="form-group">
                        <input type="number" id="rating-control" className="form-control" step="0.1" min="1" max="5"
                               placeholder="Rate 1 - 5"></input>
                    </div>
                </div>
                    <table className="table table-striped">
                        <thead>
                        <tr>
                            <th>Category</th>
                            <th>Rating</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr className="comfort">
                            <td>Comfort</td>
                            <td>
                                <div className="stars-outer">
                                    <div id="comfortstars" className="stars-inner"></div>
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
                    <h3>Leave a comment</h3>
                    <p id="comment">Let us know what you've particularly enjoyed and where we can improve our services.<br/>Comments are sent anonymously.</p>
                    <textarea placeholder="What do you think?"></textarea>
                    <br/>
                    <button className="login-btn" onClick={this.save}>submit</button>
                    <button className="logout-btn" onClick={this.cancel} style={{marginLeft: "9px"}}>cancel</button>
                </div>
            </div>
            </div> : !this.props.isLoggedIn() ? <p>You need to be logged in to access this feature.</p> : null}
            <br/>
        </div>

            //<div dangerouslySetInnerHTML={ {__html: survey} } />


    );
    }
}

export default PassengerSurveyComponent;
