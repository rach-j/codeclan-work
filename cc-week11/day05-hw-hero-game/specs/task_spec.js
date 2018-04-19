const assert = require('assert');
const Task = require('../task.js');

describe('Task', function() {
  let task;

  beforeEach(function () {
    task = new Task("Slay the dragon",10, 1, 15);
  });

  it('should have a name', function() {
    assert.strictEqual(task.name, "Slay the dragon");
  });

  it('should have a difficultyLevel', function() {
    assert.strictEqual(task.difficultyLevel, 10);
  });

  it('should have a urgency level', function() {
    assert.strictEqual(task.urgencyLevel, 1);
  });

  it('should have a reward', function() {
    assert.strictEqual(task.reward, 15);
  });

  it('should have a completion status', function() {
    assert.strictEqual(task.completionStatus, false);
  });

  it('should be able to be marked as complete', function() {
    task.markAsComplete()
    assert.strictEqual(task.completionStatus, true);
  });

});
