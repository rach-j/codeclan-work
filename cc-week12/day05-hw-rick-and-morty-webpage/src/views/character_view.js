const CharacterView = function (selectElement, characterContainer) {
  this.selectElement = selectElement;
  this.characterContainer = characterContainer;
}

CharacterView.prototype.renderSelect = function (characterData) {
  characterData.forEach((character, index) => {
    const characterOption = document.createElement('option');
    characterOption.textContent = character.name;
    characterOption.value = index;
    this.selectElement.appendChild(characterOption);
  });
}

CharacterView.prototype.populatePage = function (characterData) {
  const characterList = document.querySelector('#character-detail-view');
  characterList.innerHTML = '';
  characterData.forEach((character) => {
    if (character.name === "View all") {
      return;
      // Ask if better way to do
    }
    const characterListItem = document.createElement('div');
    characterListItem.classList.add('character-item');
    const name = buildTextElement('h2', character.name);
    characterListItem.appendChild(name);
    const image = buildImageElement(character.image);
    characterListItem.appendChild(image);
    const gender = buildTextElement('p', `Gender: ${character.gender}`);
    characterListItem.appendChild(gender);
    const species = buildTextElement('p', `Species: ${character.species}`);
    characterListItem.appendChild(species);
    const origin = buildTextElement('p', `Origin: ${character.origin.name}`);
    characterListItem.appendChild(origin);
    const status = buildTextElement('p', `Status: ${character.status}`);
    characterListItem.appendChild(status);
    // Ask how to get bold for first bit whilst still keeping all on one line
    characterList.appendChild(characterListItem);
  });
}

CharacterView.prototype.renderDetail = function (character) {
  const characterList = document.querySelector('#character-detail-view');
  this.populatePage([character]);
};

const buildTextElement = function (tag, value) {
  const textElement = document.createElement(tag);
  textElement.textContent = value;
  return textElement;
}

const buildImageElement = function(value) {
  const imageElement = document.createElement('img');
  imageElement.src = value;
  return imageElement;
}





module.exports = CharacterView;
