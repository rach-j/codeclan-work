const assert = require('assert');
const Hero = require('../hero.js');
const Task = require('../task.js');
const Food = require('../food.js');
const Rat = require('../rat.js');

describe('Hero', function() {
  let hero;
  let task1;
  let task2;
  let task3;
  let food1;
  let food2;
  let rat;

  beforeEach(function() {
      food1 = new Food("Banana", 5);
      food2 = new Food("Houmous", 6);
      hero = new Hero("Hercules", 20, food2, []);
      task1 = new Task("Slay the dragon", 10, 2, 15);
      task2 = new Task("Update CV", 20, 1, 30);
      task3 = new Task("Acquire a sword", 5, 3,10);
      rat = new Rat("Ratty", 10, 3);
  });

  it('should have a name', function() {
    assert.strictEqual(hero.name, "Hercules");
  });

  it('should have a health value', function() {
    assert.strictEqual(hero.health, 20);
  });

  it('should have a favourite food', function() {
    assert.strictEqual(hero.favouriteFood, food2);
  });

  it('should have a list of tasks', function() {
    assert.deepStrictEqual(hero.taskList, []);
  });

  it('should have reward coins', function() {
    assert.strictEqual(hero.rewardCoins, 0);
  });

  it('should be able to talk', function() {
    assert.strictEqual(hero.talk(), "Behold the great Hercules! I am a hero of heroes.");
  });

  it('should be able to add a task', function() {
    hero.addTask(task1);
    assert.deepStrictEqual(hero.taskList, [task1]);
  });

  it('should be able to eat food', function() {
    hero.eatFood(food1);
    assert.strictEqual(hero.health, 25);
  });

  it('should have health go up by more when eating favourite food', function() {
    hero.eatFood(food2);
    assert.strictEqual(hero.health, 29);
  });

  it('should be able to sort all tasks by difficulty', function () {
    hero.addTask(task1);
    hero.addTask(task2);
    hero.addTask(task3);
    assert.deepStrictEqual(hero.sortTasksByDifficulty("all"), [task2, task1, task3]);
  });

  it('should be able to sort incomplete tasks by difficulty', function () {
    hero.addTask(task1);
    hero.addTask(task2);
    hero.addTask(task3);
    hero.markAsComplete(task1);
    assert.deepStrictEqual(hero.sortTasksByDifficulty(), [task2, task3]);
});

  it('should be able to sort all tasks by urgency', function () {
    hero.addTask(task1);
    hero.addTask(task2);
    hero.addTask(task3);
    assert.deepStrictEqual(hero.sortTasksByUrgency("all"), [task2, task1, task3]);
  });

  it('should be able to sort incomplete tasks by urgency', function () {
    hero.addTask(task1);
    hero.addTask(task2);
    hero.addTask(task3);
    hero.markAsComplete(task1);
    assert.deepStrictEqual(hero.sortTasksByUrgency(), [task2, task3]);
  });

  it('should be able to sort all tasks by reward', function () {
    hero.addTask(task1);
    hero.addTask(task2);
    hero.addTask(task3);
    assert.deepStrictEqual(hero.sortTasksByReward("all"), [task2, task1, task3]);
  });

  it('should be able to sort incomplete tasks by reward', function () {
    hero.addTask(task1);
    hero.addTask(task2);
    hero.addTask(task3);
    hero.markAsComplete(task1);
    assert.deepStrictEqual(hero.sortTasksByReward(), [task2, task3]);
  });

  it('should be able to mark a task as complete where it is in the list of tasks', function () {
    hero.addTask(task1);
    hero.markAsComplete(task1);
    assert.strictEqual(hero.taskList[0].completionStatus, true);
    assert.strictEqual(hero.rewardCoins, 15);
  });

  it('should do nothing where task to mark as complete does not exist in the list of tasks', function () {
    hero.addTask(task1);
    hero.addTask(task2);
    hero.markAsComplete(task3);
    assert.strictEqual(hero.taskList.length, 2);
    assert.strictEqual(hero.taskList[0].completionStatus, false);
    assert.strictEqual(hero.taskList[1].completionStatus, false);
  });

  it('should be able to show all completed tasks', function () {
    hero.addTask(task1);
    hero.addTask(task2);
    hero.addTask(task3);
    hero.markAsComplete(task1);
    assert.deepStrictEqual(hero.viewCompletedTasks(), [task1]);
  });

  it('should be able to show all incomplete tasks', function () {
    hero.addTask(task1);
    hero.addTask(task2);
    hero.addTask(task3);
    hero.markAsComplete(task1);
    assert.deepStrictEqual(hero.viewIncompleteTasks(), [task2, task3]);
  });

  it('should lose health after eating food a rat has touched', function () {
    rat.touchFood(food1);
    hero.eatFood(food1);
    assert.strictEqual(rat.health, 15);
    assert.strictEqual(food1.replenishmentValue, -3);
    assert.strictEqual(hero.health, 17);
  });

});
