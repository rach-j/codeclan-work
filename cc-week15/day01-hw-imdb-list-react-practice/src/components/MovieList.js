import React, {Component} from 'react';
import Movie from './Movie.js';

class MovieList extends Component {
  render() {
    const movieNodes = this.props.movies.map((movie) => {
      return (<Movie movieTitle={movie.title} key={movie.id} showTimeAvailable = {movie.showTimeAvaiable}>
        </Movie>
      );
    });

    return(
      <div className="movie-list">
        {movieNodes}
      </div>
    );
  }
}

export default MovieList
