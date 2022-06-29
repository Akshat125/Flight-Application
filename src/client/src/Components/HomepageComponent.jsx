import React, {Component} from 'react';

import logo from '../Images/flightLogo.png';

import HeaderComponent from "./Header/HeaderComponent";
import FooterComponent from "./Footer/FooterComponent";

import FlightDashboardComponent from './FlightDashboard/FlightDashboardComponent';
import PassengerSurveyComponent from './PassengerSurvey/PassengerSurveyComponent';
import InFlightServiceComponent from './InFlightService/InFlightServiceComponent';

import Dropdown from 'react-bootstrap/Dropdown';

class HomepageComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            showDash: false,
            showSurvey: false,
            showService: false,
        };

    }

    componentDidMount() {
    }

    clickedDash = () => {
        this.setState({
            showDash: true,
            showSurvey: false,
            showService: false,
        });
        const y = document.getElementById('body').getBoundingClientRect().top + window.pageYOffset - 200;
        setTimeout(() => {window.scrollTo({top: y, behavior: 'smooth'})}, 300);
    }

    clickedSurvey = () =>   {
        this.setState({
            showDash: false,
            showSurvey: true,
            showService: false,
        });
        const y = document.getElementById('body').getBoundingClientRect().top + window.pageYOffset - 200;
        setTimeout(() => {window.scrollTo({top: y, behavior: 'smooth'})}, 300);
    }

    clickedService = () =>  {
        this.setState({
            showDash: false,
            showSurvey: false,
            showService: true,
        });
        const y = document.getElementById('body').getBoundingClientRect().top + window.pageYOffset - 200;
        setTimeout(() => {window.scrollTo({top: y, behavior: 'smooth'})}, 200);
    }



    render() {
        return (
            <div>
                <HeaderComponent clickedDash={this.clickedDash}/>
                <div className="main">
                    <div className="logo">
                        <img className="main-logo" src={logo}/>
                    </div>
                    <div className="button-container">
                        <ul className="button-list">
                            <li className="button">
                                <button onClick={this.clickedDash}> <img className="btn1logo" src={logo}/> <br/> trip <br/> dashboard </button>
                            </li>
                            <li className="button">
                                <button onClick={this.clickedSurvey}> <img className="btn2logo" src={logo}/> <br/> passenger <br/> survey </button>
                            </li>
                            <li className="button">
                                <button onClick={this.clickedService}> <img className="btn3logo" src={logo}/> <br/> inflight <br/> service </button>
                            </li>
                        </ul>
                    </div>
                    <div id="body" className="body">
                        {this.state.showDash ? <FlightDashboardComponent /> : null}
                        {this.state.showSurvey ? <PassengerSurveyComponent /> : null}
                        {this.state.showService ? <InFlightServiceComponent /> : null}
                    </div>
                </div>
                <FooterComponent />
            </div>
        );
    }
}

export default HomepageComponent;
