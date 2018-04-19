const Task = function(name, difficultyLevel, urgencyLevel, reward) {
  this.name = name;
  this.difficultyLevel = difficultyLevel;
  this.urgencyLevel = urgencyLevel;
  this.reward = reward;
  this.completionStatus = false;
}

Task.prototype.markAsComplete = function () {
  this.completionStatus = true;
};

module.exports = Task;
