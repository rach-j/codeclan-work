import React, {Component} from 'react';
import './ChoiceButton.css'

class ChoiceButton extends Component {
  constructor(props) {
    super(props)
    this.onChoiceButtonClicked = this.onChoiceButtonClicked.bind(this)
  }

  onChoiceButtonClicked(event) {
    this.props.handleClick(event.target.value)
  }

  render() {

    return (
        <button type="button" value={this.props.columnNumber} className="column-button" onClick={this.onChoiceButtonClicked}>{this.props.columnNumber +1 }</button>
    )
  }
}

export default ChoiceButton;
