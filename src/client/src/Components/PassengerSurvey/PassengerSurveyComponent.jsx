import React, {Component} from 'react';
import RatingComponent from "./Subcomponents/RatingComponent";
import './ratestyle.css'
import './feedbackPopup.css'
//import "font-awesome/css/font-awesome.min.css"
import "bootstrap/dist/css/bootstrap.css"
import './feed'
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
            comfort: 0,
            food:0,
            entertainment: 0,
            service: 0,
            journey: 0
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

    save = (event) => {
        // TODO: make API call

        this.props.history.push('/')
    }
    cancel = (event) => {
        this.props.history.push('/')
    }

    giveFeedback = (event) => {
        //this.props.prototype.history.push('/')
        var e = document.getElementById('feedback-main');
        if(e.style.display == 'block')
            e.style.display = 'none';
        else
            e.style.display = 'block';
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

                <button className="btn btn-success" onClick={this.save}>Submit</button>
                <button className="btn btn-danger" onClick={this.cancel} style={{marginLeft: "9px"}}>cancel</button>
                <button className="btn btn-info" onClick={this.giveFeedback} style={{marginLeft: "900px"}}>write feedback</button>


                <div id="feedback-main">
                    <div id="centerpoint">
                    <div id="feedback-div">
                        <form action="contact.php" method="post" className="form" id="feedback-form1" name="form1"
                              encType="multipart/form-data">

                            <p className="name">
                                <input name="name" type="name"
                                       className="validate[required,custom[onlyLetter],length[0,100]] feedback-input"
                                       required placeholder="Name" id="feedback-name"/>
                            </p>

                            <p className="email">
                                <input name="email" type="email"
                                       className="validate[required,custom[email]] feedback-input" id="feedback-email"
                                       placeholder="Email" required/>
                            </p>


                            <p className="text">
                                <textarea name="comment" type="comment"
                                          className="validate[required,length[6,300]] feedback-input"
                                          id="feedback-comment" required
                                          placeholder="Please write your valuable feedback here"></textarea>
                            </p>

                            <div className="feedback-submit">
                                <input type="submit" value="SEND" id="feedback-button-blue"/>
                                <div className="feedback-ease"></div>
                            </div>
                        </form>
                    </div>
                    </div>
                </div>


            </div>


            //<div dangerouslySetInnerHTML={ {__html: survey} } />


    );
    }
}

export default PassengerSurveyComponent;
