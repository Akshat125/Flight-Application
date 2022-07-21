import React, {Component} from 'react';
import safetyInstructions from "../../../Images/InFlightService/SafetyInstructions.jpg";

class SafetyInstructionsComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            showManual: false,
            showVideo: false
        }

    }

    componentDidMount() {
    }

    render() {
        return (
            <div className="inflight-service flight-safety">
                <img class = "img-fluid" src={safetyInstructions}/>
            </div>
        );
    }
}

export default SafetyInstructionsComponent;
