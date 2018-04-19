const beersArray = ['Select a beer'];

document.addEventListener('DOMContentLoaded', () => {
  const url = 'https://api.punkapi.com/v2/beers';
  makeRequest(url, requestComplete);

  const selectBeer = document.querySelector('#beer-select');
  selectBeer.addEventListener('change', handleChangeBeer);
});

const makeRequest = function (url, callback) {
  const request = new XMLHttpRequest();
  request.open('GET', url);
  request.send();
  request.addEventListener('load', callback);
}

const requestComplete = function () {
  if (this.status !== 200) return;
  const jsonString = this.responseText;
  const beers = JSON.parse(jsonString);
  putBeersInArray(beers);
  populateDropDownList();
  populatePage(beers);
}

const putBeersInArray = function(beers) {
  beers.forEach((beer) => {beersArray.push(beer)});
}

const populateDropDownList = function () {
  const select = document.querySelector('#beer-select');
  select.innerHTML = '';
  for (let i = 0; i < beersArray.length; i++) {
    const option = document.createElement('option');
    option.textContent = beersArray[i].name;
    option.value = i;
    select.appendChild(option);
  }
}

const populatePage = function (beers) {
  const beerList = document.querySelector('#beer-list');

  beers.forEach((beer) => {
    const beerListItem = document.createElement('div');
    beerListItem.classList.add('beer-item');
    const name = buildTextElement('h2', beer.name);
    beerListItem.appendChild(name);
    const image = buildImageElement(beer.image_url);
    beerListItem.appendChild(image);

    displayIngredients(beer.ingredients, beerListItem);

    beerList.appendChild(beerListItem);
  });
}

const buildTextElement = function (tag, value) {
  const textElement = document.createElement(tag);
  textElement.textContent = value;
  return textElement;
}

const buildImageElement = function(value) {
  const imageElement = document.createElement('img');
  imageElement.src = value;
  imageElement.width = 120;
  return imageElement;
}

const displayIngredients = function(ingredients, beerListItem) {
  const ingredientsTitle = buildTextElement('h3', 'Ingredients:')
  beerListItem.appendChild(ingredientsTitle);
  const hopsTitle = buildTextElement('h4', 'Hops:')
  beerListItem.appendChild(hopsTitle);
  ingredients.hops.forEach((hop) => {
    let hopItem = buildTextElement('li', hop.name);
    beerListItem.appendChild(hopItem)
  });
  const maltTitle = buildTextElement('h4', 'Malt:')
  beerListItem.appendChild(maltTitle);
  ingredients.malt.forEach((malt) => {
    let maltItem = buildTextElement('li', malt.name);
    beerListItem.appendChild(maltItem)
  });
  const yeastTitle = buildTextElement('h4', 'Yeast:')
  beerListItem.appendChild(yeastTitle);
  const yeastItem = buildTextElement('li', ingredients.yeast);
  beerListItem.appendChild(yeastItem);
}

const handleChangeBeer = function(event) {
  const selected = this.value;
  const beerToDisplay = beersArray[selected];
  console.log(beerToDisplay);
  const beerList = document.querySelector('#beer-list');
  beerList.innerHTML = '';
  populatePage([beerToDisplay]);
}
