import React, {Component} from 'react';
import ChoiceButton from './ChoiceButton.js'
import './ChoicePanel.css'

class ChoicePanel extends Component {
  constructor(props) {
    super(props)

    this.handleChoiceSelect = this.handleChoiceSelect.bind(this)
  }
  handleChoiceSelect(columnChoice) {
    this.props.handleSelection(columnChoice);
  }

  render() {

    const choiceButtons = new Array(7);
    for(let i=0; i<7; i++) {
      choiceButtons.push(
        <ChoiceButton columnNumber={i} key={i} handleClick={this.handleChoiceSelect}/>
      );
    }

    return (
      <div className="choice-buttons">
        {choiceButtons}
      </div>
    )
  }
};

export default ChoicePanel;
