import React, {Component} from 'react';

class MoviesComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
        }

    }

    componentDidMount() {
    }

    //TODO: Add different movie options and embed videos.

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
