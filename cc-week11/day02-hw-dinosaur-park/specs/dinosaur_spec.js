const assert = require('assert');
const Dinosaur = require('../dinosaur.js');

describe('Dinosaur', function() {

  let dinosaur;

  beforeEach(function() {
    dinosaur = new Dinosaur("Tyrannosaurus", 3);
  });

  it('should have a type', function() {
    const result = dinosaur.type;
    assert.strictEqual(result, "Tyrannosaurus");
  });

  it('should have a number of offspring per year', function() {
    const result = dinosaur.numberOfOffspring;
    assert.strictEqual(result, 3);
  });

});
