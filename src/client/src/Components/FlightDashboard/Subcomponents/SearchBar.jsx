import React, {Component} from 'react';
import AirportController from '../../../Controller/AirportController.js';
import AirlineController from '../../../Controller/AirlineController.js';
import Swal from 'sweetalert2';

import 'react-date-range/dist/styles.css';
import 'react-date-range/dist/theme/default.css';
import {Calendar} from 'react-date-range';

class SearchBar extends Component {

    constructor(props) {
        super(props);

        this.state = {
            departure_menu: false,
            arrival_menu: false,
            searched_from: false,
            searched_to: false,
            searched_date: false,
            selected_date: false,
            selected_from: false,
            selected_to: false,
            iata_from: "",
            iata_to: "",
            day: "",
            data_from: [],
            data_to: [],
            flights: [],
            my_flights: [],
            showSearch: false
        }

    }

    componentDidMount() {
        this.setState({my_flights: this.props.getSavedFlights()});
        console.log(this.props.getSavedFlights());
    }

    receive_from = (resp_from) => {
        this.setState({
            searched_from: true,
            data_from: resp_from
        })
    }

    receive_to = (resp_to) => {
        this.setState({
            searched_to: true,
            data_to: resp_to
        })
    }

    searchFrom = async () =>  {
        const resp_from = await AirportController.getAirport(document.getElementById('searchdepartureinput').value);
        this.receive_from(resp_from);
        setTimeout(() => console.log(this.state.data_from), 200);
    }


    searchTo = async () =>  {
        const resp_to = await AirportController.getAirport(document.getElementById('searcharrivalinput').value);
        this.receive_to(resp_to);
        setTimeout(() => console.log(this.state.data_from), 200);
    }

    showDeparture = () =>   {
        this.hideArrival();
        this.hideCalendar();
        document.getElementById("searchdepartureinput").classList.add("search-show");
        document.getElementById("searchdepartureinput").value = "";
        document.getElementById("searcharrivalinput").value = "";
        this.setState({searched_from: false});
    }

    showArrival = () => {
        this.hideDeparture();
        this.hideCalendar();
        document.getElementById("searcharrivalinput").classList.add("search-show");
        document.getElementById("searchdepartureinput").value = "";
        document.getElementById("searcharrivalinput").value = "";
        this.setState({searched_to: false});
    }

    showCalendar = () =>    {
        this.hideArrival();
        this.hideDeparture();
        document.getElementById("searchdateinput").classList.add("search-show-date");
        document.getElementById("searchdepartureinput").value = "";
        document.getElementById("searcharrivalinput").value = "";
        this.setState({searched_date: false});
    }

    hideDeparture = () =>   {
        document.getElementById("searchdepartureinput").classList.remove("search-show");
        document.getElementById("searchdepartureinput").value = "";
        document.getElementById("searcharrivalinput").value = "";
        this.setState({searched_from: false});
    }

    hideArrival = () => {
        document.getElementById("searcharrivalinput").classList.remove("search-show");
        document.getElementById("searchdepartureinput").value = "";
        document.getElementById("searcharrivalinput").value = "";
        this.setState({searched_to: false});
    }

    hideCalendar = () =>    {
        document.getElementById("searchdateinput").classList.remove("search-show-date");
        document.getElementById("searchdepartureinput").value = "";
        document.getElementById("searcharrivalinput").value = "";
        this.setState({searched_date: false});
    }

    hideBoth = () =>    {
        document.getElementById("searchdepartureinput").classList.remove("search-show");
        document.getElementById("searcharrivalinput").classList.remove("search-show");
        document.getElementById("searchdateinput").classList.remove("search-show-date");
        document.getElementById("searchdepartureinput").value = "";
        document.getElementById("searcharrivalinput").value = "";
        this.setState({searched_from: false, searched_to: false, searched_date: false});
    }

    setFrom = (item) => {
        this.hideBoth();
        this.setState({searched_from: false, selected_from: true, iata_from: item.iata});
        document.getElementById('searchbarfrom').innerHTML = (item.iata + "<br/>" + item.airportName + "<br/>" + item.nameCity);
        document.getElementById("searchdepartureinput").value = "";
        document.getElementById("searcharrivalinput").value = "";
    }
    setTo = (item) =>   {
        this.hideBoth();
        this.setState({searched_to: false, selected_to: true, iata_to: item.iata});
        document.getElementById('searchbarto').innerHTML = (item.iata + "<br/>" + item.airportName + "<br/>" + item.nameCity);
        document.getElementById("searchdepartureinput").value = "";
        document.getElementById("searcharrivalinput").value = "";
    }
    setDate = (item) => {
        this.hideBoth();
        const option = {weekday: 'short'};
        const daystr = (new Intl.DateTimeFormat('en-US', option).format(item.getDay())).toLowerCase();
        this.setState({searched_date: false, selected_date: true, day: daystr});
        const option1 = {weekday: 'long'};
        const option2 = {month: 'long'};
        document.getElementById('searchbardate').innerHTML = (new Intl.DateTimeFormat('en-US', option1).format(item.getDay()) + ", <br/>" + item.getDate() + " " + new Intl.DateTimeFormat('en-US', option2).format(item.getMonth()) + " " + item.getFullYear());
        document.getElementById("searchdepartureinput").value = "";
        document.getElementById("searcharrivalinput").value = "";
    }


