const CharacterData = require('./models/character_data.js');
const CharacterView = require('./views/character_view.js');

document.addEventListener('DOMContentLoaded', () => {
const characterSelect = document.querySelector('#character-select');
const characterContainer = document.querySelector('#character-detail-view');
const characterView = new CharacterView(characterSelect, characterContainer);
const characterData = new CharacterData('https://rickandmortyapi.com/api/character/');

characterSelect.addEventListener('change', (event) => {
  const selectedIndex = event.target.value;
  if (selectedIndex == 0) {
      console.log('View all has been selected');
    characterView.populatePage(characterData.data);
    console.log(characterData.data);
  } else {
    const selectedCharacter = characterData.data[selectedIndex];
    characterView.renderDetail(selectedCharacter);
  }
  // Ask if better way to do
});

  characterData.getData((data) => {
    characterView.renderSelect(data)
    characterView.populatePage(data)});
});
