import React, {Component} from 'react';

class FooterComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
        }

    }

    componentDidMount() {
    }

    render() {
        return (
            <footer className="footer">
                EIST Project 2022 | @Team: Debugging Penguins | @Authors: Akshat Tandon, Eben Jowie Haezer, Jonas Arnold, Kilian Burger, Saiyam Jain
            </footer>
        );
    }
}

export default FooterComponent;
