import React, {Component} from 'react';
import RatingComponent from "./Subcomponents/RatingComponent";

class PassengerSurveyComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            visible: false
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
                <h2>Rating from state: {rating}</h2>
                <RatingComponent
                    name="rate1"
                    starCount={5}
                    value={rating}
                    onStarClick={this.onStarClick.bind(this)}
                />
            </div>
        );
    }
}

export default PassengerSurveyComponent;
