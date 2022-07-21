import React, {Component} from 'react';
import MovieSearchComponent from "./MovieSearchComponent";

class MoviesComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            moviesList: {
                angryBirds: "https://www.youtube.com/embed/ZL7WYCpu6pw"
            }
        }
    }

    componentDidMount() {
    }

    // Movies Platform: Youtube API

    /*
    <div className = "card opacity-100 bg-gradient">

            </div>
     */

    render() {
        return (
            <div>
            <h2>Movie Search</h2>
            <MovieSearchComponent/>
            <br/>
            </div>
        );
    }
}

export default MoviesComponent;
