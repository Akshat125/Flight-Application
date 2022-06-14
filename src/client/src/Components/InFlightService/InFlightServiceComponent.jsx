import React, {Component} from 'react';
import logo from "../../Images/flightLogo.png";

class InFlightServiceComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            showMovie: false,
            showFlightInstructions: false,
            showService: false,
        }

    }

    //TODO add a dialog box for showService

    componentDidMount() {
    }

    clickedMovies() {
        this.showMovie = true;
        this.showFlightInstructions = false;
        this.showService = false;
    }

    clickedService() {
        this.showMovie = false;
        this.showFlightInstructions = false;
        this.showService = true;
    }

    clickedSafetyInstructions() {
        this.showMovie = false;
        this.showFlightInstructions = true;
        this.showService = false;
    }

    //TODO: add an image above each button.
    //TODO: redirect/autoscroll to the respective components.

    render() {
        return (
            <div className="inflight-service">
                <div className="button-container">
                    <ul className="button-list">
                        <li className="button">
                            <button onClick={this.clickedMovies}><img className="btn1logo"/>
                                <br/> Movies <br/>
                            </button>
                        </li>
                        <li className="button">
                            <button onClick={this.clickedSafetyInstructions}><img className="btn2logo"/>
                                <br/> Flight Instructions <br/>
                            </button>
                        </li>
                        <li className="button">
                            <button onClick={this.clickedService}><img className="btn3logo"/>
                                <br/> Service <br/>
                            </button>
                        </li>
                    </ul>
                </div>
            </div>
        );
    }
}

export default InFlightServiceComponent;
