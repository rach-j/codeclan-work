const assert = require('assert');
const Park = require('../park.js');
const Dinosaur = require('../dinosaur.js')

describe('Park', function() {

  let park;
  let dinosaur1;
  let dinosaur2;
  let dinosaur3;
  let dinosaur4;

  beforeEach(function() {
    park = new Park();
    dinosaur1 = new Dinosaur("Tyrannosaurus", 3);
    dinosaur2 = new Dinosaur("Tyrannosaurus", 2);
    dinosaur3 = new Dinosaur("Tyrannosaurus", 3);
    dinosaur4 = new Dinosaur("Velociraptor", 3);
  });

  it('should start empty', function() {
    const result = park.enclosure;
    assert.deepStrictEqual(result, []);
  });

  it('should add dinosaur', function() {
    park.addDinosaur(dinosaur1);
    const result = park.enclosure;
    assert.deepStrictEqual(result, [dinosaur1]);
  });

  it('should remove all dinosaurs of a particular type where type is in enclosure', function() {
    park.addDinosaur(dinosaur1);
    park.addDinosaur(dinosaur2);
    park.addDinosaur(dinosaur3);
    park.addDinosaur(dinosaur4);
    park.removeDinosaursOfType("Tyrannosaurus");
    const result = park.enclosure;
    assert.deepStrictEqual(result, [dinosaur4]);
  });

  it('should not remove anything if type is not in enclosure', function() {
    park.addDinosaur(dinosaur1);
    park.addDinosaur(dinosaur2);
    park.addDinosaur(dinosaur3);
    park.addDinosaur(dinosaur4);
    park.removeDinosaursOfType("Tryceratops");
    const result = park.enclosure;
    assert.deepStrictEqual(result, [dinosaur1, dinosaur2, dinosaur3, dinosaur4]);
  });

  it('should return all dinosaurs with offspring count of more than 2', function() {
    park.addDinosaur(dinosaur1);
    park.addDinosaur(dinosaur2);
    park.addDinosaur(dinosaur3);
    park.addDinosaur(dinosaur4);
    const result = park.getDinosaursWithMoreThan2OffspringCount();
    assert.deepStrictEqual(result, [dinosaur1, dinosaur3, dinosaur4]);
  });

  describe('Future projections', function() {

    it('should calculate number of dinosaurs after a particular number of years', function() {
      park.addDinosaur(dinosaur1)
      const result1 = park.numberOfDinosaursAfterYear(1);
      assert.strictEqual(result1, 4);
      const result2 = park.numberOfDinosaursAfterYear(2);
      assert.strictEqual(result2, 16);
      park.addDinosaur(dinosaur2)
      const result3 = park.numberOfDinosaursAfterYear(2);
      assert.strictEqual(result3, 25);
      const result4 = park.numberOfDinosaursAfterYear(0);
      assert.strictEqual(result4, 2);
      const result5 = park.numberOfDinosaursAfterYear(-5);
      assert.strictEqual(result5, undefined);
    });

  });
});
