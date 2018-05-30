import React from 'react';
import Question from './Question.jsx';

const Guesser = ({onSubmit, questions, currentYesNoAnswer}) => {

  const questionNodes = questions.map((question) => {
    return <Question question={question}/>
  });

  return(
    <div>
      <form onSubmit={onSubmit}>
        <input type="text" name="question" placeholder="Enter your yes/no question"/>
        <input type="submit" onClick={onSubmit}/>
      </form>
      {questionNodes}
      <p>{currentYesNoAnswer ? `${currentYesNoAnswer}`: ``}</p>
    </div>
  );
};

export default Guesser;
