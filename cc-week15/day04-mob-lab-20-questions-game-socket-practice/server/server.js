const express = require('express');
const app = express();
const http = require('http').Server(app);
const io = require('socket.io')(http);

// allows cross origin resource sharing
app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "http://localhost:3000");
  res.header("Access-Control-Allow-Credentials", true);
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});

io.on('connection', (socket) => {
  socket.on('question', (question) => {
    io.sockets.emit('question', question);
  });
  socket.on('answer', (answer) => {
    io.sockets.emit('answer', answer)
  });
});

http.listen(3001, function () {
  console.log(`20 Questions app running on port ${this.address().port}`);
});
