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

eval("const CharacterData = __webpack_require__(/*! ./models/character_data.js */ \"./src/models/character_data.js\");\nconst CharacterView = __webpack_require__(/*! ./views/character_view.js */ \"./src/views/character_view.js\");\n\ndocument.addEventListener('DOMContentLoaded', () => {\nconst characterSelect = document.querySelector('#character-select');\nconst characterContainer = document.querySelector('#character-detail-view');\nconst characterView = new CharacterView(characterSelect, characterContainer);\nconst characterData = new CharacterData('https://rickandmortyapi.com/api/character/');\n\ncharacterSelect.addEventListener('change', (event) => {\n  const selectedIndex = event.target.value;\n  if (selectedIndex == 0) {\n      console.log('View all has been selected');\n    characterView.populatePage(characterData.data);\n    console.log(characterData.data);\n  } else {\n    const selectedCharacter = characterData.data[selectedIndex];\n    characterView.renderDetail(selectedCharacter);\n  }\n  // Ask if better way to do\n});\n\n  characterData.getData((data) => {\n    characterView.renderSelect(data)\n    characterView.populatePage(data)});\n});\n\n\n//# sourceURL=webpack:///./src/app.js?");

/***/ }),

/***/ "./src/helpers/request.js":
/*!********************************!*\
  !*** ./src/helpers/request.js ***!
  \********************************/
/*! no static exports found */
/***/ (function(module, exports) {

eval("const Request = function(url) {\n  this.url = url;\n};\n\nRequest.prototype.get = function(onComplete) {\n  const request = new XMLHttpRequest();\n  request.open('GET', this.url);\n  request.addEventListener('load', function() {\n    if(this.status !== 200) {\n      return;\n    }\n\n    const responseBody = JSON.parse(this.responseText);\n    onComplete(responseBody);\n  });\n  request.send();\n};\n\nmodule.exports = Request;\n\n\n//# sourceURL=webpack:///./src/helpers/request.js?");

/***/ }),

/***/ "./src/models/character_data.js":
/*!**************************************!*\
  !*** ./src/models/character_data.js ***!
  \**************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

eval("const Request = __webpack_require__(/*! ../helpers/request.js */ \"./src/helpers/request.js\");\n\nconst CharacterData = function(url) {\n  this.url = url;\n  this.data = null;\n}\n\nCharacterData.prototype.getData = function (onComplete) {\n  const request = new Request(this.url);\n  request.get((data) => {\n    this.data = data.results;\n    this.data.unshift({\"name\": \"View all\"});\n    // Ask if better way to do\n    onComplete(this.data);\n  });\n}\n\nmodule.exports = CharacterData;\n\n\n//# sourceURL=webpack:///./src/models/character_data.js?");

/***/ }),

/***/ "./src/views/character_view.js":
/*!*************************************!*\
  !*** ./src/views/character_view.js ***!
  \*************************************/
/*! no static exports found */
/***/ (function(module, exports) {

eval("const CharacterView = function (selectElement, characterContainer) {\n  this.selectElement = selectElement;\n  this.characterContainer = characterContainer;\n}\n\nCharacterView.prototype.renderSelect = function (characterData) {\n  characterData.forEach((character, index) => {\n    const characterOption = document.createElement('option');\n    characterOption.textContent = character.name;\n    characterOption.value = index;\n    this.selectElement.appendChild(characterOption);\n  });\n}\n\nCharacterView.prototype.populatePage = function (characterData) {\n  const characterList = document.querySelector('#character-detail-view');\n  characterList.innerHTML = '';\n  characterData.forEach((character) => {\n    if (character.name === \"View all\") {\n      return;\n      // Ask if better way to do\n    }\n    const characterListItem = document.createElement('div');\n    characterListItem.classList.add('character-item');\n    const name = buildTextElement('h2', character.name);\n    characterListItem.appendChild(name);\n    const image = buildImageElement(character.image);\n    characterListItem.appendChild(image);\n    const gender = buildTextElement('p', `Gender: ${character.gender}`);\n    characterListItem.appendChild(gender);\n    const species = buildTextElement('p', `Species: ${character.species}`);\n    characterListItem.appendChild(species);\n    const origin = buildTextElement('p', `Origin: ${character.origin.name}`);\n    characterListItem.appendChild(origin);\n    const status = buildTextElement('p', `Status: ${character.status}`);\n    characterListItem.appendChild(status);\n    // Ask how to get bold for first bit whilst still keeping all on one line\n    characterList.appendChild(characterListItem);\n  });\n}\n\nCharacterView.prototype.renderDetail = function (character) {\n  const characterList = document.querySelector('#character-detail-view');\n  this.populatePage([character]);\n};\n\nconst buildTextElement = function (tag, value) {\n  const textElement = document.createElement(tag);\n  textElement.textContent = value;\n  return textElement;\n}\n\nconst buildImageElement = function(value) {\n  const imageElement = document.createElement('img');\n  imageElement.src = value;\n  return imageElement;\n}\n\n\n\n\n\nmodule.exports = CharacterView;\n\n\n//# sourceURL=webpack:///./src/views/character_view.js?");

/***/ })

/******/ });