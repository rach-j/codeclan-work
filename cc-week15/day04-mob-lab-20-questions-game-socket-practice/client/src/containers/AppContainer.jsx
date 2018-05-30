import React from 'react';
import Chooser from '../components/Chooser.jsx';
import Guesser from '../components/Guesser.jsx';
import io from 'socket.io-client';
import Message from '../components/Message';
import './AppContainer.css';
import { BrowserRouter as Router, Route } from 'react-router-dom';

export default class AppContainer extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      questions: [],
      correctAnswer: null,
      questionCount: 0,
      currentYesNoAnswer: null
    };

    this.socket = io('http://localhost:3001');
    this.socket.on('question', (question) => {
      this.addQuestion(question)
    });
    this.socket.on('answer', (answer) => {
      this.setState({currentYesNoAnswer: answer })
    });
    this.submitCorrectAnswerForm = this.submitCorrectAnswerForm.bind(this);
    this.submitQuestionForm = this.submitQuestionForm.bind(this);
    this.submitYesButton = this.submitYesButton.bind(this);
    this.submitNoButton = this.submitNoButton.bind(this);
  };

  addMessage(message){
    const messages = this.state.messages;
    const newMessages = [message, ...messages];
    this.setState({
      messages: newMessages
    });
  }

  submitCorrectAnswerForm(event) {
    event.preventDefault();

    if (event.target.form[0].value) {
      this.setState({correctAnswer: event.target.form[0].value});
    };
  };

  submitQuestionForm(event) {
    event.preventDefault();
    const submittedQuestion = event.target.form[0].value;
    this.socket.emit('question', submittedQuestion);
    event.target.form.reset();
    this.setState({currentYesNoAnswer: null});
  };

  addQuestion(question) {
    const questions = this.state.questions;
    const newQuestions = [question, ...questions];
    this.setState({
      questions: newQuestions
    });
  };

  submitYesButton() {
    this.socket.emit('answer', 'yes');
  };

  submitNoButton() {
    this.socket.emit('answer', 'no');
  };

  render() {
    return (
      <Router>
        <div>
          {/* <Route exact path='/' component={Home}/> */}
          <Route
            path='/guesser'
            render={() => {
              return <Guesser
                onSubmit={this.submitQuestionForm}
                questions={this.state.questions}
                currentYesNoAnswer= {this.state.currentYesNoAnswer}/>
              }
            }/>
            <Route
              path='/chooser'
              render={() => {
                return <Chooser
                  onSubmit={this.submitCorrectAnswerForm}
                  question={this.state.questions[0]}
                  submitYesButton={this.submitYesButton}
                  submitNoButton={this.submitNoButton}
                />
              }
            }/>
          </div>
        </Router>
      );
    };
  };
