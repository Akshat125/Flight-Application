import React, {Component} from 'react';

class InFlightServiceComponent extends Component {

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
            <div className="inflight-service">
                <h1> placeholder inflight service section </h1>
            </div>
        );
    }
}

export default InFlightServiceComponent;
