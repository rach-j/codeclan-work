package com.example.user.wordcounterlab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 19/03/2018.
 */

public class StringFunctionsTest {

    StringFunctions stringFunctions;

    @Before
    public void before() {
        stringFunctions = new StringFunctions("It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity");
    }

    @Test
    public void canGetWordCount() {
        assertEquals(36, stringFunctions.wordCount());
    }

    @Test
    public void canGetWordTally() {
        assertEquals("was : 6, best : 1, epoch : 2, it : 6, wisdom : 1, the : 6, times : 2, incredulity : 1, foolishness : 1, of : 6, worst : 1, belief : 1, age : 2",stringFunctions.getWordTally());
    }

    @Test
    public void canGetOrderedWordTally() {
        assertEquals("was : 6, it : 6, the : 6, of : 6, epoch : 2, times : 2, age : 2, best : 1, wisdom : 1, incredulity : 1, foolishness : 1, worst : 1, belief : 1",stringFunctions.getSortedWordTally());
    }

//    Contrived result - didn't know what order would come out in - copied actual output.
}
