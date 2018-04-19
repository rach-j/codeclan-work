const assert = require('assert');
const Food = require('../food.js');

describe('Food', function() {
  let food;

  beforeEach(function() {
    food = new Food("Banana", 5);
  });

  it('should have a name', function() {
    assert.strictEqual(food.name, "Banana");
  });

  it('should have a replenishment value', function() {
    assert.strictEqual(food.replenishmentValue, 5);
  });

});
