import React, {Component} from 'react';
import Swal from 'sweetalert2';
import UserLoginController from "../../Controller/UserLoginController";

const errors = {
    invalidUsername: "username contains the following combination of characters: \"&and&\"",
    invalidPassword: "password contains the following combination of characters: \"&and&\"",
    genericError: "an unexpected error occurred"
};

class EmployeeLoginComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            currentUsername: "",
            currentPassword: "",
            loggedInUserCredentials: {username: null, password: null}
        }

        this.insertUserIdHandler = this.insertUserIdHandler.bind(this);
        this.insertPasswordHandler = this.insertPasswordHandler.bind(this);
        this.register = this.register.bind(this);
        this.login = this.login.bind(this);
    }

    componentDidMount() {
    }

    insertUserIdHandler = (event) => {
        this.setState({currentUsername: event.target.value});
    }

    insertPasswordHandler = (event) => {
        this.setState({currentPassword: event.target.value});
    }

    register = (event) => {
        event.preventDefault();
        this.state.registeredUsers.push();
        const isValidCredentials = !this.state.currentUsername.includes("&and&") && !this.state.currentPassword.includes("&and&");
        if (isValidCredentials) {
          UserLoginController.putUser(this.state.currentUsername, this.state.currentPassword).then(res => {
              if (res) {
                  Swal.fire({
                      icon: 'success',
                      title: 'user registered successfully',
                      showConfirmButton: false,
                      timer: 2000
                  });
              } else {
                  Swal.fire({
                      icon: 'error',
                      title: errors.genericError,
                      showConfirmButton: false,
                      timer: 2000
                  });
              }
          });
        } else {
            Swal.fire({
                icon: 'error',
                title: !this.state.currentUsername.includes("&and&") ? errors.invalidUsername : errors.invalidPassword,
                showConfirmButton: false,
                timer: 2000
            });
        }
        this.props.history.push('/');
    }

    login = (event) => {

        this.props.history.push('/');
        return null;
    }

    render() {
        return (
            <div>
                <div className = "container">
                    <div className= "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">User Login</h3>
                            <div className="card-body">
                                <h6 className="card-subtitle mb-2 text-muted">Note: Please ensure that the password does not contain the following combination of characters: “&and&” </h6>
                                <form>
                                    <div className="form-group">
                                        <label> Username: </label>
                                        <input placeholder="username" name = "userId" className="form-control"
                                               value = {this.state.currentUsername} onChange={this.insertUserIdHandler}/>
                                    </div>

                                    <div className="form-group">
                                        <label> Password: </label>
                                        <input placeholder="password" name = "password" className="form-control"
                                               value = {this.state.currentPassword} onChange={this.insertPasswordHandler}/>
                                    </div>

                                    <button className="btn btn-success" onClick={this.register}>Register</button>
                                    <button className="btn btn-info" onClick={this.login} style={{marginLeft: "9px"}}>Login</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default EmployeeLoginComponent;
