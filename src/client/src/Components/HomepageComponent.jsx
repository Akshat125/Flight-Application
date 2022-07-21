import React, {Component} from 'react';

import logo from '../Images/flightLogo.png';
import dashicon from '../Images/dashicon.png';
import surveyicon from '../Images/surveyicon.png';
import serviceicon from '../Images/serviceicon.png';

import HeaderComponent from "./Header/HeaderComponent";
import FooterComponent from "./Footer/FooterComponent";

import FlightDashboardComponent from './FlightDashboard/FlightDashboardComponent';
import PassengerSurveyComponent from './PassengerSurvey/PassengerSurveyComponent';
import InFlightServiceComponent from './InFlightService/InFlightServiceComponent';

import AirlineController from '../Controller/AirlineController';

import Dropdown from 'react-bootstrap/Dropdown';

class HomepageComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            logged_in: false,
            username: "",
            passname: "",
            my_flights: [],
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

    setLoggedIn = (val) =>  {
        this.setState({logged_in: val});
        this.setState({
            showDash: false,
            showSurvey: false,
            showService: false,
        });
        setTimeout(() => {window.scrollTo({top: 0, behavior: 'smooth'})}, 200);
    }

    isLoggedIn = () =>  {
        return this.state.logged_in;
    }

    setUser = (user) =>    {
        this.setState({username: user});
    }

    getUser = () => {
        return this.state.username;
    }

    setPass = (pass) =>    {
        this.setState({password: pass});
    }

    getPass = () => {
        return this.state.password;
    }

    loadSavedFlights = async () =>   {
        if (this.getUser() === "")  {
            this.setState({my_flights: []});
        }
        else {
            const resp = await AirlineController.getUserFlights(this.getUser(), this.getPass());
            setTimeout(() => console.log(""), 200);
            this.setState({my_flights: resp});
        }
    }

    getSavedFlights = () => {
        if (this.getUser() === "")  {
            return [];
        }
        else {
            this.loadSavedFlights();
            setTimeout(() => console.log(""), 200);
            return this.state.my_flights;
        }
    }

    closeSurvey = () => {
        this.setState({
            showDash: false,
            showSurvey: false,
            showService: false,
        });
        setTimeout(() => {window.scrollTo({top: 0, behavior: 'smooth'})}, 200);
    }


    render() {
        return (
            <div>
                <HeaderComponent loadSavedFlights={this.loadSavedFlights} setLoggedIn={this.setLoggedIn} setUser={this.setUser} setPass={this.setPass} clickedDash={this.clickedDash} clickedSurvey={this.clickedSurvey} clickedService={this.clickedService}/>
                <div className="main">
                    <div className="logo">
                        <img className="main-logo" src={logo}/>
                    </div>
                    <div className="button-container">
                        <ul className="button-list">
                            <li className="button">
                                <button onClick={this.clickedDash}> <img className="btn1logo" src={dashicon}/> <br/> trip <br/> dashboard </button>
                            </li>
                            <li className="button">
                                <button onClick={this.clickedSurvey}> <img className="btn2logo" src={surveyicon}/> <br/> passenger <br/> survey </button>
                            </li>
                            <li className="button">
                                <button onClick={this.clickedService}> <img className="btn3logo" src={serviceicon}/> <br/> inflight <br/> service </button>
                            </li>
                        </ul>
                    </div>
                    <div id="body" className="body">
                        {this.state.showDash ? <FlightDashboardComponent loadSavedFlights={this.loadSavedFlights} getSavedFlights={this.getSavedFlights} isLoggedIn={this.isLoggedIn} getUser={this.getUser} getPass={this.getPass}/> : null}
                        {this.state.showSurvey ? <PassengerSurveyComponent loadSavedFlights={this.loadSavedFlights} getSavedFlights={this.getSavedFlights} isLoggedIn={this.isLoggedIn} getUser={this.getUser} closeSurvey={this.closeSurvey}/> : null}
                        {this.state.showService ? <InFlightServiceComponent isLoggedIn={this.isLoggedIn}/> : null}
                    </div>
                </div>
                <FooterComponent />
            </div>
        );
    }
}

export default HomepageComponent;
