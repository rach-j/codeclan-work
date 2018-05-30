import React from 'react';
import Question from './Question.jsx';

const Chooser = ({onSubmit, question, submitYesButton, submitNoButton}) => {
  return (
    <div>
    <form onSubmit={onSubmit}>
      <input type="text" name="correctAnswer" placeholder="Enter your chosen celebrity"/>
      <input type="submit" onClick={onSubmit}/>
    </form>
    <Question question={question}/>
    <button onClick={submitYesButton}>Yes</button>
    <button onClick={submitNoButton}>No</button>
    </div>
  );
};

export default Chooser;
