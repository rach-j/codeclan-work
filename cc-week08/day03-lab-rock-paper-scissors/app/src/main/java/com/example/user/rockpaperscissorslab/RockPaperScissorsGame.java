package com.example.user.rockpaperscissorslab;

import android.provider.Settings;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import static android.provider.Settings.Secure.getString;

/**
 * Created by user on 21/03/2018.
 */

public class RockPaperScissorsGame {

    HashMap<Choice, Choice[]> choices;



    public RockPaperScissorsGame() {
        setUpChoices();
    }

    private void setUpChoices() {
        this.choices = new HashMap<>();
        choices.put(Choice.ROCK, new Choice[]{Choice.SCISSORS, Choice.LIZARD});
        choices.put(Choice.PAPER, new Choice[]{Choice.ROCK, Choice.SPOCK});
        choices.put(Choice.SCISSORS, new Choice[]{Choice.PAPER, Choice.LIZARD});
        choices.put(Choice.LIZARD, new Choice[]{Choice.PAPER, Choice.SPOCK});
        choices.put(Choice.SPOCK, new Choice[]{Choice.SCISSORS, Choice.ROCK});

    }

    public ArrayList<Choice> getAllChoices() {
        ArrayList<Choice> choicesArray = new ArrayList<>();

        for(Choice choiceKey: choices.keySet()) {
            choicesArray.add(choiceKey);
        }
        return choicesArray;
    }

    public Choice getComputerAnswer() {
        ArrayList<Choice> choicesArray = getAllChoices();
        Collections.shuffle(choicesArray);
        return choicesArray.get(0);
    }


    public String compareChoices(Choice userChoice, Choice computerChoice, Score score) {
        if (userChoice == computerChoice) {
            return "you drew!";
        } else if (Arrays.asList(choices.get(userChoice)).contains(computerChoice)) {
            score.addOneToPlayerScore();
            return "you won!";
        } else {
            score.addOneToComputerScore();
            return "you lost!";
        }
    }

    public String playGame(Choice userChoice, Score score) {
        Choice computerChoice = getComputerAnswer();

        String result = compareChoices(userChoice, computerChoice, score);

        return "You chose " + userChoice + '\n' + "The computer chose " + computerChoice + "... " + result;

    }


}
