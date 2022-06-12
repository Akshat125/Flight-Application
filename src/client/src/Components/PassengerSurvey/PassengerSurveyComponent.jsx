import React, {Component} from 'react';

class PassengerSurveyComponent extends Component {

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
            <div className="passenger-survey">
                <h1> placeholder passenger survey section </h1>
            </div>
        );
    }
}

export default PassengerSurveyComponent;
