import React, {Component} from 'react';
import Card from 'react-bootstrap/Card'
import baseImage from '../../../Images/InFlightService/Movies/cinema.png'

class MoviesComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {}

    }

    componentDidMount() {
    }

    //frame details:
    // l x w in pixels: 1386 x 853
    // Movie Platform: topLeft: (199, 70) bottomRight: (1206,643) => 1007 x 573
    /*
                        <iframe
                            src="https://www.youtube.com/embed/E7wJTI-1dvQ"
                            frameBorder="0"
                            allow="autoplay; encrypted-media"
                            allowFullScreen
                            title="video"
                        />
    */
    render() {
        return (
            <div>
                <Card style={{width:"80%", height:"80%"}}>
                    <Card.Img src= {baseImage} alt="Card Image"/>
                    <Card.ImgOverlay>

                    </Card.ImgOverlay>
                </Card>
            </div>

        );
    }
}

export default MoviesComponent;
