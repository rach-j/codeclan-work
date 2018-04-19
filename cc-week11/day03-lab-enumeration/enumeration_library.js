const EnumerationLibrary = function(array) {
  this.array = array
}

EnumerationLibrary.prototype.find = function(callback) {
  //   for (const item of this.array) {
  //     if(callback(item)) {
  //       return item;
  //     }
  //   }
  // }

  let selectedItem;

  this.array.forEach((item) => {

    if (callback(item) && (typeof selectedItem === 'undefined' )) {
      selectedItem = item;
    }
  })
  return selectedItem;
}

EnumerationLibrary.prototype.map = function(callback) {
  // const reducedPriceArray =[];
  //
  // for (const item of this.array) {
  //   reducedPriceArray.push(callback(item));
  // }
  // return reducedPriceArray;
  const reducedPriceArray = [];

  this.array.forEach((item) =>{
    reducedPriceArray.push(callback(item));
  });
  return reducedPriceArray;
}

EnumerationLibrary.prototype.filter = function(callback) {
  // const filteredArray = [];
  //
  // for(const item of this.array) {
  //   if(callback(item)) {
  //     filteredArray.push(callback(item));
  //   }
  // }
  // return filteredArray;
  const filteredArray = [];

  this.array.forEach((item) => {
    if(callback(item)){
      filteredArray.push(callback(item));
    }
  });
  return filteredArray;
}

EnumerationLibrary.prototype.some = function(callback) {
  // for (const item of this.array) {
  //   if(callback(item)) {
  //     return true;
  //   }
  // }
  // return false;

  let result = false;
  this.array.forEach((item) => {
    if(callback(item)) {
      result = true;
    }
  });
  return result;
}

EnumerationLibrary.prototype.every = function(callback) {
  // for (const item of this.array) {
  //   if(!callback(item)) {
  //     return false;
  //   }
  // }
  // return true;

  let result = true;
  this.array.forEach((item) => {
    if(!callback(item)) {
      result = false;
    }
  });
  return result;
}


module.exports = EnumerationLibrary;
