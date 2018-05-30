import React, {Component} from 'react';
import SongBoxList from '../components/SongBoxList.js'

class ChartsContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      songs: []
    }
  }

  componentDidMount() {
    const url ='https://itunes.apple.com/gb/rss/topsongs/limit=20/json';
    const request = new XMLHttpRequest();
    request.open('GET', url);

    request.addEventListener('load', () => {
      if (request.status !== 200) return;
      const songData = JSON.parse(request.responseText);
      this.setState({songs: songData["feed"]["entry"]});
      console.log(this.state.songs);
    });
    request.send();
  }

  render() {
    return(
      <div className="charts-container">
      <h1>Current UK chart list</h1>
      <SongBoxList songs={this.state.songs}/>
      </div>
    );
  }

}

export default ChartsContainer
