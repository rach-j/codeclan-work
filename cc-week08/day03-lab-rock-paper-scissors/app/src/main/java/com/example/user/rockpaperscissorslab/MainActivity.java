package com.example.user.rockpaperscissorslab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView gameResult;
    private Button paperButton;
    private Button scissorsButton;
    private Button rockButton;
    private Button spockButton;
    private Button lizardButton;
    private TextView playerScore;
    private TextView computerScore;
    private Score score;
    private RockPaperScissorsGame game;
    private Choice userChoice;
    private Button[] buttonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameResult = findViewById(R.id.game_result);
        paperButton = findViewById(R.id.paper_button);
        scissorsButton = findViewById(R.id.scissor_button);
        rockButton = findViewById(R.id.rock_button);
        spockButton = findViewById(R.id.spock_button);
        lizardButton = findViewById(R.id.lizard_button);
        playerScore = findViewById(R.id.player_score);
        computerScore = findViewById(R.id.computer_score);
        score = new Score();
        game = new RockPaperScissorsGame();
        buttonArray = new Button[] {paperButton, scissorsButton, rockButton, spockButton, lizardButton};
    }

    public void onButtonClick(View buttonPressed) {
        if (buttonPressed == rockButton) {
            userChoice = Choice.ROCK;
        } else if (buttonPressed == paperButton) {
            userChoice = Choice.PAPER;
        } else if (buttonPressed == scissorsButton) {
            userChoice = Choice.SCISSORS;
        } else if (buttonPressed == spockButton) {
            userChoice = Choice.SPOCK;
        } else {
            userChoice = Choice.LIZARD;
        }

        String result = game.playGame(userChoice, score);
        gameResult.setText(result);
        playerScore.setText(score.getPlayerScore());
        computerScore.setText(score.getComputerScore());

        buttonPressed.setBackgroundColor(getResources().getColor(R.color.babyblue));

        for (Button button : buttonArray) {
            if (button != buttonPressed) {
                button.setBackgroundColor(getResources().getColor(R.color.originalButtonColor));
            }
        }
    }
}
