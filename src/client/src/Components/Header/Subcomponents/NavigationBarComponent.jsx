import React, {Component} from 'react';
import logo from '../../../Images/flightLogo.png';

class NavigationBarComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
        }

        this.loginUser = this.loginUser.bind(this);
    }

    componentDidMount() {
    }

    loginUser() {
        this.props.history.push('/login')
    }

    render() {
        return (
            <nav className="navbar navbar-expand-lg">
                <div className="container-fluid">
                    <a className="navbar-brand"><img className="navbar-logo" src={logo}/></a>
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="navitem">
                            <a className="navlink">trip dashboard</a>
                        </li>
                        <li className="navitem">
                            <a className="navlink">passenger survey</a>
                        </li>
                        <li className="navitem">
                            <a className="navlink">inflight service</a>
                        </li>
                    </ul>
                    <form className="d-flex" role="search">
                        <a className="btn" href="/login">login</a>
                    </form>
                </div>
            </nav>
        );
    }
}

export default NavigationBarComponent;
