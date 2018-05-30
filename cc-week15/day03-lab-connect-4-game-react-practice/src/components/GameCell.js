import React, {Component} from 'react';
import './GameCell.css';


class GameCell extends Component {

  render() {
    let imgSource = ''
    if(this.props.state === "Yellow") {
      imgSource = "https://upload.wikimedia.org/wikipedia/en/thumb/f/fb/Yellow_icon.svg/1024px-Yellow_icon.svg.png"
    } else if(this.props.state === "Red") {
      imgSource = "http://www.stickpng.com/assets/images/58afdad6829958a978a4a693.png"
    } else {
      // imgSource = "https://cdn1.iconfinder.com/data/icons/navigation-elements/512/round-empty-circle-function-512.png"
      imgSource = "http://www.clker.com/cliparts/K/l/Q/3/c/0/grey-circle-white-background.svg.med.png"
    }

    return (
      // <div className={this.props.RowId}>
      //   <p>{this.props.state}</p>
      // </div>
      <div className="circle">
        <img src={imgSource} alt="Circle Image"/>
      </div>

    );
  }
}

export default GameCell;
