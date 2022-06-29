import React, {Component} from 'react';
import baseImage from '../../../Images/InFlightService/Movies/cinema.png'

class MoviesComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
        }

    }

    componentDidMount() {
    }

    // Movie Platform: Youtube API

    /*

    */
    render() {
        return (
            <div className = "card opacity-100 bg-gradient">
                <img className="card-img" width={100} height={750} src = {baseImage}/>
            </div>

        );
    }
}

export default MoviesComponent;
