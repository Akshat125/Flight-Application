import React, {Component} from 'react';
import RatingComponent from "./Subcomponents/RatingComponent";
import './ratestyle.css'
import 'font-awesome/css/font-awesome.min.css'
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
                </div>


            //<div dangerouslySetInnerHTML={ {__html: survey} } />


    );
    }
}

export default PassengerSurveyComponent;
