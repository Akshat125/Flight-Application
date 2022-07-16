import React, {Component} from 'react';
import baseImage from "../../../Images/InFlightService/Movies/cinema.png";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

class MovieSearchComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            moviesList: [
                {id: 0, name: "Penguins Of Madagascar", url: "https://www.youtube.com/embed/ub4VArS_xWk"}, // the default movie.
                {id: 1, name: "Angry Birds", url: "https://www.youtube.com/embed/ZL7WYCpu6pw"},
                {id: 2, name: "Cars 3", url: "https://www.youtube.com/embed/2LeOH9AGJQM"},
                {id: 3, name: "Toy Story 4", url: "https://www.youtube.com/embed/wmiIUN-7qhE"},
                {id: 4, name: "Kung Fu Panda 3", url: "https://www.youtube.com/embed/zAWMHuxAzxw"},
                {id: 5, name: "Despicable Me 2", url: "https://www.youtube.com/embed/yM9sKpQOuEw"},
                {id: 6, name: "Rio", url: "https://www.youtube.com/embed/P1GRO31ve5Q"},
                {id: 7, name: "Frozen 2", url: "https://www.youtube.com/embed/Zi4LMpSDccc"},
                {id: 8, name: "Coco", url: "https://www.youtube.com/embed/Ga6RYejo6Hk"},
                {id: 9, name: "Madagascar 3", url: "https://www.youtube.com/embed/laNiRXqh82Q"},
                {id: 10, name: "Hotel Transylvania", url: "https://www.youtube.com/embed/cOlhzKPX0KU"},
                {id: 11, name: "Encanto", url: "https://www.youtube.com/embed/CaimKeDcudo"}
                 ],
            searchInput: "",
            currentMovieId: 0
        }

        this.searchInputHandler = this.searchInputHandler.bind(this);
    }

    componentDidMount() {
    }

    searchInputHandler = (event) => {
        event.preventDefault();
        this.setState({searchInput: event.target.value.toLowerCase()});
    };

    render() {
        return (
            <div>
                <Form>
                    <Form.Label>Movie Search</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Penguins Of Madagascar"
                        onChange={this.searchInputHandler}
                    />
                </Form>

                <div className="d-grid gap-2">
                    {this.state.moviesList.filter((x) => {
                        if (this.state.searchInput == "") return false;
                        return x.name.toLowerCase().includes(this.state.searchInput)
                    }).map((movie) => (
                        <Button variant="primary" size="lg" key={movie.id}
                                onClick={((e) => this.setState({searchInput: "",currentMovieId: movie.id})).bind(this)}> {movie.name} </Button>))}
                </div>

                <div className="card opacity-100 bg-gradient">
                    <img className="card-img" width={80} height={650} src={baseImage}/>
                    <div className="card-img-overlay">
                        <div className="cinemaScreen">
                            <iframe
                                width="935" height="420" src={this.state.moviesList[this.state.currentMovieId].url}
                                title="Pingu Cinema" frameBorder="2"
                                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                            >
                            </iframe>
                        </div>
                    </div>
                </div>
            </div>);
    }
}

export default MovieSearchComponent;
