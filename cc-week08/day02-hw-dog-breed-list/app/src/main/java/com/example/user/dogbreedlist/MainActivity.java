package com.example.user.dogbreedlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TopDogsUK topDogsUK = new TopDogsUK();
        ArrayList<Dog> list = topDogsUK.getList();

        TopDogsUKAdapter dogAdapter =new TopDogsUKAdapter(this, list);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(dogAdapter);
    }
}
