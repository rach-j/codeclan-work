const express = require('express');
const parser = require('body-parser');
const server = express();

server.use(parser.json());
server.use(express.static('client/public'));

const MongoClient = require('mongodb').MongoClient;
const ObjectID = require('mongodb').ObjectID;

MongoClient.connect('mongodb://localhost:27017', function(err, client) {
  if (err) {
    console.error(err);
    return;
  }
  const db = client.db('country_bucket_list');
  console.log('Connected to DB');
  const countryBucketList = db.collection('countries');

  // CREATE
  server.post('/api/countries_to_visit', function(req, res) {
    const chosenCountry = req.body;
    console.log(chosenCountry);

    countryBucketList.save(chosenCountry, function(err, result) {
      if (err) {
        console.error(err);
        res.status(500);
        res.send();
      };
      console.log('Saved');
      res.status(201);
      res.json(result.ops[0]);
    });
  });

  // INDEX
  server.get('/api/countries_to_visit', function(req, res) {
    countryBucketList.find().toArray(function(err, allCountries) {
      if (err) {
        console.error(err);
        res.status(500);
        res.send();
      }

      res.json(allCountries);
    });
  });

  server.listen(3000, function(){
    console.log("Listening on port 3000");
  });

  // DELETE ALL
server.delete('/api/countries_to_visit', function(req, res) {
  countryBucketList.deleteMany({}, function(err, result) {
    if (err) {
      console.error(err);
      res.status(500);
      res.send();
    }
    res.send();
  });
});

});
