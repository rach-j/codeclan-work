const countriesArray = [];
let displayCountriesArray = [];
const regionsArray = [];

document.addEventListener('DOMContentLoaded', () => {
  const url = 'https://restcountries.eu/rest/v2/all';
  makeRequest(url, requestComplete);

  const selectRegion = document.querySelector('#region-select');
  selectRegion.addEventListener('change', handleChangeRegion);

  const selectCountry = document.querySelector('#country-select');
  selectCountry.addEventListener('change', handleChangeCountry);
});

const makeRequest = function(url, callback) {
  const request = new XMLHttpRequest();
  request.open('GET', url);
  request.send();

  request.addEventListener('load', callback);
}

const requestComplete = function() {
  if (this.status !== 200) return; // in real world would do error handling here
  const jsonString = this.responseText;
  const countries = JSON.parse(jsonString);
  putCountriesInArray(countries);
  putRegionsInArray(countries);
  populateRegionsList(regionsArray);
  populateCountriesList();
}

const putCountriesInArray = function(countries) {
  countries.forEach((country) => {
    countriesArray.push(country);
  });
}

const putRegionsInArray = function(countries) {
  countries.forEach((country) => {
    if (!regionsArray.includes(country.region)) {
      regionsArray.push(country.region);
    }
  });
}

const populateRegionsList = function(regionsArray) {
  const select = document.querySelector('#region-select');
  select.innerHTML = '';
  for (let i = 0; i < regionsArray.length; i++) {
    const option = document.createElement('option');
    option.textContent = regionsArray[i];
    select.appendChild(option);
  }
}

const populateCountriesList = function(region) {
  const select = document.querySelector('#country-select');
  select.innerHTML = '';
  getCountriesFromRegion(region);
  for(let i = 0; i < displayCountriesArray.length; i++) {
    const option = document.createElement('option');
    option.textContent = displayCountriesArray[i].name;
    option.value = i;
    select.appendChild(option);
  }
}

const getCountriesFromRegion = function(region) {
  if (region === undefined) {
    displayCountriesArray = [...countriesArray];
  }
  else {
    displayCountriesArray = countriesArray.filter( (country) => {
      return country.region === region;
    });
  }
}

const handleChangeCountry = function(event) {
  const selected = this.value;
  const countryDetails = document.querySelector('#country-details');
  countryDetails.innerHTML = '';
  const country = displayCountriesArray[selected];
  printOutDetails(country, countryDetails);
  const borderingCountryCodesArray = country.borders;
  const borderingCountriesArray = displayCountriesArray.filter((country) => {return borderingCountryCodesArray.includes(country.alpha3Code)});
  const borderCountryDetails = document.querySelector('#bordering-country-details');
  borderCountryDetails.innerHTML = '';
  borderingCountriesArray.forEach((country) => {printOutDetails(country, borderCountryDetails)});
  console.dir(country);
}

const handleChangeRegion = function(event) {
  populateCountriesList(this.value);
}

const printOutDetails = function(country, countryDetails) {
  const liName = document.createElement('li');
  liName.id = "liName";
  liName.textContent = country.name;
  countryDetails.appendChild(liName);
  const liPopulation = document.createElement('li');
  liPopulation.textContent = `Population: ${numberWithCommas(country.population)}`;
  countryDetails.appendChild(liPopulation);
  const liCapital = document.createElement('li');
  liCapital.textContent = `Capital city: ${country.capital}`;
  countryDetails.appendChild(liCapital);
}


const numberWithCommas = (x) => {
  return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
