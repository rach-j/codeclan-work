const express = require('express');
const BooksData = require('../data/books_data.js');
const booksData = new BooksData();
const allBooks = booksData.all();

const booksRouter = new express.Router();

booksRouter.get('/', function (req, res) {
  res.json({books: allBooks});
});

booksRouter.get('/:id', function(req, res) {
  const book = booksData.find(req.params.id)
  res.json({books: book});
})

booksRouter.post('/', function(req, res) {
  const newBook = req.body.book;
  booksData.add(newBook);
  res.json({books: allBooks});
});

booksRouter.put('/:id', function(req, res) {
  const newBook = req.body.book;
  const index = req.params.id;
  booksData.update(index, newBook);
  res.json({books: allBooks});
});

booksRouter.delete('/:id', function(req, res) {
  const index = req.params.id;
  booksData.delete(index);
  res.json({books: allBooks});
});

module.exports = booksRouter;
