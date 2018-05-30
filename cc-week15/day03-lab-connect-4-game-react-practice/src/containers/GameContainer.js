import React, {Component} from 'react';
import PlayerTurnComponent from '../components/PlayerTurnComponent.js';
import {setupBoard} from '../models/GameLogic.js';
import ChoicePanel from '../components/ChoicePanel.js'
import GameBoard from '../components/GameBoard.js';
import {tokenDrop} from '../models/GameLogic.js'
import {checkForWinner} from '../models/GameLogic.js'


class GameContainer extends Component {
  constructor(props){
    super(props);
    this.state = {
      activePlayer: "Yellow",
      boardState: setupBoard(),
      columnSelected: null,
      winner: false
    }

    this.columnButtonClick = this.columnButtonClick.bind(this);
  }

  columnButtonClick(columnNumber){
    const results = tokenDrop(columnNumber, this.state.activePlayer, this.state.boardState);
    const newGameState = results[0];
    this.setState({boardState: newGameState});
    console.log("Token position row:", results[1]);
    console.log("Token position column:", results[2]);
    console.log("State:", newGameState[results[1]][results[2]].state);
    const winner = checkForWinner(results[1],results[2], newGameState, this.state.activePlayer);
    console.log("Winner:", winner);
    if(winner) {
      this.setState({winner: true})
    } else {
    this.switchPlayer();
  }
  }

  switchPlayer(){
    if(this.state.activePlayer === "Yellow"){
      this.setState({activePlayer: "Red"})
    } else {
      this.setState({activePlayer: "Yellow"})
    }
  }

  render(){
    return (
      <div>
        <PlayerTurnComponent activePlayer={this.state.activePlayer} winner={this.state.winner}/>
        <ChoicePanel handleSelection={this.columnButtonClick} />
        <GameBoard boardState={this.state.boardState} activePlayer={this.state.activePlayer} />
      </div>
    )
  }
}

export default GameContainer;
