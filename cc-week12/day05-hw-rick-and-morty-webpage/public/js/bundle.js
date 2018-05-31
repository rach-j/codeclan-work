/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// define __esModule on exports
/******/ 	__webpack_require__.r = function(exports) {
/******/ 		Object.defineProperty(exports, '__esModule', { value: true });
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = "./src/app.js");
/******/ })
/************************************************************************/
/******/ ({

/***/ "./src/app.js":
/*!********************!*\
  !*** ./src/app.js ***!
  \********************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

eval("const CharacterData = __webpack_require__(/*! ./models/character_data.js */ \"./src/models/character_data.js\");\r\nconst CharacterView = __webpack_require__(/*! ./views/character_view.js */ \"./src/views/character_view.js\");\r\n\r\ndocument.addEventListener('DOMContentLoaded', () => {\r\nconst characterSelect = document.querySelector('#character-select');\r\nconst characterContainer = document.querySelector('#character-detail-view');\r\nconst characterView = new CharacterView(characterSelect, characterContainer);\r\nconst characterData = new CharacterData('https://rickandmortyapi.com/api/character/');\r\n\r\ncharacterSelect.addEventListener('change', (event) => {\r\n  const selectedIndex = event.target.value;\r\n  if (selectedIndex == 0) {\r\n      console.log('View all has been selected');\r\n    characterView.populatePage(characterData.data);\r\n    console.log(characterData.data);\r\n  } else {\r\n    const selectedCharacter = characterData.data[selectedIndex];\r\n    characterView.renderDetail(selectedCharacter);\r\n  }\r\n  // Ask if better way to do\r\n});\r\n\r\n  characterData.getData((data) => {\r\n    characterView.renderSelect(data)\r\n    characterView.populatePage(data)});\r\n});\r\n\n\n//# sourceURL=webpack:///./src/app.js?");

/***/ }),

/***/ "./src/helpers/request.js":
/*!********************************!*\
  !*** ./src/helpers/request.js ***!
  \********************************/
/*! no static exports found */
/***/ (function(module, exports) {

eval("const Request = function(url) {\r\n  this.url = url;\r\n};\r\n\r\nRequest.prototype.get = function(onComplete) {\r\n  const request = new XMLHttpRequest();\r\n  request.open('GET', this.url);\r\n  request.addEventListener('load', function() {\r\n    if(this.status !== 200) {\r\n      return;\r\n    }\r\n\r\n    const responseBody = JSON.parse(this.responseText);\r\n    onComplete(responseBody);\r\n  });\r\n  request.send();\r\n};\r\n\r\nmodule.exports = Request;\r\n\n\n//# sourceURL=webpack:///./src/helpers/request.js?");

/***/ }),

/***/ "./src/models/character_data.js":
/*!**************************************!*\
  !*** ./src/models/character_data.js ***!
  \**************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

eval("const Request = __webpack_require__(/*! ../helpers/request.js */ \"./src/helpers/request.js\");\r\n\r\nconst CharacterData = function(url) {\r\n  this.url = url;\r\n  this.data = null;\r\n}\r\n\r\nCharacterData.prototype.getData = function (onComplete) {\r\n  const request = new Request(this.url);\r\n  request.get((data) => {\r\n    this.data = data.results;\r\n    this.data.unshift({\"name\": \"View all\"});\r\n    // Ask if better way to do\r\n    onComplete(this.data);\r\n  });\r\n}\r\n\r\nmodule.exports = CharacterData;\r\n\n\n//# sourceURL=webpack:///./src/models/character_data.js?");

/***/ }),

/***/ "./src/views/character_view.js":
/*!*************************************!*\
  !*** ./src/views/character_view.js ***!
  \*************************************/
/*! no static exports found */
/***/ (function(module, exports) {

eval("const CharacterView = function (selectElement, characterContainer) {\r\n  this.selectElement = selectElement;\r\n  this.characterContainer = characterContainer;\r\n}\r\n\r\nCharacterView.prototype.renderSelect = function (characterData) {\r\n  characterData.forEach((character, index) => {\r\n    const characterOption = document.createElement('option');\r\n    characterOption.textContent = character.name;\r\n    characterOption.value = index;\r\n    this.selectElement.appendChild(characterOption);\r\n  });\r\n}\r\n\r\nCharacterView.prototype.populatePage = function (characterData) {\r\n  const characterList = document.querySelector('#character-detail-view');\r\n  characterList.innerHTML = '';\r\n  characterData.forEach((character) => {\r\n    if (character.name === \"View all\") {\r\n      return;\r\n      // Ask if better way to do\r\n    }\r\n    const characterListItem = document.createElement('div');\r\n    characterListItem.classList.add('character-item');\r\n    const name = buildTextElement('h2', character.name);\r\n    characterListItem.appendChild(name);\r\n    const image = buildImageElement(character.image);\r\n    characterListItem.appendChild(image);\r\n    const gender = buildTextElement('p', `Gender: ${character.gender}`);\r\n    characterListItem.appendChild(gender);\r\n    const species = buildTextElement('p', `Species: ${character.species}`);\r\n    characterListItem.appendChild(species);\r\n    const origin = buildTextElement('p', `Origin: ${character.origin.name}`);\r\n    characterListItem.appendChild(origin);\r\n    const status = buildTextElement('p', `Status: ${character.status}`);\r\n    characterListItem.appendChild(status);\r\n    // Ask how to get bold for first bit whilst still keeping all on one line\r\n    characterList.appendChild(characterListItem);\r\n  });\r\n}\r\n\r\nCharacterView.prototype.renderDetail = function (character) {\r\n  const characterList = document.querySelector('#character-detail-view');\r\n  this.populatePage([character]);\r\n};\r\n\r\nconst buildTextElement = function (tag, value) {\r\n  const textElement = document.createElement(tag);\r\n  textElement.textContent = value;\r\n  return textElement;\r\n}\r\n\r\nconst buildImageElement = function(value) {\r\n  const imageElement = document.createElement('img');\r\n  imageElement.src = value;\r\n  return imageElement;\r\n}\r\n\r\n\r\n\r\n\r\n\r\nmodule.exports = CharacterView;\r\n\n\n//# sourceURL=webpack:///./src/views/character_view.js?");

/***/ })

/******/ });