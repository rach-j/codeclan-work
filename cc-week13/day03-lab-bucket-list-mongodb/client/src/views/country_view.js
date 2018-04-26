const CountryView = function(selectElement, countryContainer) {
  this.selectElement = selectElement;
  this.countryContainer = countryContainer;
  this.countries = [];
}

CountryView.prototype.addCountry = function (country) {
  this.countries.push(country);
  this.renderContainer(country);
};

CountryView.prototype.renderSelect = function (countryData) {
  const defaultMessage = document.createElement('option');
  defaultMessage.textContent = "Select a country";
  this.selectElement.appendChild(defaultMessage);

  countryData.forEach((country, index) => {
    const countryOption = document.createElement('option');
    countryOption.textContent = country.name;
    countryOption.value = index;
    this.selectElement.appendChild(countryOption);
  });
};

CountryView.prototype.renderContainer = function (selectedCountry) {
  console.log(this.countries);
  if(this.countries.length <= 1) {
    const header = document.createElement('h3');
    header.textContent = "Countries I want to visit:"
      this.countryContainer.appendChild(header);
  }
  const countryName = document.createElement('b');
  countryName.textContent = selectedCountry.country.name;
  const additionalNotes = document.createElement('p');
  additionalNotes.textContent = selectedCountry.notes;
  this.countryContainer.appendChild(countryName);
  this.countryContainer.appendChild(additionalNotes);
};

CountryView.prototype.clear = function () {
  this.countries = [];
  this.countryContainer.innerHTML = '';
};

module.exports = CountryView;
