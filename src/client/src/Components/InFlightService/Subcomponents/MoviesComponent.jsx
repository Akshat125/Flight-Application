import React, {Component} from 'react';
import Card from 'react-bootstrap/Card'
import baseImage from '../../../Images/InFlightService/Movies/cinema.png'

class MoviesComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
        }

    }

    componentDidMount() {
    }

    //frame details:
    // l x w in pixels:
    // Movie Platform:
    /*

    */
    render() {
        return (
            <div>
                <Card className = "bg-opacity-100" style={{ width: '60rem' }}>
                    <Card.Img src= {baseImage}  alt="Card Image"/>
                    <Card.ImgOverlay>

                    </Card.ImgOverlay>
                </Card>
            </div>

        );
    }
}

export default MoviesComponent;
