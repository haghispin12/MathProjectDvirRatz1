package com.example.mathprojectdvirratz1;

import android.content.Intent;

public class User {
    private String User_name = "";
    private int score = 0;
    private RateActivity rate;


    public RateActivity getRate() {
        return rate;
    }

    public void setRate(RateActivity rate) {
        this.rate = rate;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
