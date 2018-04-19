const EnumLibrary = require('../enumeration_library.js');
const assert = require('assert');

describe('My Enumeration Library', function() {

  let moonlight;
  let bladeRunner;
  let dunkirk;
  let trainspotting;
  let films;
  let myEnumLib;

  beforeEach(function() {
    moonlight = {
      title: "Moonlight",
      genre: "Drama",
      year: 2016,
      price: 10.00,
      length: 111
    };

    bladeRunner = {
      title: "Blade Runner 2049",
      genre: "Sci-Fi", year: 2017,
      price: 12.00,
      length: 164
    };

    dunkirk = {
      title: "Dunkirk",
      genre: "History",
      year: 2017,
      price: 6.00,
      length: 96
    };

    blackPanther = {
      title: "Black Panther",
      genre: "Action",
      year: 2018,
      price: 12.00,
      length: 134
    };

    trainspotting = {
      title: "T2 Trainspotting",
      genre: "Drama",
      year: 2017,
      price: 6.00,
      length: 117
    };

    films = [moonlight, bladeRunner, dunkirk, blackPanther, trainspotting];
    myEnumLib = new EnumLibrary(films);
  });

  it('should be able to find an item in an array (by movie title)', function() {
    const findByTitle = (film) => {
      return film.title === "Moonlight";
    }

    const actualFoundFilm = myEnumLib.find(findByTitle);
    assert.deepStrictEqual(actualFoundFilm, moonlight);
  })

  it('should be able to map an array (decrease prices by 50%)', function() {
    const decreaseByFiftyPercent = (film) => {
      film.price = film.price * 0.5;
      return film;
    }

    const actualDecreasedFilms = myEnumLib.map(decreaseByFiftyPercent);
    const expectedDecreasedFilms = [
      {
        title: "Moonlight",
        genre: "Drama",
        year: 2016,
        price: 5.00,
        length: 111
      },
      {
        title: "Blade Runner 2049",
        genre: "Sci-Fi",
        year: 2017,
        price: 6.00,
        length: 164
      },
      {
        title: "Dunkirk",
        genre: "History",
        year: 2017,
        price: 3.00,
        length: 96
      },
      {
        title: "Black Panther",
        genre: "Action",
        year: 2018,
        price: 6.00,
        length: 134
      },
      {
        title: "T2 Trainspotting",
        genre: "Drama",
        year: 2017,
        price: 3.00,
        length: 117
      }
    ];

    assert.deepStrictEqual(actualDecreasedFilms, expectedDecreasedFilms);
  });

  it('should be able to filter an array (by genre)', function() {
    const findByGenre = (film) => {
      if (film.genre === "Drama") return film;
    }

    const actualFoundFilms = myEnumLib.filter(findByGenre);
    assert.deepStrictEqual(actualFoundFilms, [moonlight, trainspotting]);
  });

  it('should be able to check if AT LEAST ONE element in an array meets a condition (if there is a film from 2018)', function() {
    const checkFor2018Film = (film) => {
      return film.year === 2018;
    }

    const actualResult = myEnumLib.some(checkFor2018Film);
    assert.strictEqual(actualResult, true);
  });

  it('should be able to check if none of the elements in an array meet a condition (if there is a film from 2012)', function() {
    const checkFor2018Film = (film) => {
      return film.year === 2012;
    }

    const actualResult = myEnumLib.some(checkFor2018Film);
    assert.strictEqual(actualResult, false);
  });

  it('should be able to check if every element in an array meets a condition (if every film is over 60 minutes in length)', function() {
    const checkAllFilmsAreOver60Mins = (film) => {
      return film.length > 60;
    }

    const actualResult = myEnumLib.every(checkAllFilmsAreOver60Mins);
    assert.strictEqual(actualResult, true);
  });

  it('should be able to check if not every element in an array meets a condition (if every film is over 150 minutes in length)', function() {
    const checkAllFilmsAreOver150Mins = (film) => {
      return film.length > 150;
    }

    const actualResult = myEnumLib.every(checkAllFilmsAreOver150Mins);
    assert.strictEqual(actualResult, false);
  });

});
