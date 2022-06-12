import React, {Component} from 'react';

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
            </div>
        );
    }
}

export default FlightDashboardComponent;
