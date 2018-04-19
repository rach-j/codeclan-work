let positionArray = [300, 250];

const app = function(){


  const canvas = document.getElementById('main-canvas');
  const context = canvas.getContext('2d');

  const buttonUp = document.querySelector('#button-up');
  buttonUp.addEventListener('click', onUpButtonClick);

  const buttonLeft = document.querySelector('#button-left');
  buttonLeft.addEventListener('click', onLeftButtonClick);

  const buttonRight = document.querySelector('#button-right');
  buttonRight.addEventListener('click', onRightButtonClick);

  const buttonDown = document.querySelector('#button-down');
  buttonDown.addEventListener('click', onDownButtonClick);

  const buttonReset = document.querySelector('#button-reset');
  buttonReset.addEventListener('click', onResetButtonClick);
}

document.addEventListener('DOMContentLoaded',app);

const onUpButtonClick = function(){
  const canvas = document.getElementById('main-canvas');
  console.dir(canvas);
  const context = canvas.getContext('2d');
  context.beginPath();
  let x = positionArray[0];
  let y = positionArray[1];
  context.moveTo(x,y);
  context.lineTo(x, y);
  if(y === 500 || y === 0){
  }else{
    y = y - 2;
  }
  context.lineTo(x, y);
  context.closePath();
  context.stroke();
  positionArray[0] = x;
  positionArray[1] = y;
  console.log(positionArray);

}

const onLeftButtonClick = function(){
  const canvas = document.getElementById('main-canvas');
  const context = canvas.getContext('2d');
  context.beginPath();
  let x = positionArray[0];
  let y = positionArray[1];
  context.moveTo(x,y);
  context.lineTo(x, y);
  if(x === 600 || x === 0){
  }else{
    x = x - 2;
  }
  context.lineTo(x, y);
  context.closePath();
  context.stroke();
  positionArray[0] = x;
  positionArray[1] = y;
  console.log(positionArray);

}

const onRightButtonClick = function(){
  const canvas = document.getElementById('main-canvas');
  const context = canvas.getContext('2d');
  context.beginPath();
  let x = positionArray[0];
  let y = positionArray[1];
  context.moveTo(x,y);
  context.lineTo(x, y);
  if(x === 600 || x === 0){
  }else{
    x = x + 2;
  }
  context.lineTo(x, y);
  context.closePath();
  context.stroke();
  positionArray[0] = x;
  positionArray[1] = y;
    console.log(positionArray);

}

const onDownButtonClick = function(){
  const canvas = document.getElementById('main-canvas');
  const context = canvas.getContext('2d');
  context.beginPath();
  let x = positionArray[0];
  let y = positionArray[1];
  context.moveTo(x,y);
  context.lineTo(x, y);
  if(y === 500 || y === 0){
  }else{
    y = y + 2;
  }
  context.lineTo(x, y);
  context.closePath();
  context.stroke();
  positionArray[0] = x;
  positionArray[1] = y;
  console.log(positionArray);

}

const onResetButtonClick = function(){
  const canvas = document.getElementById('main-canvas');
  const context = canvas.getContext('2d');
  context.clearRect(0, 0, canvas.width, canvas.height);
  positionArray = [300, 250];
  console.log(positionArray);

}
