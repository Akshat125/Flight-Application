import React, {Component} from 'react';

class EmployeeLoginComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            userId: '',
            password: ''
        }

        this.insertUserIdHandler = this.insertUserIdHandler.bind(this);
        this.insertPasswordHandler = this.insertPasswordHandler.bind(this);
        this.saveLogin = this.saveLogin.bind(this);
        this.cancel = this.cancel.bind(this);
    }

    componentDidMount() {
    }

    insertUserIdHandler = (event) => {
        this.setState({userId: event.target.value});
    }

    insertPasswordHandler = (event) => {
        this.setState({password: event.target.value});
    }

    saveLogin = (event) => {
        // TODO: make API call
        this.props.history.push('/')
    }

    cancel = (event) => {
        this.props.history.push('/')
    }

    render() {
        return (
            <div>
                <div className = "container">
                    <div className= "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Add Client</h3>
                            <div className="card-body">
                                <form>

                                    <div className="form-group">
                                        <label> User Id: </label>
                                        <input placeholder="User Id" name = "userId" className="form-control"
                                               value = {this.state.userId} onChange={this.insertUserIdHandler}/>
                                    </div>

                                    <div className="form-group">
                                        <label> Password: </label>
                                        <input placeholder="Password" name = "password" className="form-control"
                                               value = {this.state.password} onChange={this.insertPasswordHandler}/>
                                    </div>

                                    <button className="btn btn-success" onClick={this.saveLogin}>Confirm</button>
                                    <button className="btn btn-danger" onClick={this.cancel} style={{marginLeft: "9px"}}>Return</button>
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
