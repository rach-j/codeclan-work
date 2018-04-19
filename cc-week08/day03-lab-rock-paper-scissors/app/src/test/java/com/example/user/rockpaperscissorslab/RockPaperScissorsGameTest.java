package com.example.user.rockpaperscissorslab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by user on 21/03/2018.
 */

public class RockPaperScissorsGameTest {

    RockPaperScissorsGame game;
    Score score;

    @Before
    public void before() {
        game = new RockPaperScissorsGame();
        score = new Score();
    }

    @Test
    public void canGetAllAnswers() {
        assertEquals(5, game.getAllChoices().size());
    }

    @Test
    public void canGetComputerAnswer() {
        assertNotNull(game.getComputerAnswer());
    }

    @Test
    public void canCompareChoices() {
        assertEquals("you won!", game.compareChoices(Choice.PAPER, Choice.ROCK, score));
        assertEquals("you won!", game.compareChoices(Choice.PAPER, Choice.SPOCK, score));
        assertEquals("you won!", game.compareChoices(Choice.ROCK, Choice.SCISSORS, score));
        assertEquals("you won!", game.compareChoices(Choice.ROCK, Choice.LIZARD, score));
        assertEquals("you won!", game.compareChoices(Choice.SCISSORS, Choice.PAPER, score));
        assertEquals("you won!", game.compareChoices(Choice.SCISSORS, Choice.LIZARD, score));
        assertEquals("you lost!", game.compareChoices(Choice.PAPER, Choice.SCISSORS, score));
        assertEquals("you lost!", game.compareChoices(Choice.PAPER, Choice.LIZARD, score));
        assertEquals("you lost!", game.compareChoices(Choice.ROCK, Choice.PAPER, score));
        assertEquals("you lost!", game.compareChoices(Choice.ROCK, Choice.SPOCK, score));
        assertEquals("you lost!", game.compareChoices(Choice.SCISSORS, Choice.ROCK, score));
        assertEquals("you lost!", game.compareChoices(Choice.SCISSORS, Choice.SPOCK, score));
        assertEquals("you drew!", game.compareChoices(Choice.PAPER, Choice.PAPER, score));
        assertEquals("you drew!", game.compareChoices(Choice.SCISSORS, Choice.SCISSORS, score));
        assertEquals("you drew!", game.compareChoices(Choice.ROCK, Choice.ROCK, score));
        assertEquals("you drew!", game.compareChoices(Choice.SPOCK, Choice.SPOCK, score));
        assertEquals("you drew!", game.compareChoices(Choice.LIZARD, Choice.LIZARD, score));

    }

//    @Test
//    public void canGetDisplay() {
//        assertEquals("", game.playGame(Choice.PAPER));
//    }
}
