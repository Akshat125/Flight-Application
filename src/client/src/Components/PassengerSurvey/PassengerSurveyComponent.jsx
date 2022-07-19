import React, {Component} from 'react';
import './ratestyle.css';
import './feedbackPopup.css';
import "bootstrap/dist/css/bootstrap.css";
import './feed';
import Swal from "sweetalert2";
import couponImage from "./drinks.jpg";

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
        }

    }

    //setVisible()    {
    // this.setState(this.setVisible);
    //this.state.visible = !this.state.visible;}

    componentDidMount() {
        const ratings = {
            comfort: 0,
            food: 0,
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
        Swal.fire({
            title: "You received a 20% Discount Coupon at Pingu Drinks!",
            text: "Take a sip in the Pingu Bahamas with a refreshing Mocktail.",
            imageUrl: couponImage,
            timer: 2000,
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

    comfort = () => {
        this.setState({comfort: document.getElementById('comfortinput').value});
        setTimeout(() => console.log(""), 200);
        document.getElementById('comfortstars').style.width = `${Math.round((this.state.comfort / 5 * 100) / 10) * 10}%`;
    }

    giveFeedback = (event) => {
        //this.props.prototype.history.push('/')
        var e = document.getElementById('feedback-main');
        if (e.style.display == 'block')
            e.style.display = 'none';
        else
            e.style.display = 'block';
    }


    render() {

        //const {rating} = this.state;
        return (
            <div className="passenger-survey">
            <h1> passenger survey </h1>
            <div className="maxwidth">
            <div className="container mt-5">
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
                    <input type="number" id="rating-control" className="form-control" step="0.1" max="5"
                           placeholder="Rate 1 - 5"></input>
                </div>

                <table className="table table-striped">
                    <thead>
                    <tr>
                        <th>Category</th>
                        <th>Input</th>
                        <th>Rating</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr className="comfort">
                        <td>Comfort</td>
                        <td><input id="comfortinput" placeholder="0-5" onChange={this.comfort} type="number" maxLength="1" min="0" max="5" /></td>
                        <td>
                            <div className="stars-outer">
                                <div id="comfortstars" className="stars-inner"></div>
                            </div>
                            <span className="number-rating"></span>
                        </td>
                    </tr>
                    <tr className="food">
                        <td>Food</td>
                        <td><input placeholder="0-5" onInput={this.save} type="text" /></td>
                        <td>
                            <div className="stars-outer">
                                <div className="stars-inner"></div>
                            </div>
                            <span className="number-rating"></span>
                        </td>
                    </tr>
                    <tr className="entertainment">
                        <td>Entertainment</td>
                        <td><input placeholder="0-5" onInput={this.save} type="text" /></td>
                        <td>
                            <div className="stars-outer">
                                <div className="stars-inner"></div>
                            </div>
                            <span className="number-rating"></span>
                        </td>
                    </tr>
                    <tr className="service">
                        <td>Service</td>
                        <td><input placeholder="0-5" onInput={this.save} type="text" /></td>
                        <td>
                            <div className="stars-outer">
                                <div className="stars-inner"></div>
                            </div>
                            <span className="number-rating"></span>
                        </td>
                    </tr>
                    <tr className="journey">
                        <td>Journey</td>
                        <td><input placeholder="0-5" onInput={this.save} type="text" /></td>
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
                <button className="btn btn-info" onClick={this.giveFeedback} style={{marginLeft: "900px"}}>write
                    feedback
                </button>

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
                                           className="validate[required,custom[email]] feedback-input"
                                           id="feedback-email"
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
            </div>
            </div>

            //<div dangerouslySetInnerHTML={ {__html: survey} } />


    );
    }
}

export default PassengerSurveyComponent;
