import React, {Component} from 'react';
import HomepageComponent from "../HomepageComponent";
import NavigationBarComponent from "./Subcomponents/NavigationBarComponent"

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
                <NavigationBarComponent />
                <div className="drop-shadow"> </div>
            </header>
        );
    }
}

export default HeaderComponent;
