import React, {Component} from 'react';
import SearchBar from './Subcomponents/SearchBar.jsx'
import SearchResults from './Subcomponents/SearchResults.jsx'
import SaveFlight from './Subcomponents/SaveFlight.jsx'

class FlightDashboardComponent extends Component {

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

    render() {
        return (
            <div className="trip-dashboard">
                <h1> placeholder trip dashboard section </h1>
                <SearchBar loadSavedFlights={this.props.loadSavedFlights} getSavedFlights={this.props.getSavedFlights} isLoggedIn={this.props.isLoggedIn} getUser={this.props.getUser} getPass={this.props.getPass}/>
                <SearchResults />
                <SaveFlight />
            </div>
        );
    }
}

export default FlightDashboardComponent;
