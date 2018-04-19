package com.example.user.wordcounterlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText stringEditText;
    private Button wordCountButton;
    private TextView wordCountView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stringEditText = findViewById(R.id.stringInput);
        wordCountButton = findViewById(R.id.button_for_word_count);
        wordCountView = findViewById(R.id.view_word_count);
    }

    public void onWordCountButtonClicked(View clickedView) {
        StringFunctions words = new StringFunctions(stringEditText.getText().toString());
        Log.d("MainActivity", "Test");
        Integer result = words.wordCount();
        String stringResult = result.toString();
        wordCountView.setText("There are " + stringResult + " words in this text.");
    }

    public void onWordTallyButtonClicked(View clickedView) {
        StringFunctions words = new StringFunctions(stringEditText.getText().toString());
        String result = words.getSortedWordTally();
        wordCountView.setText("The words and frequencies in this text are as follows: " + result);
    }
}
