import React, {Component} from 'react';
import AirportController from '../../../Controller/AirportController.js';
import AirlineController from '../../../Controller/AirlineController.js';
import WeatherController from '../../../Controller/WeatherController.js';
import MapsController from '../../../Controller/MapsController.js';
import POIController from '../../../Controller/POIController.js';
import Swal from 'sweetalert2';

import thermometericon from '../../../Images/thermometericon.png';
import windicon from '../../../Images/windicon.jpeg';
import rainicon from '../../../Images/rainicon.png';
import humidityicon from '../../../Images/humidityicon.png';
import removeicon from '../../../Images/removeicon.png';

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
            showSearch: false,
            weather: [],
            weatherClicked: false,
            weatherFor: null,
            weatherCity: "",
            weatherCityUrl: "",
            mapimg: null,
            poi_list: null,
            bucket_list: []
        }

    }

    componentDidMount() {
        this.setState({my_flights: this.props.getSavedFlights()});
        console.log(this.props.getSavedFlights());
        this.loadPOIs();
    }

    componentWillUnmount()  {
        this.setState({my_flights: this.props.getSavedFlights()});
        console.log(this.props.getSavedFlights());
        this.loadPOIs();
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
        let daystrl = "";
        switch (item.getDay())  {
            case 1:
                daystrl = "Monday";
                break;
            case 2:
                daystrl = "Tuesday";
                break;
            case 3:
                daystrl = "Wednesday";
                break;
            case 4:
                daystrl = "Thursday";
                break;
            case 5:
                daystrl = "Friday";
                break;
            case 6:
                daystrl = "Saturday";
                break;
            case 0:
                daystrl = "Sunday";
                break;
        }
        let mstr = "";
        switch (item.getMonth())   {
            case 0:
                mstr = "January";
                break;
            case 1:
                mstr = "February";
                break;
            case 2:
                mstr = "March";
                break;
            case 3:
                mstr = "April";
                break;
            case 4:
                mstr = "May";
                break;
            case 5:
                mstr = "June";
                break;
            case 6:
                mstr = "July";
                break;
            case 7:
                mstr = "August";
                break;
            case 8:
                mstr = "September";
                break;
            case 9:
                mstr = "October";
                break;
            case 10:
                mstr = "November";
                break;
            case 11:
                mstr = "December";
                break;
        }
        document.getElementById('searchbardate').innerHTML = (daystrl + ", <br/>" + item.getDate() + " " + mstr + " " + item.getFullYear());
        document.getElementById("searchdepartureinput").value = "";
        document.getElementById("searcharrivalinput").value = "";
    }


    parseFlights = (x) => {
        //document.getElementById("flightoptionheader").classList.add("showflightoptionheader");
        this.setState({flights: x, showSearch: true});
    }

    getFlights = async () =>  {
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
        else if (this.state.my_flights.filter(f => (f.flightNumber === flight.flightNumber && f.departureTime === flight.departureTime && f.arrivalIata === flight.arrivalIata)).length != 0)  {
            Swal.fire({
                icon: 'error',
                html: '<h3>Failed to add flight</h3><br>This flight already already exists under \'My Flights\'.',
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


    generateMap = async (flight) => {
        const resp = await MapsController.getMap(flight.departureIata, flight.arrivalIata);
        this.setState({mapimg: URL.createObjectURL(resp)});
    }

    weatherIcon = () => {
        return "http://openweathermap.org/img/wn/" + this.state.weather[0].icon + "@2x.png";
    }

    expandFlight = async (flight) =>  {
        this.collapseFlight();
        const city = await AirportController.getAirport(flight.arrivalIata);
        this.setState({weatherCity: city[0].nameCity, weatherCityUrl: "https://maps.google.com/maps?q=" + city[0].nameCity + "&z=11&ie=UTF8&output=embed"});
        console.log(this.state.weatherCity);
        const poi = await POIController.getPoi(flight.arrivalIata);
        this.setState({poi_list: poi});
        console.log(this.state.poi_list);
        this.generateMap(flight);
        const resp = await WeatherController.getWeather(flight.arrivalIata);
        this.setState({weather: resp, weatherClicked: true, weatherFor: flight});
        console.log(this.state.weather);
    }

    collapseFlight = async () =>  {
        this.setState({weather: [], weatherClicked: false, weatherFor: null, weatherCity: "", weatherCityUrl: "", poi_list: null});
    }

    savePOI = (poiName) =>  {
        localStorage.setItem(this.props.getUser() + "&" + poiName, poiName);
        this.loadPOIs();
        console.log('added');

        Swal.fire({
            icon: 'success',
            text: 'Item successfully added to your bucket list.',
            showConfirmButton: false,
            timer: 2000
        });
    }

    removePOI = (poiName) =>    {
        localStorage.removeItem(this.props.getUser() + "&" + poiName);
        this.loadPOIs();
        console.log('removed');

        Swal.fire({
            icon: 'success',
            text: 'Item successfully removed from your bucket list.',
            showConfirmButton: false,
            timer: 2000
        });
    }

    loadPOIs = () =>    {
        this.setState({bucket_list: []});
        for (var k in Object.keys(localStorage))    {
            let key = localStorage.key(k);
            if (key.split('&')[0] === this.props.getUser()) {
                this.setState(prev => ({bucket_list: [...prev.bucket_list, key.split('&')[1]]}));
            }
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
                    <button onClick={this.showCalendar} id="searchbardate">flight date</button>
                </div>
                <div className="searchinput">
                    <input placeholder="leaving from ..." className="searchdepartureinput" onInput={this.searchFrom} type="text" id="searchdepartureinput" />
                    <input placeholder="heading towards ..." className="searcharrivalinput" onInput={this.searchTo} type="text" id="searcharrivalinput" />
                    <div className="searchdateinput" id="searchdateinput"><Calendar minDate={new Date()} direction='horizontal' weekStartsOn={new Number('1')} date={new Date()} onChange={this.setDate} scroll={{enabled: true}} /></div>
                </div>
                <div className="searchdropdown">
                    <div className="airport-dropdown-from" onMouseLeave={this.hideDeparture}>
                        {this.state.searched_from ? <ul>{this.state.data_from.map(item => (<li className="airportoption" onClick={this.setFrom.bind(this, item)} key={item.id}>{item.iata} - {item.airportName}, {item.nameCity}</li>))}</ul> : null}
                    </div>
                    <div className="airport-dropdown-to" onMouseLeave={this.hideArrival}>
                        {this.state.searched_to ? <ul>{this.state.data_to.map(item => (<li className="airportoption" onClick={this.setTo.bind(this, item)} key={item.id}>{item.iata} - {item.airportName}, {item.nameCity}</li>))}</ul> : null}
                    </div>
                </div>
                </div>
                {this.state.selected_to && this.state.selected_from && this.state.selected_date ? <button className="getflights" onClick={this.getFlights.bind(this)}>get flights</button> : <button className="getflights" disabled="true" onClick={this.getFlights.bind(this)}>get flights</button>}
                <hr/>
                {this.state.showSearch ? <h2>search results</h2> : ""}
                {this.state.showSearch && !this.props.isLoggedIn() ? <p>login to save flights</p> : ""}
                {this.state.showSearch && this.props.isLoggedIn() ? <p>click to add flights</p> : ""}

                {
                    this.state.showSearch ?
                    <div className="flightoptionheader" id="flightoptionheader">
                        <span id="flight">flight</span>
                        <span id="airline">airline</span>
                        <span id="from_airport">depart</span>
                        <span id="from_gate">gate</span>
                        <span id="from_time">time</span>
                        <span id="headerwhitespace"></span>
                        <span id="to_airport">arrive</span>
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

                {this.state.showSearch ? <hr/> : null}

                {
                    this.props.isLoggedIn() ?
                    <div id="bucket-list">
                        <h2> my bucket list </h2>
                        <ul>
                            {
                                this.state.bucket_list !== null && this.state.bucket_list.length != 0?
                                this.state.bucket_list.map(poi =>
                                    <li className="bucket-item"><button id="remove-poi" onClick={this.removePOI.bind(this, poi)}><img src={removeicon} width="20"/></button>{poi}</li>
                                )
                                : <p>Your bucket list is empty.</p>
                            }
                        </ul>
                    </div>
                    : null
                }

                <h2> my flights </h2>
                {this.props.isLoggedIn() && this.state.my_flights.length != 0 ? <p>You have no saved flights.</p> : null}
                {this.props.isLoggedIn() && this.state.my_flights.length == 0 ? <p>click to see further details</p> : null}
                <div>
                {
                    this.props.isLoggedIn() ?
                    <div className="myflightoptionheader" id="myflightoptionheader">
                        <span id="flight">flight</span>
                        <span id="airline">airline</span>
                        <span id="from_airport">depart</span>
                        <span id="from_gate">gate</span>
                        <span id="from_time">time</span>
                        <span id="headerwhitespace"></span>
                        <span id="to_airport">arrive</span>
                        <span id="to_gate">gate</span>
                        <span id="to_time">time</span>
                        <span id="remove-placeholder"></span>
                    </div>
                    : <p>Login to see your saved flights.</p>
                }
                </div>
                <div id="my-flights">
                {
                    this.props.isLoggedIn() ?
                    <table id="my-flights-table">
                    {
                        this.state.my_flights.map(flight =>
                            <div id="flightoptioncontainer">
                            <tr className="flightoption" onClick={this.expandFlight.bind(this, flight)}>
                                <td id="flightno">{flight.flightNumber}</td>
                                <td id="airline">{flight.airline}</td>
                                <td id="departureiata">{flight.departureIata}</td>
                                <td id="departuregate">{flight.departureTerminal}</td>
                                <td id="departuretime">{flight.departureTime}</td>
                                <td id="whitespace"></td>
                                <td id="arrivaliata">{flight.arrivalIata}</td>
                                <td id="arrivalgate">{flight.arrivalTerminal}</td>
                                <td id="arrivaltime">{flight.arrivalTime}</td>
                                <button className="flightoptionbtn" id="remove-btn" onClick={this.removeFlight.bind(this, flight)}><img src={removeicon} width="20"/></button>
                            </tr>
                            <div id="expandcontainer">
                            {this.state.weatherClicked && this.state.weatherFor === flight  ?
                                <div id="expand-flight">
                                    <div id="expand-header">
                                        <h3>{this.state.weatherCity}<img id="weathericon" src={this.weatherIcon()} width="50"/></h3>
                                        <div id="weather">
                                            <img id="themometericon" width="30" height="30" src={thermometericon}/>
                                            <span id="temp">{(this.state.weather[0].temp - 273.15).toFixed()}°C</span>
                                            <img width="30" height="30" src={humidityicon}/>
                                            <span id="humidity">{(this.state.weather[0].humidity)}%</span>
                                            <img width="30" height="30" src={windicon}/>
                                            <span id="wind">{(this.state.weather[0].windSpeed * 3.6).toFixed()}kph {this.state.weather[0].windDirection / 45 < 1 ? "N" : this.state.weather[0].windDirection / 45 < 2 ? "NE" : this.state.weather[0].windDirection / 45 < 3 ? "E" : this.state.weather[0].windDirection / 45 < 4 ? "SE" : this.state.weather[0].windDirection / 45 < 5 ? "S" : this.state.weather[0].windDirection / 45 < 6 ? "SW" : this.state.weather[0].windDirection / 45 < 7 ? "W" : this.state.weather[0].windDirection / 45 < 8 ? "NW" : "direction"}</span>
                                            <img width="30" height="30" src={rainicon}/>
                                            <span id="rain">{(this.state.weather[0].pop * 100)}%</span>
                                        </div>
                                    </div>
                                    <h3> points of interest </h3>
                                    <p> The following attractions in {this.state.weatherCity} may interest you: </p>
                                    <p> Click to bookmark.  </p>
                                    <br/>
                                    <div id="poi-interface">
                                        <div id="poi-list">
                                            <ul>
                                                {
                                                    this.state.poi_list !== null ?
                                                    this.state.poi_list.map(poi =>
                                                        <li className="poi-item"><button onClick={this.savePOI.bind(this, poi.name)}>{poi.name}</button></li>
                                                    )
                                                    : null
                                                }
                                            </ul>
                                        </div>
                                        <div id="map">
                                            <iframe src={this.state.weatherCityUrl} width="600" height="450"></iframe>
                                        </div>
                                    </div>
                                    <div id="flightmap">
                                        <h3> flight map </h3>
                                        <img width="50%" src={this.state.mapimg}/>
                                    </div>
                                </div>
                             : null}
                            </div>
                            </div>
                        )
                    }</table> : null
                }
                </div>
            </div>
        );
    }
}

export default SearchBar;
