const Request = require('../services/request.js');

const CountryData = function(url) {
  this.url = url;
  this.data = null;
};

CountryData.prototype.get = function(onComplete) {
  const request = new Request(this.url);
  request.get((data) => {
    this.data = data;
    onComplete(this.data);
  });
};

module.exports = CountryData;
