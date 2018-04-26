const express = require('express');
const parser = require('body-parser');
const server = express();

server.use(parser.json());
server.use(express.static('client/public'));

const MongoClient = require('mongodb').MongoClient;
const ObjectID = require('mongodb').ObjectID;

MongoClient.connect('mongodb://localhost:27017', function(err, client) {
  if(err) {
    console.log(err);
    return;
  }
  const db = client.db('star_wars')
  console.log('Connected to DB');

  const quotesCollection = db.collection('quotes');

  server.post('/api/quotes', function(req, res) {
    const newQuote = req.body;
    console.log(newQuote);
    quotesCollection.save(newQuote, function(err, result) {
      if (err) {
        console.error(err);
        res.status(500);
        res.send();
      } else {
        console.log('Saved!');
        res.status(201);
        res.json(result.ops[0]);
      }
    });
  });

  server.get('/api/quotes', function(req, res) {
    quotesCollection.find().toArray(function(err, allQuotes) {
      if (err) {
        console.error(err);
        res.status(500);
        res.send();
      } else {
        res.status(201);
        res.json(allQuotes);
      }
    });
  });

  server.delete('/api/quotes', function(req, res) {
    quotesCollection.deleteMany({}, function(err, result) {
      // or quotesCollection.deleteMany(function(err, allQuotes) {
      // or quotesCollection.deleteMany(null, function(err, allQuotes) {
      if (err) {
        console.error(err);
        res.status(500);
        res.send();
      } else {
        res.status(200);
        res.send();
        // Has to send something
      }
    });
  });

  server.put('/api/quotes/:id', function(req, res) {
    const updatedQuote = req.body;
    const id = req.params.id;
    const objectID = ObjectID(id);
    quotesCollection.update({_id: objectID}, updatedQuote, function(err, result) {
      if (err) {
        console.error(err);
        res.status(500);
        res.send();
      } else {
        res.status(200);
        res.send(result);
        // Has to send something
      }
    });
  });

  server.delete('/api/quotes/:id', function(req, res) {
    const id = req.params.id;
    const objectID = ObjectID(id);
    quotesCollection.deleteMany({_id: objectID}, function(err, result) {
      if (err) {
        console.error(err);
        res.status(500);
        res.send();
      } else {
        res.status(200);
        res.send();
        // Has to send something
      }
    });
  });

  server.get('/api/quotes/:id', function(req, res) {
    const id = req.params.id;
    const objectID = ObjectID(id);
    quotesCollection.find({_id: objectID}).toArray(function(err, result) {
      if (err) {
        console.error(err);
        res.status(500);
        res.send();
      } else {
        res.status(200);
        res.send(result);
        // Has to send something
      }
    });
  });

  server.listen(3000, function(){
    console.log("Listening on port 3000");
  });

});
