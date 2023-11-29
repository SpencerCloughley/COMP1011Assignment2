package com.example.comp1011assignment2;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NowPlaying {
    private ArrayList<Movie> results;
    @SerializedName("total_results")
    private int totalResults;

    public int getTotalResults() {
        return totalResults;
    }

    public ArrayList<Movie> getResults() {
        return results;
    }
}
