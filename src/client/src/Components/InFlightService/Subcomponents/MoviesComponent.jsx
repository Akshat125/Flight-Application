import React, {Component} from 'react';

class MoviesComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
        }

    }

    componentDidMount() {
    }

    //frame details:
    // l x w in pixels: 1386 x 853
    // Movie Platform: topLeft: (199, 70) bottomRight: (1206,643) => 1007 x 573

    render() {
        return (
            <div>

                <div>
                    <iframe
                        src="https://www.youtube.com/embed/E7wJTI-1dvQ"
                        frameBorder="0"
                        allow="autoplay; encrypted-media"
                        allowFullScreen
                        title="video"
                    />
                    {" "}
                </div>

            </div>
        );
    }
}

export default MoviesComponent;
