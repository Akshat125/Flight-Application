import React, {Component} from 'react';
import Dropdown from 'react-bootstrap/Dropdown';

class HomepageComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
        }

        this.loginUser = this.loginUser.bind(this)
    }

    componentDidMount() {
    }

    loginUser() {
        this.props.history.push('/login')
    }

    render() {
        return (
            <div>
                <nav className="navbar navbar-expand-lg bg-black">
                    <div className="container-fluid">
                        <a className="navbar-brand" href="#">Navbar</a>
                        <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                        </button>
                        <div className="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                                <li className="nav-item">
                                    <a className="nav-link active" aria-current="page" href="#">Home</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" href="#">Link</a>
                                </li>
                                <li className="nav-item dropdown">
                                    <Dropdown>
                                        <Dropdown.Toggle variant="light">
                                            Open Menu
                                        </Dropdown.Toggle>
                                        <Dropdown.Menu>
                                            <Dropdown.Item href="#">
                                                Home Page
                                            </Dropdown.Item>
                                        </Dropdown.Menu>
                                    </Dropdown>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link disabled">Disabled</a>
                                </li>
                            </ul>
                            <form className="d-flex" role="search">
                                <input className="form-control me-2" type="username" placeholder="Username"
                                       aria-label="Username" />
                                <input className="form-control me-2" type="password" placeholder="Password"
                                       aria-label="Password" />
                                <button className="btn btn-outline-success" type="submit" >login</button>
                                <div className="space"></div>
                                <button className="btn btn-primary" onClick={this.loginUser}>Register</button>
                            </form>
                        </div>
                    </div>
                </nav>
            </div>
        );
    }
}

export default HomepageComponent;
