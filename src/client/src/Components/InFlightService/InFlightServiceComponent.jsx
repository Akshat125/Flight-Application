import React, {Component} from 'react';
import logo from "../../Images/flightLogo.png";

class InFlightServiceComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            visible: false,
        }

    }

    setVisible()    {
        this.state.visible = !this.state.visible;
    }

    componentDidMount() {
    }

    clickedMovies() {

    }
    clickedService() {

    }

    clickedSafetyInstructions() {

    }

    //TODO: add an image above each button.

    render() {
        return (
            <div className="inflight-service">
                <div className="button-container">
                    <ul className="button-list">
                        <li className="button">
                            <button onClick={this.clickedMovies}><img className="btn1logo" src={logo}/>
                                <br/> Movies <br/>
                            </button>
                        </li>
                        <li className="button">
                            <button onClick={this.clickedSafetyInstructions}><img className="btn2logo" src={logo}/>
                                <br/> Flight <br/> Instructions
                            </button>
                        </li>
                        <li className="button">
                            <button onClick={this.clickedService}><img className="btn3logo" src={logo}/>
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
