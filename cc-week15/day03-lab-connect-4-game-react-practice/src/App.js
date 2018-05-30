import React, { Component } from 'react';
import Header from './components/Header.js'
import GameContainer from './containers/GameContainer.js'


class App extends Component {
  render() {
    return (
      <div>
        <Header />
        <GameContainer />
      </div>

    );
  }
}

export default App;
