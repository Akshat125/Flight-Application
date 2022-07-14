import React, {Component} from 'react';
import HomepageComponent from "../HomepageComponent";
import NavigationBarComponent from "./Subcomponents/NavigationBarComponent";

class HeaderComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {

        }
    }

    componentDidMount() {
    }

    render() {
        return (
            <header>
                <NavigationBarComponent loadSavedFlights={this.props.loadSavedFlights} setLoggedIn={this.props.setLoggedIn} setUser={this.props.setUser} setPass={this.props.setPass} clickedDash={this.props.clickedDash} clickedSurvey={this.props.clickedSurvey} clickedService={this.props.clickedService} />
                <div className="drop-shadow"> </div>
            </header>
        );
    }
}

export default HeaderComponent;
