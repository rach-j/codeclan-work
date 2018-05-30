import React from 'react';

const SongBox = (props) => {
    return(
      <div className="song-box">
        <div className="song-box-header">
          <h1>{props.position}</h1>
          <h2>{props.songName}</h2>
        </div>
        <div className="song-box-contents">
          <div className="image">
            <img src={props.image} alt="Song Artwork"/>
          </div>
          <div className="song-details">
            <p><b>Artists:</b> {props.artist}</p>
            <p><b>Genre:</b> {props.genre}</p>
            <p><b>Release Date:</b> {props.releaseDate}</p>
          </div>
        </div>
      </div>
    );
}

export default SongBox
