const express = require('express');
const app = express();

app.use(express.static('public'));

app.get('/', function(req, res) {
  res.sendFile(`${__dirname}/index.html`);
});

const server = app.listen(3000, function() {
  console.log(`Example app listening on port ${this.address().port}`);
});
