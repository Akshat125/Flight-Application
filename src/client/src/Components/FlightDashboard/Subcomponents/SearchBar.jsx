import React, {Component} from 'react';
import AirportController from '../../../Controller/AirportController.js';
import AirlineController from '../../../Controller/AirlineController.js';
import Swal from 'sweetalert2';

class SearchBar extends Component {

    constructor(props) {
        super(props);

        this.state = {
            departure_menu: false,
            arrival_menu: false,
            searched_from: false,
            searched_to: false,
            selected_from: false,
            selected_to: false,
            iata_from: "",
            iata_to: "",
            data_from: [],
            data_to: [],
            flights: [],
            my_flights: [],
            showSearch: false
        }

    }

    componentDidMount() {
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
        document.getElementById("searchdepartureinput").classList.add("search-show");
        document.getElementById("searchdepartureinput").value = "";
        document.getElementById("searcharrivalinput").value = "";
        this.setState({searched_from: false});
    }

    showArrival = () => {
        this.hideDeparture();
        document.getElementById("searcharrivalinput").classList.add("search-show");
        document.getElementById("searchdepartureinput").value = "";
        document.getElementById("searcharrivalinput").value = "";
        this.setState({searched_to: false});
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

    hideBoth = () =>    {
        document.getElementById("searchdepartureinput").classList.remove("search-show");
        document.getElementById("searcharrivalinput").classList.remove("search-show");
        document.getElementById("searchdepartureinput").value = "";
        document.getElementById("searcharrivalinput").value = "";
        this.setState({searched_from: false, searched_to: false});
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


    parseFlights = (x) => {
        //document.getElementById("flightoptionheader").classList.add("showflightoptionheader");
        this.setState({flights: x, showSearch: true});
    }

    getFlights = async () =>  {
        // TODO: day option
        const flights = await AirlineController.getFlights(this.state.iata_from, this.state.iata_to, "mon");
        this.parseFlights(flights);

        setTimeout(() => console.log(this.state.flights), 200);
    }

    addFlight = (flight) =>   {
        const resp = AirlineController.putFlight('admin', 'admin', flight.hashode);
        if (resp)   {
            this.getSavedFlights();
            Swal.fire({
                icon: 'success',
                type: 'success',
                text: 'flight successfully added to list',
            });
        }
        else {
            Swal.fire({
                icon: 'failure',
                type: 'failure',
                text: 'failed to add flight',
            });
        }
    }

    removeFlight = (flight) =>  {
        const resp = AirlineController.deleteFlight('admin', 'admin', flight.hashode);
        if (resp)   {
            this.getSavedFlights();
            Swal.fire({
                icon: 'success',
                type: 'success',
                text: 'flight successfully removed from list',
            });
        }
        else {
            Swal.fire({
                icon: 'failure',
                type: 'failure',
                text: 'failed to remove flight',
            });
        }
    }

    getSavedFlights = async () =>   {
        const resp = await AirlineController.postUserFlights('admin', 'admin');
        this.setState({my_flights: resp});
    }



    render() {
        return (
            <div className="trip-dashboard-dynamic">
                <h2> search </h2>
                <div onMouseLeave={this.hideBoth}>
                <div className="searchbar">
                    <button onClick={this.showDeparture} id="searchbarfrom">departure:<br />city or airport</button>
                    <button onClick={this.showArrival} id="searchbarto">arrival:<br />city or airport</button>
                    <button id="searchdateinput">date</button>
                </div>
                <div className="searchinput">
                    <input placeholder="leaving from ..." className="searchdepartureinput" onInput={this.searchFrom} type="text" id="searchdepartureinput" />
                    <input placeholder="heading towards ..." className="searcharrivalinput" onInput={this.searchTo} type="text" id="searcharrivalinput" />
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
                {this.state.selected_to && this.state.selected_from ? <button className="getflights" onClick={this.getFlights.bind(this)}>get flights</button> : <button className="getflights" disabled="true" onClick={this.getFlights.bind(this)}>get flights</button>}
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
                                    <td id="flightno" key={flight.id}>{flight.flightNumber}</td>
                                    <td id="airline" key={flight.id}>{flight.airline}</td>
                                    <td id="departureiata" key={flight.id}>{flight.departureIata}</td>
                                    <td id="departuregate" key={flight.id}>{flight.departureTerminal}</td>
                                    <td id="departuretime" key={flight.id}>{flight.departureTime}</td>
                                    <td id="whitespace"></td>
                                    <td id="arrivaliata" key={flight.id}>{flight.arrivalIata}</td>
                                    <td id="arrivalgate" key={flight.id}>{flight.arrivalTerminal}</td>
                                    <td id="arrivaltime" key={flight.id}>{flight.arrivalTime}</td>
                                </tr>
                                </button>
                            )
                        }</table>
                    :    null
                }
                </div>


                <h2> my flights </h2>
                <table>
                <tr>
                    <th> flight number </th>
                    <th> airline </th>
                    <th> departure </th>
                    <th> terminal </th>
                    <th> gate </th>
                    <th> arrival </th>
                    <th> terminal </th>
                    <th> gate </th>
                </tr>
                </table>
                {
                    this.state.my_flights !== [] ?
                    <table>
                    {
                        this.state.my_flights.map(flight =>
                            <button className="savedbtn" onClick={this.removeFlight.bind(this, flight)}>
                            <tr className="savedoption">
                                <td id="savedflightno" key={flight.id}>{flight.flightNumber}</td>
                                <td id="savedairline" key={flight.id}>{flight.airline}</td>
                                <td id="saveddepartureiata" key={flight.id}>{flight.departureIata}</td>
                                <td id="saveddeparturegate" key={flight.id}>{flight.departureTerminal}</td>
                                <td id="saveddeparturetime" key={flight.id}>{flight.departureTime}</td>
                                <td id="savedwhitespace"></td>
                                <td id="savedarrivaliata" key={flight.id}>{flight.arrivalIata}</td>
                                <td id="savedarrivalgate" key={flight.id}>{flight.arrivalTerminal}</td>
                                <td id="savedarrivaltime" key={flight.id}>{flight.arrivalTime}</td>
                            </tr>
                            </button>
                        )
                    }</table> : null
                }
            </div>
        );
    }
}

export default SearchBar;
