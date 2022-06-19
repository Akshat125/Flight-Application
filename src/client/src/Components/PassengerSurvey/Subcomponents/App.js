import React from 'react';
import ReactDOM from 'react-dom';
import RatingComponent from './RatingComponent';

class App extends React.Component {
  constructor() {
    super();

    this.state = {
      rating: 1
    };
  }

  onStarClick(nextValue, prevValue, name) {
    this.setState({rating: nextValue});
  }

  render() {
    const {rating} = this.state;

    return (
      <div>
        <h2>Rating from state: {rating}</h2>
        <RatingComponent
          name="rate1"
          starCount={5}
          value={rating}
          onStarClick={this.onStarClick.bind(this)}
        />
      </div>
    );
  }
}

ReactDOM.render(
  <App />,
  document.getElementById('root')
);