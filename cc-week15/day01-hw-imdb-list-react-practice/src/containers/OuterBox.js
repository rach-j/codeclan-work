import React, {Component} from 'react';
import BoxTitle from '../components/BoxTitle.js';
import MovieList from '../components/MovieList.js';
import SeeMore from '../components/SeeMore.js';
import GetShowTimesBox from '../components/GetShowTimesBox.js';

class OuterBox extends Component {
  constructor(props) {
    super(props);
    this.state = {
      movies: [
        {id: 1, title: 'Sherlock Gnomes', showTimeAvaiable: true},
        {id: 2, title: 'Life of the Party', showTimeAvaiable: false},
        {id: 3, title: 'Breaking In', showTimeAvaiable: false},
        {id: 4, title: 'Entebbe', showTimeAvaiable: false},
        {id: 5, title: 'Redoubtable', showTimeAvaiable: false},
        {id: 6, title: 'How to Talk to Girls at Parties', showTimeAvaiable: false},
        {id: 7, title: 'Revenge', showTimeAvaiable: false},
        {id: 8, title: 'Anon', showTimeAvaiable: false},
        {id: 9, title: 'The Cured', showTimeAvaiable: false}
      ]
    }
  }

  render() {
    return(
      <div className="outer-box">
        <BoxTitle/>
        <MovieList movies={this.state.movies}/>
        <SeeMore/>
        <GetShowTimesBox/>
      </div>
    );
  }
}

export default OuterBox
