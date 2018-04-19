package com.example.user.dogbreedlist;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 20/03/2018.
 */

public class TopDogsUKAdapter extends ArrayAdapter<Dog> {

    public TopDogsUKAdapter(Context context, ArrayList<Dog> list) {
        super(context,0, list);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {

        Dog currentDog = getItem(position);

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.dog_item, parent, false);
        }

        TextView ranking = listItemView.findViewById(R.id.ranking);
        ranking.setText(currentDog.getRanking().toString());


        TextView breed = listItemView.findViewById(R.id.breed);
        breed.setText(currentDog.getBreed());

        ImageView image = listItemView.findViewById(R.id.image);

        image.setImageResource(currentDog.getImage());

        listItemView.setTag(currentDog);

        return listItemView;
    }
}
