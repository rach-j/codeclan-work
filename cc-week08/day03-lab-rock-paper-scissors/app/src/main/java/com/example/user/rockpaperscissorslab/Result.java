package com.example.user.rockpaperscissorslab;

/**
 * Created by user on 21/03/2018.
 */

public enum Result {
    WIN("win"),
    LOSE("lose"),
    DRAW("draw");

    private String value;

    Result(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
