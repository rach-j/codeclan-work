const assert = require('assert');
const Rat = require('../rat.js');
const Food = require('../food.js')

describe('Rat', function() {
  let rat;
  let food;

  beforeEach(function() {
    rat = new Rat("Ratty", 10, 3);
    food = new Food("Banana", 5);
  });

  it('should have a name', function () {
    assert.strictEqual(rat.name, "Ratty");
  });

  it('should have a danger level', function () {
    assert.strictEqual(rat.dangerLevel, 3);
  });

  it('should have a health level', function () {
    assert.strictEqual(rat.health, 10);
  });

  it('should be able to touch food', function () {
    rat.touchFood(food);
    assert.strictEqual(rat.health, 15);
    assert.strictEqual(food.replenishmentValue, -3);
  });

});
