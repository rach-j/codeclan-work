package com.example.user.rockpaperscissorslab;

import android.content.Intent;

/**
 * Created by user on 21/03/2018.
 */

public class Score {

    Integer playerScore;
    Integer computerScore;
    public Score() {
        this.playerScore = 0;
        this.computerScore = 0;
    }

    public String getComputerScore() {
        return "Computer:" + '\n' + this.computerScore.toString();
    }

    public String getPlayerScore() {
        return "Player:" + '\n' + this.playerScore.toString();
    }

    public void addOneToPlayerScore() {
        this.playerScore += 1;
    }

    public void addOneToComputerScore()  {
        this.computerScore += 1;
    }
}
