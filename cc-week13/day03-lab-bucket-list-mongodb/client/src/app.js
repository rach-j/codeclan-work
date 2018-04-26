const CountryView = require('./views/country_view.js');
const CountryData = require('./models/country_data.js');
const Request = require('./services/request.js');

const request = new Request('http://localhost:3000/api/countries_to_visit');

let selectedCountry = "";

const appStart = function() {

  const addCountryToBucketList = function(selectedCountry) {
    countryView.addCountry(selectedCountry);
  }

  const onCountrySelected = function(event) {
    const selectedIndex = event.target.value;
    selectedCountry = countryData.data[selectedIndex];
    // request.post(addCountryToBucketList, selectedCountry);
  }

  const onAddNotesButtonClick = function(event) {
    event.preventDefault();
    console.log('form submitted');
    const notes = event.target.notes;
    console.log(event);

    const newEntry = {
      country: selectedCountry,
      notes: notes.value
    }
    request.post(addCountryToBucketList, newEntry);
  }

  const onDataGot = function(data) {
    countryView.renderSelect(data);
  }

  const onCountriesRequestComplete = function(allCountries) {
    allCountries.forEach((country) => {countryView.addCountry(country)});
  }

  const onDeleteAll = function() {
    countryView.clear();
  }

  const onDeleteButtonClick = function() {
    request.delete(onDeleteAll);
  }

  request.get(onCountriesRequestComplete);

  const countrySelect = document.querySelector('#country-select');
  countrySelect.addEventListener('change', onCountrySelected);

  const notesInput = document.querySelector('form');
  notesInput.addEventListener('submit', onAddNotesButtonClick);

  const countryContainer = document.querySelector('#country-container');
  const countryView = new CountryView(countrySelect, countryContainer);

  const countryData = new CountryData('https://restcountries.eu/rest/v2/all');
  countryData.get(onDataGot);

  const deleteAllButton = document.querySelector('#button-delete-all');
  deleteAllButton.addEventListener('click', onDeleteButtonClick);
}

document.addEventListener('DOMContentLoaded', appStart);
