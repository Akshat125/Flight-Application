import React, {Component} from 'react';
import baseImage from '../../../Images/InFlightService/Movies/cinema.png'

class MoviesComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            moviesList: {
                penguinsOfMadagascar: "https://www.youtube.com/embed/ub4VArS_xWk",
                angryBirds: "https://www.youtube.com/embed/ZL7WYCpu6pw"
            }
        }

    }

    componentDidMount() {
    }

    // Movies Platform: Youtube API

    render() {
        return (
            <div className = "card opacity-100 bg-gradient">
                <img className="card-img" width={100} height={750} src = {baseImage}/>
                <div className = "card-img-overlay">
                    <div className = "cinemaScreen">
                    <iframe
                            width="915" height="410" src={this.state.moviesList.penguinsOfMadagascar}
                            title="Pingu Cinema" frameBorder="2"
                            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                            >
                    </iframe>
                    </div>
                </div>
            </div>

        );
    }
}

export default MoviesComponent;
