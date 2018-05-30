export const setupBoard = function () {
    const gameBoard= []

  const cell = function(i,j) {
    return {
      RowId: i,
      ColumnId: j,
      state: 'empty'
    }
  }

  for (let i = 0; i < 6; i ++) {
    gameBoard.push([cell(i,0),cell(i,1), cell(i,2), cell(i,3), cell(i,4), cell(i,5), cell(i,6)]);
  }
  return gameBoard;
}

export const tokenDrop = function(columnChoice, playerColour, gameBoard) {
  for (let i=5; i>=0; i--) {
    if(gameBoard[i][columnChoice].state === 'empty') {
      gameBoard[i][columnChoice].state = playerColour;
      return [gameBoard, i, columnChoice];
    }
  }
}

export const checkForWinner = function(i, j, gameBoard, activePlayer) {
  const check1 = checkForWinnerLeftToRight(i,j,gameBoard, activePlayer);
  const check2 = checkForWinnerTopLeftToBottomRight(i,j,gameBoard, activePlayer);
  const check3 = checkForWinnerTopRightToBottomLeft(i,j,gameBoard, activePlayer);
  const check4 = checkForWinnerTopToBottom(i,j,gameBoard, activePlayer);

  return (check1 || check2 || check3 || check4)
}

  const checkForWinnerLeftToRight = function(i,j, gameBoard, activePlayer) {
  const numI = parseInt(i);
  const numJ = parseInt(j);
  if(
    (checkCell(numI,numJ+1, activePlayer, gameBoard) &&
    checkCell(numI,numJ+2, activePlayer, gameBoard)  &&
    checkCell(numI,numJ+3, activePlayer, gameBoard) ) ||
    (checkCell(numI,numJ-1, activePlayer, gameBoard)  &&
    checkCell(numI,numJ+1, activePlayer, gameBoard)  &&
    checkCell(numI,numJ+2, activePlayer, gameBoard) ) ||
    (checkCell(numI,numJ-2, activePlayer, gameBoard)  &&
    checkCell(numI,numJ-1, activePlayer, gameBoard)  &&
    checkCell(numI,numJ+1, activePlayer, gameBoard) ) ||
    (checkCell(numI,numJ-3, activePlayer, gameBoard)  &&
    checkCell(numI,numJ-2, activePlayer, gameBoard)  &&
    checkCell(numI,numJ-1, activePlayer, gameBoard) )
  )
  {
    return true
  } else {
    return false
  }
}

  const checkForWinnerTopLeftToBottomRight = function(i,j, gameBoard, activePlayer) {
  const numI = parseInt(i);
  const numJ = parseInt(j);
  if(
    (checkCell(numI+1,numJ+1, activePlayer, gameBoard) &&
    checkCell(numI+2,numJ+2, activePlayer, gameBoard)  &&
    checkCell(numI+3,numJ+3, activePlayer, gameBoard) ) ||
    (checkCell(numI-1,numJ-1, activePlayer, gameBoard)  &&
    checkCell(numI+1,numJ+1, activePlayer, gameBoard)  &&
    checkCell(numI+2,numJ+2, activePlayer, gameBoard) ) ||
    (checkCell(numI-2,numJ-2, activePlayer, gameBoard)  &&
    checkCell(numI-1,numJ-1, activePlayer, gameBoard)  &&
    checkCell(numI+1,numJ+1, activePlayer, gameBoard) ) ||
    (checkCell(numI-3,numJ-3, activePlayer, gameBoard)  &&
    checkCell(numI-2,numJ-2, activePlayer, gameBoard)  &&
    checkCell(numI-1,numJ-1, activePlayer, gameBoard) )
  )
  {
    return true
  } else {
    return false
  }
}

  const checkForWinnerTopRightToBottomLeft = function(i,j, gameBoard, activePlayer) {
  const numI = parseInt(i);
  const numJ = parseInt(j);
  if(
    (checkCell(numI+1,numJ-1, activePlayer, gameBoard) &&
    checkCell(numI+2,numJ-2, activePlayer, gameBoard)  &&
    checkCell(numI+3,numJ-3, activePlayer, gameBoard) ) ||
    (checkCell(numI-1,numJ+1, activePlayer, gameBoard)  &&
    checkCell(numI+1,numJ-1, activePlayer, gameBoard)  &&
    checkCell(numI+2,numJ-2, activePlayer, gameBoard) ) ||
    (checkCell(numI-2,numJ+2, activePlayer, gameBoard)  &&
    checkCell(numI-1,numJ+1, activePlayer, gameBoard)  &&
    checkCell(numI+1,numJ-1, activePlayer, gameBoard) ) ||
    (checkCell(numI-3,numJ+3, activePlayer, gameBoard)  &&
    checkCell(numI-2,numJ+2, activePlayer, gameBoard)  &&
    checkCell(numI-1,numJ+1, activePlayer, gameBoard) )
  )
  {
    return true
  } else {
    return false
  }
}

  const checkForWinnerTopToBottom = function(i,j, gameBoard, activePlayer) {
  const numI = parseInt(i);
  const numJ = parseInt(j);
  if(
    (checkCell(numI-1,numJ, activePlayer, gameBoard) &&
    checkCell(numI-2,numJ, activePlayer, gameBoard)  &&
    checkCell(numI-3,numJ, activePlayer, gameBoard) ) ||
    (checkCell(numI+1,numJ, activePlayer, gameBoard)  &&
    checkCell(numI-1,numJ, activePlayer, gameBoard)  &&
    checkCell(numI-2,numJ, activePlayer, gameBoard) ) ||
    (checkCell(numI+2,numJ, activePlayer, gameBoard)  &&
    checkCell(numI+1,numJ, activePlayer, gameBoard)  &&
    checkCell(numI-1,numJ, activePlayer, gameBoard) ) ||
    (checkCell(numI+3,numJ, activePlayer, gameBoard)  &&
    checkCell(numI+2,numJ, activePlayer, gameBoard)  &&
    checkCell(numI+1,numJ, activePlayer, gameBoard) )
  )
  {
    return true
  } else {
    return false
  }
}

const checkCell = function(i,j, activePlayer,gameBoard) {
  if(!gameBoard[i] || !gameBoard[i][j] || gameBoard[i][j].state !== activePlayer) {
    return false
  } else {
    return true
  }
}


// const checkGameState = function() {
//   if (checkTLtoBR() || checkTtoB() || checkTRtoBL() || checkLtoR()) {
//     return true;
//   }
//   return false;
// }


// const checkTLtoBR = function(playerSelectedPosition, playerColour) {
//   const rowPostion = playerSelectedPosition.RowId;
//   const columnPosition = playerSelectedPosition.ColumnId;
//   if(cell(rowPostion -1, columnPosition -1).state === playerColour) {
//
//   }
// }
// checkCellBRtoTL = function(x,y) {
//   const numberInARow = 1;
//   if(cell(rowPosition + x, columnPosition + y).state === playerColour) {
//     if (x < 0) {
//       x -= 1;
//     } else {
//       x +=1;
//     }
//     if (y < 0) {
//       y -= 1;
//     } else {
//       y += 1;
//     }
//
//     checkCellNextTo(x,y)
//     numberInARow += 1;
//   }
