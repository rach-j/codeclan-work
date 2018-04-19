const Hero = function(name, health, favouriteFood, taskList) {
  this.name = name;
  this.health = health;
  this.favouriteFood = favouriteFood;
  this.taskList = taskList
  this.rewardCoins = 0;
  this.talk = function() {
    return `Behold the great ${this.name}! I am a hero of heroes.`
  }
}

Hero.prototype.addTask = function (task) {
  this.taskList.push(task);
};

Hero.prototype.eatFood = function (food) {
  if(food === this.favouriteFood) {
      this.health += (food.replenishmentValue * 1.5);
  } else {
      this.health += food.replenishmentValue;
  }
};

Hero.prototype.sortTasksByDifficulty = function (allOrIncomplete) {
  let listToReturn = this.viewIncompleteTasks();
  if (allOrIncomplete === "all") {
    listToReturn = this.taskList;
  }

    listToReturn.sort((i,j) => {return (j.difficultyLevel - i.difficultyLevel)});
    return listToReturn;
}

Hero.prototype.sortTasksByUrgency = function (allOrIncomplete) {
  let listToReturn = this.viewIncompleteTasks();
  if (allOrIncomplete === "all") {
    listToReturn = this.taskList;
  }

  listToReturn.sort((i,j) => {return (i.urgencyLevel - j.urgencyLevel)});
  return listToReturn;
};

Hero.prototype.sortTasksByReward = function (allOrIncomplete) {
  let listToReturn = this.viewIncompleteTasks();
  if (allOrIncomplete === "all") {
    listToReturn = this.taskList;
  }

  listToReturn.sort((i,j) => {return (j.reward - i.reward)});
  return listToReturn;
};

Hero.prototype.markAsComplete = function (taskToMarkAsComplete) {
  this.taskList.forEach(task => {
    if (task === taskToMarkAsComplete) {
      task.markAsComplete();
      this.rewardCoins += task.reward;
    }
  });
};

Hero.prototype.viewCompletedTasks = function () {
  const completedTasks = this.taskList.filter(task => {return task.completionStatus});
  return completedTasks;
};

Hero.prototype.viewIncompleteTasks = function () {
  const incompleteTasks = this.taskList.filter(task => {return !task.completionStatus});
  return incompleteTasks;
};


module.exports = Hero;
