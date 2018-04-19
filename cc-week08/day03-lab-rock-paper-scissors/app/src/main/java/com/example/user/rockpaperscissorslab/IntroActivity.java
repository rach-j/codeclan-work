package com.example.user.rockpaperscissorslab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {

    private Button enterButton;
    private TextView title;
    private TextView intro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        enterButton = findViewById(R.id.enter_button);
        title = findViewById(R.id.intro_header);
        intro = findViewById(R.id.intro_explanation);
    }

    public void onEnterButtonClicked(View clickedView) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
