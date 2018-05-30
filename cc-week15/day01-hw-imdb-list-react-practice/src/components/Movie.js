import React, {Component} from 'react';

class Movie extends Component {
  render() {
    let showTimes = "";
    if(this.props.showTimeAvailable) {
      showTimes = "Showtimes"
      console.log(showTimes);
    }

    return(
      <div className="movie">
        <img src={process.env.PUBLIC_URL + '/plusicon.png'} alt="Plus Icon"/>
        <div className="movieTitle">
          {this.props.movieTitle}
        </div>
        <div className = "showTimeLink">
          {showTimes}
        </div>
      </div>
    );
  }
}

export default Movie
