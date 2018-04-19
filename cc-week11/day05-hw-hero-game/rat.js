const Rat = function(name, health, dangerLevel) {
  this.name = name;
  this.health = health;
  this.dangerLevel = dangerLevel;
}

Rat.prototype.touchFood = function (food) {
  this.health += food.replenishmentValue;
  food.replenishmentValue = -this.dangerLevel;
};

module.exports = Rat;
