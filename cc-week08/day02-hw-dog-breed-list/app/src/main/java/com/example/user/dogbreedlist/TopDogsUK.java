package com.example.user.dogbreedlist;

import java.util.ArrayList;

/**
 * Created by user on 20/03/2018.
 */

public class TopDogsUK {

    private ArrayList<Dog> list;

    public TopDogsUK() {
        list = new ArrayList<>();
        list.add(new Dog(1,"Labrador", R.drawable.labrador));
        list.add(new Dog(2,"Mixed Breed", R.drawable.mongrel));
        list.add(new Dog(3,"Jack Russell", R.drawable.jackrussell));
        list.add(new Dog(4,"Staffordshire Bull Terrier", R.drawable.staffordshirebullterrier));
        list.add(new Dog(5,"Border Collie", R.drawable.bordercollie));
        list.add(new Dog(6,"Cocker Spaniel", R.drawable.cockerspaniel));
        list.add(new Dog(7,"Cockapoo", R.drawable.cockapoo));
        list.add(new Dog(8,"German Shepherd", R.drawable.germanshepherd));
        list.add(new Dog(9,"Springer Spaniel", R.drawable.springerspaniel));
        list.add(new Dog(10,"Cavalier King Charles Spaniel", R.drawable.cavalierkingcharlesspaniel));
        list.add(new Dog(11,"Pug", R.drawable.pug));
        list.add(new Dog(12,"Shih-Tzu", R.drawable.shihtzu));
        list.add(new Dog(13,"West Highland Terrier", R.drawable.westhighlandterrier));
        list.add(new Dog(14,"Labradoodle", R.drawable.labradoodle));
        list.add(new Dog(15,"Yorkshire Terrier", R.drawable.yorkshireterrier));
        list.add(new Dog(16,"Golden Retriever", R.drawable.goldenretriever));
        list.add(new Dog(17,"Daschund", R.drawable.daschund));
        list.add(new Dog(18,"Boxer", R.drawable.boxer));
        list.add(new Dog(19,"Chihuahua", R.drawable.chihuahua));
        list.add(new Dog(20,"Greyhound", R.drawable.greyhound));
        list.add(new Dog(21,"Border Terrier", R.drawable.borderterrier));
        list.add(new Dog(22,"Poodle", R.drawable.poodle));
        list.add(new Dog(23,"Beagle", R.drawable.beagle));
        list.add(new Dog(24,"Lurcher", R.drawable.lurcher));
        list.add(new Dog(25,"Bichon Frise", R.drawable.bichonfrise));
    }

    public ArrayList<Dog> getList() {
        return new ArrayList<>(list);
    }
}
