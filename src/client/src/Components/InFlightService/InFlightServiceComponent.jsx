import React, {Component} from 'react';
import moviesLogo from '../../Images/InFlightService/Movies/popcorn.png';
import serviceButtonLogo1 from '../../Images/InFlightService/Service/blueServiceButton.png';
import serviceButtonLogo2 from '../../Images/InFlightService/Service/greenServiceButton.png';
import flightInstructionLogo from '../../Images/InFlightService/SafetyInstructions/instructions.png';
import MoviesComponent from "./Subcomponents/MoviesComponent";
import SafetyInstructionsComponent from "./Subcomponents/SafetyInstructionsComponent";
import Swal from 'sweetalert2';

class InFlightServiceComponent extends Component {
    //potentially add music effects later
    constructor(props) {
        super(props);

        this.state = {
            showMovie: false,
            showFlightInstructions: false,
            serviceImageUrl: serviceButtonLogo1,
        }

        this.clickedMovies = this.clickedMovies.bind(this);
        this.clickedService = this.clickedService.bind(this);
        this.clickedSafetyInstructions = this.clickedSafetyInstructions.bind(this);
    }

    componentDidMount() {
    }

    clickedMovies() {
        this.setState({
            showMovie: true,
            showFlightInstructions: false,
            serviceImageUrl: this.state.serviceImageUrl
        });
        const y = document.getElementById('body').getBoundingClientRect().top + window.pageYOffset + 215;
        setTimeout(() => {window.scrollTo({top: y, behavior: 'smooth'})}, 300);
    }

    clickedService() {
        let previousState = this.state.serviceImageUrl
        this.setState({
            serviceImageUrl: this.state.serviceImageUrl == serviceButtonLogo1 ? serviceButtonLogo2 : serviceButtonLogo1
        });
        if (previousState == serviceButtonLogo1) {
            Swal.fire({
                icon: 'success',
                type: 'success',
                text: 'The flight attendant has been informed',
            });

        }
        else {
        }
    }

    clickedSafetyInstructions() {
        this.setState({
            showMovie: false,
            showFlightInstructions: true,
            serviceImageUrl: this.state.serviceImageUrl
        });
        const y = document.getElementById('body').getBoundingClientRect().top + window.pageYOffset - 300;
        setTimeout(() => {window.scrollTo({top: y, behavior: 'smooth'})}, 300);
    }

    render() {
        return (
            <div className="inflight-service">
                <h1> inflight service </h1>
                <br/>
                {this.props.isLoggedIn() ?
                <div>
                <div className="button-container">
                    <ul className="button-list">
                        <li className="button">
                            <button onClick={this.clickedMovies}><img className="btn1logo" src = {moviesLogo}/>
                                <br/> Movies <br/> <br/>
                            </button>
                        </li>
                        <li className="button">
                            <button onClick={this.clickedSafetyInstructions}><img className="btn2logo" src = {flightInstructionLogo}/>
                                <br/> Flight Instructions <br/>
                            </button>
                        </li>
                        <li className="button">
                            <button onClick={this.clickedService}><img className="btn3logo" src = {this.state.serviceImageUrl}/>
                                <br/> Service <br/> <br/>
                            </button>
                        </li>
                    </ul>
                </div>
                <div className="body">
                    {this.state.showMovie ? <MoviesComponent /> : null}
                    {this.state.showFlightInstructions ? <SafetyInstructionsComponent /> : null}
                    <br/>
                </div>
                </div>
                : <div><p>You need to be logged in to access this feature.</p><br/></div>}
            </div>
        );
    }
}

export default InFlightServiceComponent;
