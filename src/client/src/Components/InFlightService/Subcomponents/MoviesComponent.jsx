import React, {Component} from 'react';
import MovieSearchComponent from "./MovieSearchComponent";

class MoviesComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
        }
    }

    componentDidMount() {
    }

    // Movies Platform: Youtube API
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
