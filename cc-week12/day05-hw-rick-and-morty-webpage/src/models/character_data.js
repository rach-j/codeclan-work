const Request = require('../helpers/request.js');

const CharacterData = function(url) {
  this.url = url;
  this.data = null;
}

CharacterData.prototype.getData = function (onComplete) {
  const request = new Request(this.url);
  request.get((data) => {
    this.data = data.results;
    this.data.unshift({"name": "View all"});
    // Ask if better way to do
    onComplete(this.data);
  });
}

module.exports = CharacterData;
