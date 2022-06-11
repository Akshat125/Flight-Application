import React, {Component} from 'react';
import logo from '../Images/flightLogo.png';


class HomepageComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
        }

    }

    componentDidMount() {
    }

    render() {
        return (
            <div className="main">
                <div className="logo">
                    <img className="main-logo" src={logo}/>
                </div>
                <div className="button-container">
                    <ul className="button-list">
                        <li className="button">
                            <button href="#"> <img className="btn1logo" src={logo}/> <br/> trip <br/> dashboard </button>
                        </li>
                        <li className="button">
                            <button href="#"> <img className="btn2logo" src={logo}/> <br/> passenger <br/> survey </button>
                        </li>
                        <li className="button">
                            <button href="#"> <img className="btn3logo" src={logo}/> <br/> inflight <br/> service </button>
                        </li>
                    </ul>
                </div>
            </div>
        );
    }
}

export default HomepageComponent;
