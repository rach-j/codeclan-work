package com.example.user.dogbreedlist;

import java.io.Serializable;

/**
 * Created by user on 20/03/2018.
 */

public class Dog implements Serializable {

    private Integer ukRanking;
    private String breed;
    private Integer image;

    public Dog(int ukRanking, String breed, Integer image) {
        this.breed = breed;
        this.ukRanking = ukRanking;
        this.image = image;
    }

    public String getBreed() {
        return this.breed;
    }

    public Integer getRanking() {
        return this.ukRanking;
    }

    public Integer getImage() {
        return this.image;
    }

}
