import React, {Component} from 'react';
import AirportController from '../../../Controller/AirportController.js';
import AirlineController from '../../../Controller/AirlineController.js';

class SearchBar extends Component {

    constructor(props) {
        super(props);

        this.state = {
            searched_from: false,
            searched_to: false,
            selected_from: false,
            selected_to: false,
            iata_from: "",
            iata_to: "",
            data_from: [],
            data_to: [],
            flights: [],
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

    setFrom = (item) => {
        this.setState({selected_from: true, iata_from: item.iata});
        document.getElementById('searchdepartureinput').value = (item.iata + " - " + item.airportName + ", " + item.nameCity);
    }
    setTo = (item) =>   {
        this.setState({selected_to: true, iata_to: item.iata});
        document.getElementById('searcharrivalinput').value = (item.iata + " - " + item.airportName + ", " + item.nameCity);
    }


    parseFlights = (x) => {
        this.setState({flights: x, showSearch: true})
    }

    getFlights = async () =>  {
        // TODO: day option
        const flights = await AirlineController.getFlights(this.state.iata_from, this.state.iata_to, "mon");
        this.parseFlights(flights);
        setTimeout(() => console.log(this.state.flights), 200);
    }

    render() {
        return (
            <div>
                <input type="text" id="searchdepartureinput" placeholder="city or airport" />
                <button onClick={this.searchFrom}> search </button>
                <br />
                {this.state.searched_from ? <p>{this.state.data_from.map(item => (<button className="airportoption" onClick={this.setFrom.bind(this, item)} key={item.id}>{item.iata} - {item.nameCity}</button>))}</p> : "not searched"}
                <br />

                <input type="text" id="searcharrivalinput" placeholder="city or airport" />
                <button onClick={this.searchTo}> search </button>
                <br />
                {this.state.searched_to ? <p>{this.state.data_to.map(item => (<button className="airportoption" onClick={this.setTo.bind(this, item)} key={item.id}>{item.iata} - {item.nameCity}</button>))}</p> : "not searched"}
                <br />

                {this.state.selected_to && this.state.selected_from ? <button onClick={this.getFlights.bind(this)}>get flights</button> : null}
                <br />

                {this.state.showSearch ? <h2>search results</h2> : ""}

                {
                    this.state.flights !== [] ?
                        <table>
                        {/*
                            <tr>
                                <th> flight number </th>
                                <th> airline </th>
                                <th> departure time </th>
                                <th> arrival time </th>
                            </tr>*/
                            this.state.flights.slice(0, 10).map(flight =>
                                <tr className="flightoption">
                                    <td key={flight.id}>{flight.flightNumber}</td>
                                    <td key={flight.id}>{flight.airline}</td>
                                    <td key={flight.id}>{flight.departureTime}</td>
                                    <td key={flight.id}>{flight.arrivalTime}</td>
                                </tr>
                            )
                        }</table>
                    :    null
                }
            </div>
        );
    }
}

export default SearchBar;
