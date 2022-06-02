import React, {Component} from 'react';

class HomepageComponent extends Component {
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
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        <button className="btn btn-primary" onClick={this.loginUser}> Login</button>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HomepageComponent;
