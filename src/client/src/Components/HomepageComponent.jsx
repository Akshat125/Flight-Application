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

            </div>
        );
    }
}

export default HomepageComponent;
