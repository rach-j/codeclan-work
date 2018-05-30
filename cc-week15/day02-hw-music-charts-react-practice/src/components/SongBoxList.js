import React from 'react';
import SongBox from './SongBox.js'

const SongBoxList = (props) => {
    const songsToDisplay = props.songs.map((song, index) => {
      return (
        <SongBox
          key={index}
          position={index + 1}
          songName={song["im:name"]["label"]}
          image={song["im:image"][2]["label"]}
          artist={song["im:artist"]["label"]}
          genre={song["category"]["attributes"]["label"]}
          releaseDate={song["im:releaseDate"]["attributes"]["label"]}
          >
          </SongBox>
        );
      });

      return(
        <div className="song-list">
          {songsToDisplay}
        </div>
      );
  }

  export default SongBoxList
