const Park = function() {
  this.enclosure = [];
};

Park.prototype.addDinosaur = function (dinosaur) {
  this.enclosure.push(dinosaur);
};

Park.prototype.removeDinosaursOfType = function (dinosaurType) {
  for(let i = this.enclosure.length - 1; i >= 0; i--) {
    if (this.enclosure[i].type === dinosaurType) {
      this.enclosure.splice(i,1);
    }
  }
};

Park.prototype.getDinosaursWithMoreThan2OffspringCount = function () {
    dinosaursWithMoreThan2Offspring = [];
    for(const dinosaur of this.enclosure) {
      if (dinosaur.numberOfOffspring > 2) {
        dinosaursWithMoreThan2Offspring.push(dinosaur);
      }
    }
    return dinosaursWithMoreThan2Offspring;
};

Park.prototype.numberOfDinosaursAfterYear = function (year) {
  if(year < 0) {
    return;
  }
  let total = 0;

  if (year === 0) {
    return this.enclosure.length;
  } else {
    for (const dinosaur of this.enclosure) {
      let totalForDino =  1;
      for (let i = 1; i <= year; i++) {
        totalForDino = totalForDino + totalForDino * dinosaur.numberOfOffspring;
      }
      total += totalForDino;
    }
  }
  return total;
};

module.exports = Park;