    parseFlights = (x) => {
        //document.getElementById("flightoptionheader").classList.add("showflightoptionheader");
        this.setState({flights: x, showSearch: true});
    }

    getFlights = async () =>  {
        // TODO: day option
        const flights = await AirlineController.getFlights(this.state.iata_from, this.state.iata_to, this.state.day);
        this.parseFlights(flights);

        setTimeout(() => console.log(this.state.flights), 200);
    }

    addFlight = (flight) =>   {
        if (this.props.getUser() === "")    {
            Swal.fire({
                icon: 'error',
                html: '<h3>Failed to add flight</h3><br>You are not logged in or you are disconnected from the server.',
                showConfirmButton: false,
                timer: 4000
            });
            return;
        }
        const resp = AirlineController.putFlight(this.props.getUser(), this.props.getPass(), flight.hashode);
        if (resp)   {
            this.setState(prev => ({my_flights: [...prev.my_flights, flight]}));
            Swal.fire({
                icon: 'success',
                text: 'Flight successfully added to list.',
                showConfirmButton: false,
                timer: 2000
            });
        }
        else {
            Swal.fire({
                icon: 'error',
                html: '<h3>Failed to add flight</h3><br>You may be disconnected from the server.',
                showConfirmButton: false,
                timer: 4000
            });
        }
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
        return (
            <div className="trip-dashboard-dynamic">
                <h2> search </h2>
                <div onMouseLeave={this.hideBoth}>
                <div className="searchbar">
                    <button onClick={this.showDeparture} id="searchbarfrom">departure:<br />city or airport</button>
                    <button onClick={this.showArrival} id="searchbarto">arrival:<br />city or airport</button>
                    <button onClick={this.showCalendar} id="searchbardate">date</button>
                </div>
                <div className="searchinput">
                    <input placeholder="leaving from ..." className="searchdepartureinput" onInput={this.searchFrom} type="text" id="searchdepartureinput" />
                    <input placeholder="heading towards ..." className="searcharrivalinput" onInput={this.searchTo} type="text" id="searcharrivalinput" />
                    <div className="searchdateinput" id="searchdateinput"><Calendar minDate={new Date()} direction='horizontal' weekStartsOn={new Number('1')} date={new Date()} onChange={this.setDate} scroll={{enabled: true}} /></div>
                </div>
                <div className="searchdropdown">
                    <div className="airport-dropdown-from" onMouseLeave={this.hideDeparture}>
                        {this.state.searched_from ? <ul>{this.state.data_from.map(item => (<li className="airportoption" onClick={this.setFrom.bind(this, item)} key={item.id}>{item.iata} - {item.nameCity}</li>))}</ul> : null}
                    </div>
                    <div className="airport-dropdown-to" onMouseLeave={this.hideArrival}>
                        {this.state.searched_to ? <ul>{this.state.data_to.map(item => (<li className="airportoption" onClick={this.setTo.bind(this, item)} key={item.id}>{item.iata} - {item.nameCity}</li>))}</ul> : null}
                    </div>
                </div>
                </div>
                {this.state.selected_to && this.state.selected_from && this.state.selected_date ? <button className="getflights" onClick={this.getFlights.bind(this)}>get flights</button> : <button className="getflights" disabled="true" onClick={this.getFlights.bind(this)}>get flights</button>}
                {this.state.showSearch ? <div><h2>search results</h2><p>click to add flights</p></div> : ""}
                {
                    this.state.showSearch ?
                    <div className="flightoptionheader" id="flightoptionheader">
                        <span id="flight">flight</span>
                        <span id="airline">airline</span>
                        <span id="from_airport">airport</span>
                        <span id="from_gate">gate</span>
                        <span id="from_time">time</span>
                        <span id="headerwhitespace"></span>
                        <span id="to_airport">airport</span>
                        <span id="to_gate">gate</span>
                        <span id="to_time">time</span>
                    </div>
                    : ""
                }

                <div className="table-scroller">
                {
                    this.state.flights !== [] ?
                        <table>
                        {
                            this.state.flights.map(flight =>
                                <button className="flightoptionbtn" onClick={this.addFlight.bind(this, flight)}>
                                <tr className="flightoption">
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
                                </button>
                            )
                        }</table>
                    :    null
                }
                </div>


                <h2> my flights </h2>
                {this.props.isLoggedIn() ? <div><p>click to remove flights from your list</p></div> : ""}
                <div>
                {
                    this.props.isLoggedIn() ?
                    <div className="flightoptionheader" id="flightoptionheader">
                        <span id="flight">flight</span>
                        <span id="airline">airline</span>
                        <span id="from_airport">airport</span>
                        <span id="from_gate">gate</span>
                        <span id="from_time">time</span>
                        <span id="headerwhitespace"></span>
                        <span id="to_airport">airport</span>
                        <span id="to_gate">gate</span>
                        <span id="to_time">time</span>
                    </div>
                    : "login to see your saved flights"
                }
                </div>
                <div className="table-scroller">
                {
                    this.props.isLoggedIn() ?
                    <table>
                    {
                        this.state.my_flights.map(flight =>
                            <button className="flightoptionbtn" onClick={this.removeFlight.bind(this, flight)}>
                            <tr className="flightoption">
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
                            </button>
                        )
                    }</table> : "null placeholder"
                }
                </div>
            </div>
        );
    }
}

export default SearchBar;
