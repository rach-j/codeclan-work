import React, {Component} from 'react';

class PlayerTurnComponent extends Component {

  render(){
    let message = ''
    
    if(this.props.winner) {
      message = `${this.props.activePlayer} player wins!`
    } else {
      message = `${this.props.activePlayer} player's turn`
    }
    return (
      <div className="player-turn">
        <h2>{message}</h2>
      </div>
    )
  }
}

export default PlayerTurnComponent;
