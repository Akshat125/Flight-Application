import React, {Component} from 'react';
import logo from '../../../Images/flightLogo.png';
import { render } from "react-dom";
import SlidingPane from "react-sliding-pane";
import "react-sliding-pane/dist/react-sliding-pane.css";
import UserLoginController from '../../../Controller/UserLoginController.js';
import AirlineController from '../../../Controller/AirlineController.js';
import Swal from "sweetalert2";

class NavigationBarComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            showLogin: false,
            username_fail: false,
            password_fail: false,
            logged_in: false,
            logged_in_as: ""
        }
    }

    componentDidMount() {
    }

    showLogin = () =>   {
        this.setState({showLogin: true});
        setTimeout(() => console.log(), 200);
    }

    sanitise = () =>    {
        document.getElementById("username").value = document.getElementById("username").value.replace(/[^\w]/gi, '');
        document.getElementById("password").value = document.getElementById("password").value.replace(/[^\w]/gi, '');
    }

    loginUser = async () => {
        this.setState({username_fail: false, password_fail: false});

        const user = document.getElementById("username").value;
        const pass = document.getElementById("password").value;

        if (user.length == 0)  {
            this.setState({username_fail: true});
            return;
        }
        if (pass.length < 8)   {
            this.setState({password_fail: true});
            return;
        }

        const resp = await AirlineController.checkLogin(user, pass);
        if (resp)   {
            Swal.fire({
                icon: 'success',
                text: 'Successfully logged in as ' + user,
                showConfirmButton: false,
                timer: 2000
            });
            this.props.setLoggedIn(true);
            this.props.setUser(user);
            this.props.setPass(pass);
            this.props.loadSavedFlights();
            this.setState({logged_in: true, logged_in_as: user, showLogin: false});
        }
        else {
            Swal.fire({
                icon: 'error',
                html: '<h3>Unable to login</h3><br>Username or password may be incorrect.<br>Alternatively, you may be disconnected from the server.',
                showConfirmButton: false,
                timer: 2000
            });
        }
    }

    logoutUser = async () =>    {
        this.setState({username_fail: false, password_fail: false, logged_in: false, logged_in_as: ""});
        this.props.setLoggedIn(false);
        this.props.setUser("");
        this.props.setPass("");
        Swal.fire({
            icon: 'success',
            text: 'Successfully logged out',
            showConfirmButton: false,
            timer: 4000
        });
    }

    registerUser = async () =>  {
        this.setState({username_fail: false, password_fail: false});

        const user = document.getElementById("username").value;
        const pass = document.getElementById("password").value;

        if (user.length == 0)  {
            this.setState({username_fail: true});
            return;
        }
        if (pass.length < 8)   {
            this.setState({password_fail: true});
            return;
        }

        const resp = await UserLoginController.putUser(user, pass);
        if (resp)   {
            Swal.fire({
                icon: 'success',
                text: 'Account successfully registered, you may now log in',
                showConfirmButton: false,
                timer: 2000
            });
        }
        else {
            Swal.fire({
                icon: 'error',
                html: '<h3>Unable to register account</h3><br><Username or password may be incorrect.<br>Alternatively, you may be disconnected from the server.',
                showConfirmButton: false,
                timer: 4000
            });
        }
    }

    render() {
        return (
            <nav className="navbar navbar-expand-lg">
                <div className="container-fluid">
                    <a className="navbar-brand"><img className="navbar-logo" src={logo}/></a>
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="navitem">
                            <a onClick={this.props.clickedDash} className="navlink">trip dashboard</a>
                        </li>
                        <li className="navitem">
                            <a onClick={this.props.clickedSurvey} className="navlink">passenger survey</a>
                        </li>
                        <li className="navitem">
                            <a onClick={this.props.clickedService} className="navlink">inflight service</a>
                        </li>
                    </ul>
                    <p>{this.state.logged_in ? "logged in as " + this.state.logged_in_as : null}</p>
                    <div>{this.state.logged_in ? <button className="logout-btn" onClick={this.logoutUser}>logout</button> : <button className="login-btn" onClick={this.showLogin}>login</button>}</div>
                </div>
                <SlidingPane className="loginpane" width="35vw" isOpen={this.state.showLogin} onRequestClose={() => this.setState({showLogin: false})}>
                    <div>
                        <h1> login </h1>

                        <p>
                            Login to see your saved flights, or register a new account.
                        </p>

                        <h2> username </h2>
                        <input id="username" type="text" required={true} onInput={this.sanitise} />

                        <h2> password </h2>
                        <input id="password" type="password" required={true} onInput={this.sanitise} />

                        <br/>

                        <button onClick={this.loginUser}>login</button>
                        <button onClick={this.registerUser}>register</button>

                        <br/>

                        <div>
                            Username and password may not contain whitespace or special characters apart from underscores.
                        </div>

                        <div>
                            {this.state.password_fail ? <p className="blinkredtext">Password must be at least 8 characters.</p>  : <p>Password must be at least 8 characters.</p>}
                        </div>
                    </div>
                </SlidingPane>
            </nav>
        );
    }
}

export default NavigationBarComponent;
