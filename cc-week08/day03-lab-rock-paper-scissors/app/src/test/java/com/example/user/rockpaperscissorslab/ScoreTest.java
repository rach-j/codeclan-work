package com.example.user.rockpaperscissorslab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 21/03/2018.
 */

public class ScoreTest {

    Score gameScore;

    @Before
    public void before() {
        gameScore = new Score();
    }

    @Test
    public void canGetPlayerScore() {
        assertEquals("Player:" +'\n'+ "0", gameScore.getPlayerScore().toString());
    }

    @Test
    public void canGetComputerScore() {
        assertEquals("Computer:" +'\n'+ "0", gameScore.getComputerScore().toString());
    }

    @Test
    public void canUpdatePlayerScore() {
        gameScore.addOneToPlayerScore();
        assertEquals("Player:" +'\n'+ "1", gameScore.getPlayerScore().toString());
    }

    @Test
    public void canUpdateComputerScore() {
        gameScore.addOneToComputerScore();
        assertEquals("Computer:" +'\n'+ "1" , gameScore.getComputerScore().toString());
    }
}
