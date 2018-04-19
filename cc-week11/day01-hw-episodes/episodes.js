// Episode 1
const name = 'Keith';

const printName = function () {
  console.log(`My name is ${ name }`);
}

printName();

// Output will be 'My name is Keith'.

// The function that is called prints out 'My name is ' plus a variable called
// 'name' which has been set to the string 'Keith'.

// Episode 2
const score = 5;

const result = function () {
  const score = 3;
  return score;
}

console.log(result());

// Output will be 3.
// The function called result defines a new 'const' variable called score, sets it
// equal to 3 then returns it so this is what is printed out when it is called
// in console.log. The 'const' score within the function is completely
// independent of the 'const' score outside of the function (which is not used
// anywhere).

// Episode 3
const myAnimals = ['Chickens', 'Cats', 'Rabbits'];

const listAnimals = function () {
  myAnimals = ['Ducks', 'Dogs', 'Lions'];

  for (const i = 0; i < myAnimals.length; i++) {
    console.log(`${ i }: ${ myAnimals[i] }`);
  }
}

listAnimals();

// Output will be an error message. Because the myAnimals array within the function is
// not set as a new variable (i.e. it doesn't have var / const / let in front
// of it), it is taken to be the myAnimals array defined outside of the
// function. Because this is set up as a 'const', it cannot then be reassigned
// in the function.

// Episode 4
const suspectOne = 'Jay';
const suspectTwo = 'Val';
const suspectThree = 'Keith';
const suspectFour = 'Rick';

const allSuspects = function () {
  const suspectThree = 'Harvey';
  console.log('Suspects include:', suspectOne, suspectTwo, suspectThree, suspectFour);
}

allSuspects();
console.log(`Suspect three is: ${ suspectThree }`);

// Output will be:
// Suspects include: 'Jay', 'Val', 'Harvey', 'Rick'
// Suspect three is: 'Keith'
// Similar to Episode 2, the function called allSuspects defines a new 'const'
// variable called suspectThree, sets it equal to 'Harvey' then prints it along
// with the other const suspects defined outside the function. Once outside the
// function the const suspectThree defined within the function is no longer
// accessible so the second console.log prints out the suspectThree string
// defined outside the function.

// Episode 5
const detective = {
  name: 'Ace Ventura',
  pet: 'monkey'
};

const printName = function (detective) {
  return detective.name;
}

const detectiveInfo = function () {
  detective['name'] = 'Poirot';
  return printName(detective);
}

console.log(detectiveInfo());

// Output will be an error message because the function called printName was
// defined as a 'const' in Episode 1 so can't then be reassigned to a new
// function here, so when it is called within the detectiveInfo
// function an error message is triggered.

// Episode 6
const murderer = 'rick';

const outerFunction = function () {
  const murderer = 'marc';

  const innerFunction = function () {
    murderer = 'valerie';
  }

  innerFunction();
}

outerFunction();
console.log(`The murderer is: ${ murderer }`);

// Output will be an error message because within the innerFunction an attempt
// is made to reassign the murderer variable. This function is then called
// within the outerFunction so when the outerFunction is called the
// innerFunction and hence the error message will be triggered.
